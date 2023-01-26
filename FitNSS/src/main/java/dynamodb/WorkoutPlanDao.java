package dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import dynamodb.models.WorkoutPlan;

import javax.inject.Inject;
import java.util.List;

public class WorkoutPlanDao {

    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public WorkoutPlanDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public void saveWorkoutPlan(WorkoutPlan workoutPlan) {
        this.dynamoDBMapper.save(workoutPlan);
    }

    public WorkoutPlan getWorkoutPlan(String workoutPlanId) {
        return dynamoDBMapper.load(WorkoutPlan.class, workoutPlanId);
    }

    public List<WorkoutPlan> getAllWorkoutPlans(String workoutPlanKey) {
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        return dynamoDBMapper.scan(WorkoutPlan.class, scanExpression);
    }

    public void deleteWorkoutPlan(WorkoutPlan workoutPlanId) {
        workoutPlanId.setWorkoutPlanId(workoutPlanId.getWorkoutPlanId());
        dynamoDBMapper.delete(workoutPlanId);
    }
}
