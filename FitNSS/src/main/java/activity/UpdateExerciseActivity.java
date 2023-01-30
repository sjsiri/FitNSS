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

    @Inject
    public UpdateExerciseActivity(ExerciseDao exerciseDao) {
        this.exerciseDao = exerciseDao;
    }

    public UpdateExerciseResult handleRequest(final UpdateExerciseRequest updateExerciseRequest) {
        log.info("Received UpdateExerciseRequest {}", updateExerciseRequest);

        if (updateExerciseRequest.getExerciseId() != null && !updateExerciseRequest.getPathExerciseId().equals(updateExerciseRequest.getExerciseId())) {
            throw new ExerciseNotFoundException();
        }

        updateExerciseRequest.setExerciseId(updateExerciseRequest.getPathExerciseId());

        if (updateExerciseRequest.getExerciseId() == null || exerciseDao.getExercise(updateExerciseRequest.getExerciseId()) == null) {
            throw new ExerciseNotFoundException();
        }




        Exercise exercise = exerciseDao.getExercise(updateExerciseRequest.getPathExerciseId());

        if (updateExerciseRequest.getExerciseName() != null) {
            exercise.setExerciseName(updateExerciseRequest.getExerciseName());
        }

        if (updateExerciseRequest.getWorkingMuscle() != null) {
            exercise.setWorkingMuscle(updateExerciseRequest.getWorkingMuscle());
        }

        if (updateExerciseRequest.getExerciseMovementGroup() != null) {
            exercise.setWorkingMuscle(updateExerciseRequest.getWorkingMuscle());
        }
        

        exerciseDao.saveExercise(exercise);
        ExerciseModel exerciseModel = new ExerciseModel(exercise);
        return UpdateExerciseResult.builder().withExerciseModel(exerciseModel).build();
    }
}
