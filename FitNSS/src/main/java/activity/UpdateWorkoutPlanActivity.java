package activity;

import activity.requests.UpdateWorkoutPlanRequest;
import activity.results.UpdateWorkoutPlanResult;
import dynamodb.WorkoutPlanDao;
import dynamodb.models.Exercise;
import dynamodb.models.WorkoutPlan;
import exceptions.WorkoutPlanNotFoundException;
import models.WorkoutPlanModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class UpdateWorkoutPlanActivity {
    private final Logger log = LogManager.getLogger();
    private final WorkoutPlanDao workoutPlanDao;
    /**
     * Instantiates a new UpdateWorkoutPlanActivity object.
     *
     * @param workoutPlanDao  WorkoutPlanDao to access the workoutPlan table.
     */
    @Inject
    public UpdateWorkoutPlanActivity(WorkoutPlanDao workoutPlanDao) {
        this.workoutPlanDao = workoutPlanDao;
    }

    /**
     * This method handles the incoming request by retrieving the workout plan, updating it,
     * and persisting the workout plan.
     * <p>
     * It then returns the updated workout plan.
     *
     * @param updateWorkoutPlanRequest request object.
     * @return updateWorkoutPlanResult result object containing the API defined {@link WorkoutPlan}
     */
    public UpdateWorkoutPlanResult handleRequest(final UpdateWorkoutPlanRequest updateWorkoutPlanRequest) {
        log.info("Received UpdateWorkoutPlanRequest {}", updateWorkoutPlanRequest);

        if (updateWorkoutPlanRequest.getWorkoutPlanId() == null || workoutPlanDao.getWorkoutPlan(updateWorkoutPlanRequest.getWorkoutPlanId()) == null) {
            throw new WorkoutPlanNotFoundException();
        }

        WorkoutPlan workoutPlan = workoutPlanDao.getWorkoutPlan(updateWorkoutPlanRequest.getWorkoutPlanId());

        if (!workoutPlan.getUserId().equals(updateWorkoutPlanRequest.getUserId())) {
            throw new SecurityException("You must be the owner of the workout plan to update it.");
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
