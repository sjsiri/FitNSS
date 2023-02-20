package activity;

import activity.requests.CreateExerciseRequest;
import activity.results.CreateExerciseResult;
import dynamodb.ExerciseDao;
import dynamodb.models.Exercise;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.FitNSSserviceUtils;

import javax.inject.Inject;

public class CreateExerciseActivity {
    private final Logger log;

    private final ExerciseDao exerciseDao;

    /**
     * Instantiates a new CreateExerciseActivity object.
     *
     * @param exerciseDao ExerciseDao to access the exercise table.
     */
    @Inject
    public CreateExerciseActivity(ExerciseDao exerciseDao) {
        this.exerciseDao = exerciseDao;
        log = LogManager.getLogger();
    }

    /**
     * This method handles the incoming request by creating a exercise in the database.
     * <p>
     * It then returns the exercise.
     * <p>
     * @param request request object containing the exercise's information
     * @return CreateExerciseResult result object containing the API defined {@link Exercise}
     */
    public CreateExerciseResult handleRequest(CreateExerciseRequest request) {
        log.info("Received Create Exercise Request {}", request);

        Exercise exercise = new Exercise();
        exercise.setExerciseId(FitNSSserviceUtils.generateExerciseId());
        exercise.setExerciseName(request.getExerciseName());
        exercise.setExerciseMovementGroup(request.getExerciseMovementGroup());
        exercise.setWorkingMuscle(request.getWorkingMuscle());
        exercise.setUserId(request.getUserId());

        exerciseDao.saveExercise(exercise);

        return CreateExerciseResult.builder()
                .withExercise(exercise)
                .build();
    }
}
