package activity;

import activity.requests.GetWorkoutPlanRequest;
import activity.results.GetWorkoutPlanResult;
import dynamodb.WorkoutPlanDao;
import dynamodb.models.Exercise;
import dynamodb.models.WorkoutPlan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class GetWorkoutPlanActivity {

    private final Logger log = LogManager.getLogger();

    private final WorkoutPlanDao workoutPlanDao;

    @Inject
    public GetWorkoutPlanActivity(WorkoutPlanDao workoutPlanDao) {
        this.workoutPlanDao = workoutPlanDao;
    }

    /**
     * This method handles the incoming request by retrieving the workout plan from the database.
     * <p>
     * It then returns the workout plan.
     * <p>
     *
     * @param getWorkoutPlanRequest request object containing the exercise ID
     * @return getWorkoutPlanResult result object containing the API defined {@link WorkoutPlan}
     */
    public GetWorkoutPlanResult handleRequest(final GetWorkoutPlanRequest getWorkoutPlanRequest) {
        log.info("Received GetWorkoutPlanRequest {}", getWorkoutPlanRequest);
        String requestedWorkoutPlanId = getWorkoutPlanRequest.getWorkoutPlanId();
        WorkoutPlan workoutPlan = workoutPlanDao.getWorkoutPlan(requestedWorkoutPlanId);

        return GetWorkoutPlanResult.builder()
                .withWorkoutPlan(workoutPlan)
                .build();
    }
}
