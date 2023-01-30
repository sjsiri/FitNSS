package activity;

import activity.requests.CreateExerciseRequest;
import dynamodb.ExerciseDao;
import dynamodb.models.Exercise;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.FitNSSserviceUtils;

import javax.inject.Inject;

public class CreateExerciseActivity {
    private final Logger log;

    private final ExerciseDao exerciseDao;

    @Inject
    public CreateExerciseActivity(ExerciseDao exerciseDao) {
        this.exerciseDao = exerciseDao;
        log = LogManager.getLogger();
    }

    public src.main.java.activity.results.CreateExerciseResult handleRequest(CreateExerciseRequest request) {
        log.info("Received Create Exercise Request {}", request);

        Exercise exercise = new Exercise();
        exercise.setExerciseId(FitNSSserviceUtils.generateExerciseId());
        exercise.setExerciseName(request.getExerciseName());
        exercise.setExerciseMovementGroup(request.getExerciseMovementGroup());
        exercise.setWorkingMuscle(request.getWorkingMuscle());

        exerciseDao.saveExercise(exercise);

        return src.main.java.activity.results.CreateExerciseResult.builder()
                .withExercise(exercise)
                .build();
    }
}
