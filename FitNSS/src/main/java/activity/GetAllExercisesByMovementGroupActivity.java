package activity;

import activity.requests.GetAllExercisesRequest;
import activity.results.GetAllExercisesResult;
import dynamodb.ExerciseDao;
import dynamodb.models.Exercise;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.List;

public class GetAllExercisesByMovementGroupActivity {

    private final ExerciseDao exerciseDao;
    private final Logger log = LogManager.getLogger();

    @Inject
    public GetAllExercisesByMovementGroupActivity(ExerciseDao exerciseDao) {
        this.exerciseDao = exerciseDao;
    }

    public GetAllExercisesResult handleRequest(final GetAllExercisesRequest getAllExercisesRequest) {
        log.info("Received GetAllExerciseRequestByMovementGroup {}", getAllExercisesRequest);
        String requestedMovementGroup = getAllExercisesRequest.getExerciseMovementGroup();
        List<Exercise> exerciseList = exerciseDao.getAllExercisesByMovementGroup(requestedMovementGroup);

        return GetAllExercisesResult.builder()
                .withExerciseList(exerciseList)
                .build();
    }
}
