package dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import dynamodb.models.WorkoutPlan;
import exceptions.WorkoutPlanNotFoundException;

import javax.inject.Inject;
import java.util.List;

/**
 * Accesses data for a workout plan using {@link WorkoutPlan to represent the model in DynamoDB.
 */
public class WorkoutPlanDao {

    private final DynamoDBMapper dynamoDBMapper;

    /**
     * Instantiates a WorkoutPlanDao object.
     *
     * @param dynamoDBMapper the {@link DynamoDBMapper} used to interact with the WorkoutPlan table
     */
    @Inject
    public WorkoutPlanDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    /**
     * Returns the {@link WorkoutPlan} corresponding to the specified id.
     *
     * @param workoutPlanId the workout plan ID
     * @return the stored workout plans, or null if none was found.
     */
    public WorkoutPlan getWorkoutPlan(String workoutPlanId) {
        WorkoutPlan workoutPlan = dynamoDBMapper.load(WorkoutPlan.class, workoutPlanId);
        if (workoutPlan == null) {
            throw new WorkoutPlanNotFoundException(String.format("Could not find WorkoutPlan with the ID '%s ", workoutPlanId));
        }
        return dynamoDBMapper.load(WorkoutPlan.class, workoutPlanId);
    }

    /**
     * Returns the list of {@link WorkoutPlan} starting at the supplied ID.
     *
     * @param workoutPlanKey the workout plan ID
     * @return the stored workouts, or null if none was found.
     */
    public List<WorkoutPlan> getAllWorkoutPlans(String workoutPlanKey) {
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        return dynamoDBMapper.scan(WorkoutPlan.class, scanExpression);
    }

    /**
     * Deletes the workout.
     *
     * @param workoutPlanId The workout to delete
     */
    public void deleteWorkoutPlan(WorkoutPlan workoutPlanId) {
        workoutPlanId.setWorkoutPlanId(workoutPlanId.getWorkoutPlanId());
        dynamoDBMapper.delete(workoutPlanId);
    }

    /**
     * Saves (creates or updates) the given workout plan.
     * @param workoutPlan The workout plan to save
     */
    public void saveWorkoutPlan(WorkoutPlan workoutPlan) {
        this.dynamoDBMapper.save(workoutPlan);
    }
}
