package activity;

import activity.requests.GetExerciseRequest;
import activity.results.GetExerciseResult;
import dynamodb.ExerciseDao;
import dynamodb.models.Exercise;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class GetExerciseActivityTest {

    @Mock
    private ExerciseDao exerciseDao;

    private GetExerciseActivity getExerciseActivity;

    @BeforeEach
    public void setUp() {
        openMocks(this);
        getExerciseActivity = new GetExerciseActivity(exerciseDao);
    }

    @Test
    public void handleRequest_savedExerciseFound_returnsExerciseModelInResult() {
        // GIVEN
        String expectedId = "123";
        String expectedName = "Squats";
        String expectedMuscle = "Quadriceps";
        String expectedMovement = "Lower";

        Exercise exercise = new Exercise();
        exercise.setExerciseId(expectedId);
        exercise.setExerciseName(expectedName);
        exercise.setWorkingMuscle(expectedMuscle);
        exercise.setExerciseMovementGroup(expectedMovement);

        when(exerciseDao.getExercise(expectedId)).thenReturn(exercise);

        GetExerciseRequest request = GetExerciseRequest.builder().withExerciseId(expectedId).build();

        // WHEN
        GetExerciseResult result = getExerciseActivity.handleRequest(request);

        // THEN
        assertEquals(expectedId, result.getExercise().getExerciseId());
        assertEquals(expectedName, result.getExercise().getExerciseName());
        assertEquals(expectedMovement, result.getExercise().getExerciseMovementGroup());
        assertEquals(expectedMuscle, result.getExercise().getWorkingMuscle());
    }
}
