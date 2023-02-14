package activity;

import activity.requests.GetAllWorkoutPlanRequest;
import activity.results.GetAllWorkoutPlanResult;
import dynamodb.WorkoutPlanDao;
import dynamodb.models.Exercise;
import dynamodb.models.WorkoutPlan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.List;

public class GetAllWorkoutPlanActivity {
    private final Logger log = LogManager.getLogger();

    private final WorkoutPlanDao workoutPlanDao;
    /**
     * Instantiates a new GetAllWorkoutPlanActivity object.
     *
     * @param workoutPlanDao WorkoutPlanDao to access the WorkoutPlan table.
     */
    @Inject
    public GetAllWorkoutPlanActivity(WorkoutPlanDao workoutPlanDao) {
        this.workoutPlanDao = workoutPlanDao;
    }

    /**
     * This method handles the incoming request by retrieving the workout plan from the database.
     * <p>
     * It then returns the GetAllWorkoutPlanResult.
     * <p>
     *
     * @param getAllWorkoutPlanRequest request object containing the workoutplan ID
     * @return getAllExercise result object containing the API defined {@link Exercise}
     */
    public GetAllWorkoutPlanResult handleRequest(final GetAllWorkoutPlanRequest getAllWorkoutPlanRequest) {
        log.info("Received getAllWorkoutRequest {}", getAllWorkoutPlanRequest);
        String requestedWorkoutPlanId = getAllWorkoutPlanRequest.getWorkoutPlanId();
        List<WorkoutPlan> workoutPlanList = workoutPlanDao.getAllWorkoutPlans(requestedWorkoutPlanId);

        return GetAllWorkoutPlanResult.builder()
                .withWorkoutPlanList(workoutPlanList)
                .build();
    }
}
