package activity;

import activity.requests.CreateWorkoutPlanRequest;
import activity.results.CreateWorkoutPlanResult;
import dynamodb.WorkoutPlanDao;
import dynamodb.models.WorkoutPlan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

public class CreateWorkoutPlanActivityTest {

    @Mock
    private WorkoutPlanDao workoutPlanDao;

    private CreateWorkoutPlanActivity createWorkoutPlanActivity;

    @BeforeEach
    void setUp(){
        openMocks(this);
        createWorkoutPlanActivity = new CreateWorkoutPlanActivity(workoutPlanDao);
    }

    @Test
    public void handleRequest_createsAndSavesWorkoutPlan() {
        // GIVEN
        String expectedName = "expectedName";
        List<String> exercises = new ArrayList<>();
        exercises.add("Bench");
        exercises.add("Squat");
        exercises.add("Deadlift");
        List<Integer> sets = new ArrayList<>();
        sets.add(3);
        sets.add(3);
        sets.add(3);
        List<String> reps = new ArrayList<>();
        reps.add("5");
        reps.add("AMRAP");
        reps.add("3 pauses");
        List<String> weights = new ArrayList<>();
        weights.add("135");
        weights.add("225");
        weights.add("Red resistance band");
        String expectedNotes = "notes for test";
        String expectedUserId = "expectedUser";

        CreateWorkoutPlanRequest request = CreateWorkoutPlanRequest.builder()
                .withWorkoutDayName(expectedName)
                .withExercisesAdded(exercises)
                .withNumberOfSets(sets)
                .withNumberOfReps(reps)
                .withNumberOfWeights(weights)
                .withNotesBox(expectedNotes)
                .withUserId(expectedUserId)
                .build();

        // WHEN
        CreateWorkoutPlanResult result = createWorkoutPlanActivity.handleRequest(request);

        // THEN
        verify(workoutPlanDao).saveWorkoutPlan(any(WorkoutPlan.class));

        assertNotNull(result.getWorkoutPlan().getWorkoutPlanId());
        assertEquals(expectedName, result.getWorkoutPlan().getWorkoutDayName());
        assertEquals(exercises, result.getWorkoutPlan().getExercisesAdded());
        assertEquals(sets, result.getWorkoutPlan().getNumberOfSets());
        assertEquals(reps, result.getWorkoutPlan().getNumberOfReps());
        assertEquals(weights, result.getWorkoutPlan().getNumberOfWeights());
        assertEquals(expectedNotes, result.getWorkoutPlan().getNotesBox());
    }
}
