package activity;

import activity.requests.GetWorkoutPlanRequest;
import activity.results.GetWorkoutPlanResult;
import dynamodb.WorkoutPlanDao;
import dynamodb.models.WorkoutPlan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class GetWorkoutPlanActivityTest {

    @Mock
    private WorkoutPlanDao workoutPlanDao;

    private GetWorkoutPlanActivity getWorkoutPlanActivity;

    @BeforeEach
    public void setUp() {
        openMocks(this);
        getWorkoutPlanActivity = new GetWorkoutPlanActivity(workoutPlanDao);
    }

    @Test
    public void handleRequest_savedWorkoutFound_returnWorkoutPLanInResult() {
        // GIVEN
        String expectedId = "id";
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

        WorkoutPlan workoutPlan = new WorkoutPlan();
        workoutPlan.setWorkoutPlanId(expectedId);
        workoutPlan.setWorkoutDayName(expectedName);
        workoutPlan.setExercisesAdded(exercises);
        workoutPlan.setNumberOfSets(sets);
        workoutPlan.setNumberOfReps(reps);
        workoutPlan.setNumberOfWeights(weights);
        workoutPlan.setNotesBox(expectedNotes);
        workoutPlan.setUserId(expectedUserId);

        when(workoutPlanDao.getWorkoutPlan(expectedId)).thenReturn(workoutPlan);

        GetWorkoutPlanRequest request = GetWorkoutPlanRequest.builder()
                .withWorkoutPlanId(expectedId)
                .build();

        // WHEN
        GetWorkoutPlanResult result = getWorkoutPlanActivity.handleRequest(request);

        // THEN
        assertEquals(expectedId, result.getWorkoutPlan().getWorkoutPlanId());
        assertEquals(expectedName, result.getWorkoutPlan().getWorkoutDayName());
        assertEquals(exercises, result.getWorkoutPlan().getExercisesAdded());
        assertEquals(sets, result.getWorkoutPlan().getNumberOfSets());
        assertEquals(reps, result.getWorkoutPlan().getNumberOfReps());
        assertEquals(weights, result.getWorkoutPlan().getNumberOfWeights());
        assertEquals(expectedNotes, result.getWorkoutPlan().getNotesBox());
    }
}
