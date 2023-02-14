package activity;

import activity.requests.GetExerciseRequest;
import activity.results.GetExerciseResult;
import dynamodb.ExerciseDao;
import dynamodb.models.Exercise;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class GetExerciseActivity {

    private final Logger log = LogManager.getLogger();
    private final ExerciseDao exerciseDao;

    /**
     * Instantiates a new GetExerciseActivity object.
     *
     * @param exerciseDao ExerciseDao to access the exercise table.
     */
    @Inject
    public GetExerciseActivity(ExerciseDao exerciseDao) {
        this.exerciseDao = exerciseDao;
    }

    /**
     * This method handles the incoming request by retrieving the exercise from the database.
     * <p>
     * It then returns the exercise.
     * <p>
     *
     * @param getExerciseRequest request object containing the exercise ID
     * @return getExerciseResult result object containing the API defined {@link Exercise}
     */
    public GetExerciseResult handleRequest(final GetExerciseRequest getExerciseRequest) {
        log.info("Received GetExerciseRequest {}", getExerciseRequest);
        String requestedExerciseId = getExerciseRequest.getExerciseId();
        Exercise exercise = exerciseDao.getExercise(requestedExerciseId);

        return GetExerciseResult.builder()
                .withExercise(exercise)
                .build();
    }

}
