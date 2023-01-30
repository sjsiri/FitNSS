package activity;

import activity.requests.DeleteExerciseRequest;
import activity.results.DeleteExerciseResult;
import dynamodb.ExerciseDao;
import dynamodb.models.Exercise;
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

        String requestedExerciseId = deleteExerciseRequest.getExerciseId();
        Exercise exercise = exerciseDao.getExercise(requestedExerciseId);

        exerciseDao.deleteExercise(exercise);
        return DeleteExerciseResult.builder()
                .withExercise(exercise)
                .build();
    }
}
