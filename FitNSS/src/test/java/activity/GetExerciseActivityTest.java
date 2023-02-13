package activity;

import dynamodb.ExerciseDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

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
    public void handleRequest_savedExerciseFound_returnsExerciseResult() {
        // GIVEN
        String expectedId = "1234";
        String expectedName = "Bench Press";

    }
}
