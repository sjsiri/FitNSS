package activity;

import activity.requests.GetAllExercisesRequest;
import activity.results.GetAllExercisesResult;
import dynamodb.ExerciseDao;
import dynamodb.models.Exercise;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.List;

public class GetAllExercisesByMuscleActivity {

    private final ExerciseDao exerciseDao;

    private final Logger log = LogManager.getLogger();

    @Inject
    public GetAllExercisesByMuscleActivity(ExerciseDao exerciseDao) {
        this.exerciseDao = exerciseDao;
    }

    public GetAllExercisesResult handleRequest(final GetAllExercisesRequest getAllExercisesRequest) {
        log.info("Received GetAllExerciseRequestByMuscle {}", getAllExercisesRequest);
        String requestedMuscleGroup = getAllExercisesRequest.getExerciseMuscle();
        List<Exercise> exerciseList = exerciseDao.getAllExercisesByMuscle(requestedMuscleGroup);

        return GetAllExercisesResult.builder()
                .withExerciseList(exerciseList)
                .build();
    }

}
