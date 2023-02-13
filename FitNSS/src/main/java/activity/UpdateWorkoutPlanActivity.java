package activity;

import activity.requests.UpdateWorkoutPlanRequest;
import activity.results.UpdateWorkoutPlanResult;
import dynamodb.WorkoutPlanDao;
import dynamodb.models.WorkoutPlan;
import exceptions.WorkoutPlanNotFoundException;
import models.WorkoutPlanModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class UpdateWorkoutPlanActivity {
    private final Logger log = LogManager.getLogger();
    private final WorkoutPlanDao workoutPlanDao;

    @Inject
    public UpdateWorkoutPlanActivity(WorkoutPlanDao workoutPlanDao) {
        this.workoutPlanDao = workoutPlanDao;
    }

    public UpdateWorkoutPlanResult handleRequest(final UpdateWorkoutPlanRequest updateWorkoutPlanRequest) {
        log.info("Received UpdateWorkoutPlanRequest {}", updateWorkoutPlanRequest);

        if (updateWorkoutPlanRequest.getWorkoutPlanId() == null || workoutPlanDao.getWorkoutPlan(updateWorkoutPlanRequest.getWorkoutPlanId()) == null) {
            throw new WorkoutPlanNotFoundException();
        }

        WorkoutPlan workoutPlan = workoutPlanDao.getWorkoutPlan(updateWorkoutPlanRequest.getWorkoutPlanId());

        if (!workoutPlan.getUserId().equals(updateWorkoutPlanRequest.getUserId())) {
            throw new SecurityException("You must own a workoutplan to update it.");
        }

        if (updateWorkoutPlanRequest.getUserId() != null) {
            workoutPlan.setUserId(updateWorkoutPlanRequest.getUserId());
        }

        if (updateWorkoutPlanRequest.getWorkoutDayName() != null) {
            workoutPlan.setWorkoutDayName(updateWorkoutPlanRequest.getWorkoutDayName());
        }

        if (updateWorkoutPlanRequest.getExercisesAdded() != null) {
            workoutPlan.setExercisesAdded(updateWorkoutPlanRequest.getExercisesAdded());
        }

        if (updateWorkoutPlanRequest.getNumberOfSets() != null) {
            workoutPlan.setNumberOfSets(updateWorkoutPlanRequest.getNumberOfSets());
        }

        if (updateWorkoutPlanRequest.getNumberOfReps() != null) {
            workoutPlan.setNumberOfReps(updateWorkoutPlanRequest.getNumberOfReps());
        }

        if (updateWorkoutPlanRequest.getNumberOfWeights() != null) {
            workoutPlan.setNumberOfWeights(updateWorkoutPlanRequest.getNumberOfWeights());
        }

        if (updateWorkoutPlanRequest.getNotesBox() != null) {
            workoutPlan.setNotesBox(updateWorkoutPlanRequest.getNotesBox());
        }

        workoutPlanDao.saveWorkoutPlan(workoutPlan);
        WorkoutPlanModel workoutPlanModel = new WorkoutPlanModel(workoutPlan);

        return UpdateWorkoutPlanResult.builder()
                .withWorkoutPlanModel(workoutPlanModel)
                .build();

    }
}
