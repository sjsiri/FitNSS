package activity;

import activity.requests.UpdateExerciseRequest;
import activity.results.UpdateExerciseResult;
import dynamodb.ExerciseDao;
import dynamodb.models.Exercise;
import exceptions.ExerciseNotFoundException;
import metrics.MetricsPublisher;
import models.ExerciseModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class UpdateExerciseActivity {

    private final Logger log = LogManager.getLogger();

    private final ExerciseDao exerciseDao;

    /**
     * Instantiates a new UpdateExerciseActivity object.
     *
     * @param exerciseDao  ExerciseDao to access the exercise table.
     */
    @Inject
    public UpdateExerciseActivity(ExerciseDao exerciseDao) {
        this.exerciseDao = exerciseDao;
    }

    /**
     * This method handles the incoming request by retrieving the exercise, updating it,
     * and persisting the exercise.
     * <p>
     * It then returns the updated exercise.
     *
     * @param updateExerciseRequest request object containing the exerciseId, exerciseName, exerciseMovementGroup, workingMuscle.
     * @return updateExerciseResult result object containing the API defined {@link Exercise}
     */
    public UpdateExerciseResult handleRequest(final UpdateExerciseRequest updateExerciseRequest) {
        log.info("Received UpdateExerciseRequest {}", updateExerciseRequest);

        if (updateExerciseRequest.getExerciseId() == null || exerciseDao.getExercise(updateExerciseRequest.getExerciseId()) == null) {
            throw new ExerciseNotFoundException();
        }

        Exercise exercise = exerciseDao.getExercise(updateExerciseRequest.getExerciseId());

        if (!exercise.getUserId().equals(updateExerciseRequest.getUserId())) {
            throw new SecurityException("You must be the owner of the exercise to update it.");
        }

        if (updateExerciseRequest.getExerciseName() != null) {
            exercise.setExerciseName(updateExerciseRequest.getExerciseName());
        }

        if (updateExerciseRequest.getWorkingMuscle() != null) {
            exercise.setWorkingMuscle(updateExerciseRequest.getWorkingMuscle());
        }

        if (updateExerciseRequest.getExerciseMovementGroup() != null) {
            exercise.setExerciseMovementGroup(updateExerciseRequest.getExerciseMovementGroup());
        }
        

        exerciseDao.saveExercise(exercise);
        ExerciseModel exerciseModel = new ExerciseModel(exercise);
        return UpdateExerciseResult.builder().withExerciseModel(exerciseModel).build();
    }
}
