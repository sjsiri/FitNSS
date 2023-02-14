package activity;

import activity.requests.CreateExerciseRequest;
import activity.results.CreateExerciseResult;
import dynamodb.ExerciseDao;
import dynamodb.models.Exercise;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

public class CreateExerciseActivityTest {

    @Mock
    private ExerciseDao exerciseDao;

    private CreateExerciseActivity createExerciseActivity;

    @BeforeEach
    void setUp() {
        openMocks(this);
        createExerciseActivity = new CreateExerciseActivity(exerciseDao);
    }

    @Test
    public void handleRequest_createsAndSavesExercise() {
        // GIVEN
        String expectedName = "expectedName";
        String expectedMuscle = "Hamstrings";
        String expectedMovement = "Lower";

        CreateExerciseRequest request = CreateExerciseRequest.builder()
                .withExerciseName(expectedName)
                .withWorkingMuscle(expectedMuscle)
                .withExerciseMovementGroup(expectedMovement)
                .build();

        // WHEN
        CreateExerciseResult result = createExerciseActivity.handleRequest(request);

        // THEN
        verify(exerciseDao).saveExercise(any(Exercise.class));

        assertNotNull(result.getExercise().getExerciseId());
        assertEquals(expectedName, result.getExercise().getExerciseName());
        assertEquals(expectedMovement, result.getExercise().getExerciseMovementGroup());
        assertEquals(expectedMuscle, result.getExercise().getWorkingMuscle());
    }
}
