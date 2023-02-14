package activity;

import activity.UpdateWorkoutPlanActivity;
import activity.requests.UpdateWorkoutPlanRequest;
import activity.results.UpdateWorkoutPlanResult;
import dynamodb.WorkoutPlanDao;
import dynamodb.models.WorkoutPlan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class UpdateWorkoutPlanActivityTest {

    @Mock
    private WorkoutPlanDao workoutPlanDao;

    private UpdateWorkoutPlanActivity updateWorkoutPlanActivity;

    @BeforeEach
    public void setUp() {
        openMocks(this);
        updateWorkoutPlanActivity = new UpdateWorkoutPlanActivity(workoutPlanDao);
    }

    @Test
    public void handleRequest_goodRequest_updatesWorkoutDayName() {
        // GIVEN
        String workoutplanId = "1";
        String expecteduserId = "user1";
        String expectedWorkoutDayName = "Big Back";

        UpdateWorkoutPlanRequest request = UpdateWorkoutPlanRequest.builder()
                .withWorkoutPlanId(workoutplanId)
                .withUserId(expecteduserId)
                .withWorkoutDayName(expectedWorkoutDayName).build();

        WorkoutPlan workoutPlan = new WorkoutPlan();
        workoutPlan.setUserId(expecteduserId);
        workoutPlan.setWorkoutDayName("Big Chest");

        when(workoutPlanDao.getWorkoutPlan(workoutplanId)).thenReturn(workoutPlan);

        // WHEN
        UpdateWorkoutPlanResult result = updateWorkoutPlanActivity.handleRequest(request);

        // THEN
        assertEquals(expectedWorkoutDayName, result.getWorkoutPlanModel().getWorkoutDayName());
        assertEquals(expecteduserId, result.getWorkoutPlanModel().getUserId());
    }
}
