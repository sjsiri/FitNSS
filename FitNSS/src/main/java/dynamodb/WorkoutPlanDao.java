package dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import dynamodb.models.WorkoutPlan;
import exceptions.WorkoutPlanNotFoundException;

import javax.inject.Inject;
import java.util.List;

public class WorkoutPlanDao {

    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public WorkoutPlanDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }
    public WorkoutPlan getWorkoutPlan(String workoutPlanId) {
        WorkoutPlan workoutPlan = dynamoDBMapper.load(WorkoutPlan.class, workoutPlanId);
        if (workoutPlan == null) {
            throw new WorkoutPlanNotFoundException(String.format("Could not find WorkoutPlan with the ID '%s ", workoutPlanId));
        }
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

    public void saveWorkoutPlan(WorkoutPlan workoutPlan) {
        this.dynamoDBMapper.save(workoutPlan);
    }
}
