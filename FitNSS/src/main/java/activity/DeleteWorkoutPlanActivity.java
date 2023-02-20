package activity;

import activity.requests.DeleteWorkoutPlanRequest;
import activity.results.DeleteWorkoutPlanResult;
import dynamodb.WorkoutPlanDao;
import dynamodb.models.WorkoutPlan;
import exceptions.WorkoutPlanNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class DeleteWorkoutPlanActivity {

    private final Logger log = LogManager.getLogger();

    private final WorkoutPlanDao workoutPlanDao;

    @Inject
    public DeleteWorkoutPlanActivity(WorkoutPlanDao workoutPlanDao) {
        this.workoutPlanDao = workoutPlanDao;
    }

    public DeleteWorkoutPlanResult handleRequest(final DeleteWorkoutPlanRequest deleteWorkoutPlanRequest) {
        log.info("Received DeleteWorkoutPlanRequest {}", deleteWorkoutPlanRequest);

        if (deleteWorkoutPlanRequest.getWorkoutPlanId() == null) {
            throw new WorkoutPlanNotFoundException();
        }

        if (workoutPlanDao.getWorkoutPlan(deleteWorkoutPlanRequest.getWorkoutPlanId()) == null) {
            throw new WorkoutPlanNotFoundException();
        }

        WorkoutPlan workoutPlan = workoutPlanDao.getWorkoutPlan(deleteWorkoutPlanRequest.getWorkoutPlanId());

        if (!workoutPlan.getUserId().equals(deleteWorkoutPlanRequest.getUserId())) {
            throw new SecurityException("You must be the owner of this plan to delete it.");
        }

        workoutPlanDao.deleteWorkoutPlan(workoutPlan);

        return DeleteWorkoutPlanResult.builder()
                .withWorkoutPlan(workoutPlan)
                .build();
    }
}
