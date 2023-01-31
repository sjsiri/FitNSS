package activity;

import activity.requests.DeleteExerciseRequest;
import activity.results.DeleteExerciseResult;
import dynamodb.ExerciseDao;
import dynamodb.models.Exercise;
import exceptions.ExerciseNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class DeleteExerciseActivity {

    private final Logger log = LogManager.getLogger();

    private final ExerciseDao exerciseDao;

    @Inject
    public DeleteExerciseActivity(ExerciseDao exerciseDao) {
        this.exerciseDao = exerciseDao;
    }

    public DeleteExerciseResult handleRequest(final DeleteExerciseRequest deleteExerciseRequest) {
        log.info("Received DeleteExerciseRequest {}", deleteExerciseRequest);

        if (deleteExerciseRequest.getExerciseId() == null && !deleteExerciseRequest.getPathExerciseId().equals(deleteExerciseRequest.getExerciseId())) {
            throw new ExerciseNotFoundException();
        }

        deleteExerciseRequest.setExerciseId(deleteExerciseRequest.getPathExerciseId());

        if (exerciseDao.getExercise(deleteExerciseRequest.getExerciseId()) == null ) {
            throw new ExerciseNotFoundException();
        }

        Exercise exercise = exerciseDao.getExercise(deleteExerciseRequest.getPathExerciseId());

        exerciseDao.deleteExercise(exercise);

        return DeleteExerciseResult.builder()
                .withExercise(exercise)
                .build();
    }
}
