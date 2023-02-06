package activity;

import activity.requests.GetAllWorkoutPlanRequest;
import activity.results.GetAllWorkoutPlanResult;
import dynamodb.WorkoutPlanDao;
import dynamodb.models.WorkoutPlan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.List;

public class GetAllWorkoutPlanActivity {
    private final Logger log = LogManager.getLogger();

    private final WorkoutPlanDao workoutPlanDao;

    @Inject
    public GetAllWorkoutPlanActivity(WorkoutPlanDao workoutPlanDao) {
        this.workoutPlanDao = workoutPlanDao;
    }

    public GetAllWorkoutPlanResult handleRequest(final GetAllWorkoutPlanRequest getAllWorkoutPlanRequest) {
        log.info("Received getAllWorkoutRequest {}", getAllWorkoutPlanRequest);
        String requestedWorkoutPlanId = getAllWorkoutPlanRequest.getWorkoutPlanId();
        List<WorkoutPlan> workoutPlanList = workoutPlanDao.getAllWorkoutPlans(requestedWorkoutPlanId);

        return GetAllWorkoutPlanResult.builder()
                .withWorkoutPlanList(workoutPlanList)
                .build();
    }
}
