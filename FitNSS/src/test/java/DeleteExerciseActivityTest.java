import activity.DeleteExerciseActivity;
import activity.requests.DeleteExerciseRequest;
import dynamodb.ExerciseDao;
import dynamodb.models.Exercise;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

public class DeleteExerciseActivityTest {
    @InjectMocks
    private DeleteExerciseActivity activity;

    @Mock
    private ExerciseDao exerciseDao;

    @BeforeEach
    public void setup() {
        openMocks(this);
    }

    @Test
    void handleRequest_attemptsToDeleteMember() {
        // GIVEN
        Exercise exercise = new Exercise();
        String exerciseId = "1234";
        exercise.setExerciseId(exerciseId);



        // WHEN
       exerciseDao.deleteExercise(exercise);

        // THEN
        verify(exerciseDao).deleteExercise(exercise);
    }
}
