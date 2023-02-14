package dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dynamodb.models.WorkoutPlan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class WorkoutPlanDaoTest {
    @Mock
    private DynamoDBMapper dynamoDBMapper;

    private WorkoutPlanDao workoutPlanDao;

    @BeforeEach
    public void setUp() {
        openMocks(this);
        workoutPlanDao = new WorkoutPlanDao(dynamoDBMapper);
    }

    @Test
    public void getWorkoutPlanLoadWorkoutPlan() {
        // GIVEN
        String workoutPlanId = "workoutId";
        when(dynamoDBMapper.load(WorkoutPlan.class, workoutPlanId)).thenReturn(new WorkoutPlan());

        // WHEN
        WorkoutPlan workoutPlan = workoutPlanDao.getWorkoutPlan(workoutPlanId);

        // THEN
        assertNotNull(workoutPlan);
    }

    @Test
    public void saveWorkoutPlanCallsMapperWorkout() {
        // GIVEN
        WorkoutPlan workoutPlan = new WorkoutPlan();

        // WHEN
        workoutPlanDao.saveWorkoutPlan(workoutPlan);

        // THEN
        verify(dynamoDBMapper).save(workoutPlan);
    }
}
