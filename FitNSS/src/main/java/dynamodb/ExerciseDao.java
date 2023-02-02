package dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import dynamodb.models.Exercise;
import exceptions.ExerciseNotFoundException;
import org.checkerframework.checker.units.qual.A;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExerciseDao {

    private final DynamoDBMapper dynamoDBMapper;
    private static final int PAGE_SIZE = 10;

    /**
     * Instantiates a ExerciseDao object*
     * @param dynamoDBMapper the {@link DynamoDBMapper} used to interact with the exercise table
     */
    @Inject
    public ExerciseDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;

    }

    /**
     * Returns the {@link Exercise} corresponding to the specified id.*
     * @param exerciseId the Exercise ID
     * @return the stored Exercise, or null if none was found.
     */
    public Exercise getExercise(String exerciseId) {
        Exercise exercise = dynamoDBMapper.load(Exercise.class, exerciseId);
        if (exercise == null) {
            throw new ExerciseNotFoundException(String.format("Could not find Exercise with the ID '%s ", exerciseId));
        }
        return exercise;
    }

    /**
     * Returns the {@link Exercise} *
     * @param exerciseStartKey the exerciseID
     * @return the stored Exercises.
     */
    public List<Exercise> getAllExercises(String exerciseStartKey) {
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        return dynamoDBMapper.scan(Exercise.class, scanExpression);
    }

    public List<Exercise> getAllExercisesByMovementGroupWithLimit(String exerciseStartKey, Boolean forward, String exerciseMovementGroup) {
        Map<String, AttributeValue> startKeyMap = new HashMap<>();
        Map<String, AttributeValue> valueMap = new HashMap<>();

        DynamoDBQueryExpression<Exercise> queryExpression = new DynamoDBQueryExpression<Exercise>()
                .withScanIndexForward(forward)
                .withLimit(PAGE_SIZE)
                .withExclusiveStartKey(startKeyMap)
                .withConsistentRead(false);

        if (exerciseMovementGroup != null) {
            startKeyMap.put("exerciseMovementGroup", new AttributeValue().withS(exerciseMovementGroup));
            valueMap.put(":exerciseMovementGroup", new AttributeValue().withS(exerciseMovementGroup));
        } else {
            DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
            return dynamoDBMapper.scan(Exercise.class, scanExpression);
        }
        startKeyMap.put("exerciseName", new AttributeValue().withS(exerciseStartKey));

        return dynamoDBMapper.queryPage(Exercise.class, queryExpression).getResults();
    }

    /**
     * Saves (creates or updates) the given Exercise*
     * @param exercise the exercise to save
     */
    public void saveExercise(Exercise exercise) {
        this.dynamoDBMapper.save(exercise);
    }

    public void deleteExercise(Exercise exercise) {
        exercise.setExerciseId(exercise.getExerciseId());
        this.dynamoDBMapper.delete(exercise);
    }
}
