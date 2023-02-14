package activity;

import activity.requests.GetAllExercisesRequest;
import activity.results.GetAllExercisesResult;
import dynamodb.ExerciseDao;
import dynamodb.models.Exercise;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.List;

public class GetAllExercisesActivity {
    private final Logger log = LogManager.getLogger();

    private final ExerciseDao exerciseDao;

    /**
     * Instantiates a new GetAllExercisesActivity object.
     *
     * @param exerciseDao ExerciseDao to access the Exercise table.
     */
    @Inject
    public GetAllExercisesActivity(ExerciseDao exerciseDao) {
        this.exerciseDao = exerciseDao;
    }

    /**
     * This method handles the incoming request by retrieving the exercises from the database.
     * <p>
     * It then returns the GetAllExerciseResult.
     * <p>
     *
     * @param getAllExercisesRequest request object containing the exercise ID
     * @return getAllExercise result object containing the API defined {@link Exercise}
     */
    public GetAllExercisesResult handleRequest(final GetAllExercisesRequest getAllExercisesRequest) {
        log.info("Received getAllExercisesRequest {}", getAllExercisesRequest);
        String requestedId = getAllExercisesRequest.getExerciseId();
        List<Exercise> exerciseList = exerciseDao.getAllExercises(requestedId);

        return GetAllExercisesResult.builder()
                .withExerciseList(exerciseList)
                .build();
    }
}
