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

    private final MetricsPublisher metricsPublisher;

    @Inject
    public UpdateExerciseActivity(ExerciseDao exerciseDao, MetricsPublisher metricsPublisher) {
        this.exerciseDao = exerciseDao;
        this.metricsPublisher = metricsPublisher;
    }

    public UpdateExerciseResult handleRequest(final UpdateExerciseRequest updateExerciseRequest) {
        log.info("Received UpdateExerciseRequest {}", updateExerciseRequest);

        if (updateExerciseRequest.getExerciseId() == null || exerciseDao.getExercise(updateExerciseRequest.getExerciseId()) == null) {
            throw new ExerciseNotFoundException();
        }

        Exercise exercise = exerciseDao.getExercise(updateExerciseRequest.getExerciseId());

        exerciseDao.saveExercise(exercise);
        ExerciseModel exerciseModel = new ExerciseModel(exercise);
        return UpdateExerciseResult.builder().withExerciseModel(exerciseModel).build();
    }
}
