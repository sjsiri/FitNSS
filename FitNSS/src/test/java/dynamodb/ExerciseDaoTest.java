package dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dynamodb.models.Exercise;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class ExerciseDaoTest {
    @Mock
    private DynamoDBMapper dynamoDBMapper;

    private ExerciseDao exerciseDao;

    @BeforeEach
    public void setUp() {
        openMocks(this);
        exerciseDao = new ExerciseDao(dynamoDBMapper);
    }

    @Test
    public void getExerciseLoadExercise() {
        // Given
        String exerciseId = "exerciseId";
        when(dynamoDBMapper.load(Exercise.class, exerciseId)).thenReturn(new Exercise());

        // WHEN
        Exercise exercise = exerciseDao.getExercise(exerciseId);

        // THEN
        assertNotNull(exercise);
        verify(dynamoDBMapper).load(Exercise.class, exerciseId);
    }

    @Test
    public void saveExerciseCallsMapperExercise() {
        // GIVEN
        Exercise exercise = new Exercise();

        // WHEN
       exerciseDao.saveExercise(exercise);

       // THEN
        verify(dynamoDBMapper).save(exercise);
    }
}
