package activity;

import activity.requests.UpdateExerciseRequest;
import activity.results.UpdateExerciseResult;
import dynamodb.ExerciseDao;
import dynamodb.models.Exercise;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class UpdateExerciseActivityTest {
    @Mock
    private ExerciseDao exerciseDao;

    private UpdateExerciseActivity updateExerciseActivity;

    @BeforeEach
    public void setUp() {
        openMocks(this);
        updateExerciseActivity = new UpdateExerciseActivity(exerciseDao);
    }

    @Test
    public void handleRequest_goodRequestUpdatesName() {
        // GIVEN
        String id = "id";
        String expectedUserId = "userID";
        String expectedName = "new name";
        String expectedMuscle = "Chest";
        String expectedMovement = "Push";

        UpdateExerciseRequest request = UpdateExerciseRequest.builder()
                .withExerciseId(id)
                .withExerciseName(expectedName)
                .withWorkingMuscle(expectedMuscle)
                .withExerciseMovementGroup(expectedMovement)
                .withUserId(expectedUserId)
                .build();

        Exercise startingExercise = new Exercise();
        startingExercise.setExerciseName("old name");
        startingExercise.setExerciseMovementGroup(expectedMovement);
        startingExercise.setWorkingMuscle(expectedMuscle);
        startingExercise.setUserId(expectedUserId);

        when(exerciseDao.getExercise(id)).thenReturn(startingExercise);

        // WHEN
        UpdateExerciseResult result = updateExerciseActivity.handleRequest(request);

        // THEN
        assertEquals(expectedName, result.getExercise().getExerciseName());
        assertEquals(expectedUserId, result.getExercise().getUserId());
    }
}
