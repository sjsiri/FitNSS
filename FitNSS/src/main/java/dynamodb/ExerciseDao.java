package dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import dynamodb.models.Exercise;
import exceptions.ExerciseNotFoundException;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExerciseDao {

    private final DynamoDBMapper dynamoDBMapper;

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

    public List<Exercise> getAllPushingMovementExercises(String exerciseStartKey) {
        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":exerciseMovementGroup", new AttributeValue().withS("Push"));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("exerciseMovementGroup = :exerciseMovementGroup")
                .withExpressionAttributeValues(valueMap);

        return dynamoDBMapper.scan(Exercise.class, scanExpression);
    }

    public List<Exercise> getAllPullingMovementExercises(String exerciseStartKey) {
        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":exerciseMovementGroup", new AttributeValue().withS("Pull"));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("exerciseMovementGroup = :exerciseMovementGroup")
                .withExpressionAttributeValues(valueMap);

        return dynamoDBMapper.scan(Exercise.class, scanExpression);
    }

    public List<Exercise> getAllLowerMovementExercises(String exerciseStartKey) {
        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":exerciseMovementGroup", new AttributeValue().withS("Lower"));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("exerciseMovementGroup = :exerciseMovementGroup")
                .withExpressionAttributeValues(valueMap);

        return dynamoDBMapper.scan(Exercise.class, scanExpression);
    }

    public List<Exercise> getAllChestMuscleExercises(String exerciseStartKey) {
        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":workingMuscle", new AttributeValue().withS("Chest"));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("workingMuscle = :workingMuscle")
                .withExpressionAttributeValues(valueMap);

        return dynamoDBMapper.scan(Exercise.class, scanExpression);
    }

    public List<Exercise> getAllBackMuscleExercises(String exerciseStartKey) {
        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":workingMuscle", new AttributeValue().withS("Back"));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("workingMuscle = :workingMuscle")
                .withExpressionAttributeValues(valueMap);

        return dynamoDBMapper.scan(Exercise.class, scanExpression);
    }

    public List<Exercise> getAllBicepMuscleExercises(String exerciseStartKey) {
        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":workingMuscle", new AttributeValue().withS("Biceps"));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("workingMuscle = :workingMuscle")
                .withExpressionAttributeValues(valueMap);

        return dynamoDBMapper.scan(Exercise.class, scanExpression);
    }

    public List<Exercise> getAllTricepsMuscleExercises(String exerciseStartKey) {
        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":workingMuscle", new AttributeValue().withS("Triceps"));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("workingMuscle = :workingMuscle")
                .withExpressionAttributeValues(valueMap);

        return dynamoDBMapper.scan(Exercise.class, scanExpression);
    }

    public List<Exercise> getAllShouldersMuscleExercises(String exerciseStartKey) {
        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":workingMuscle", new AttributeValue().withS("Shoulders"));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("workingMuscle = :workingMuscle")
                .withExpressionAttributeValues(valueMap);

        return dynamoDBMapper.scan(Exercise.class, scanExpression);
    }

    public List<Exercise> getAllHamstringsMuscleExercises(String exerciseStartKey) {
        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":workingMuscle", new AttributeValue().withS("Hamstring"));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("workingMuscle = :workingMuscle")
                .withExpressionAttributeValues(valueMap);

        return dynamoDBMapper.scan(Exercise.class, scanExpression);
    }

    public List<Exercise> getAllQuadMuscleExercises(String exerciseStartKey) {
        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":workingMuscle", new AttributeValue().withS("Quadriceps"));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("workingMuscle = :workingMuscle")
                .withExpressionAttributeValues(valueMap);

        return dynamoDBMapper.scan(Exercise.class, scanExpression);
    }

    public List<Exercise> getAllGlutesMuscleExercises(String exerciseStartKey) {
        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":workingMuscle", new AttributeValue().withS("Glutes"));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("workingMuscle = :workingMuscle")
                .withExpressionAttributeValues(valueMap);

        return dynamoDBMapper.scan(Exercise.class, scanExpression);
    }

    public List<Exercise> getAllCalvesMuscleExercises(String exerciseStartKey) {
        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":workingMuscle", new AttributeValue().withS("Calves"));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("workingMuscle = :workingMuscle")
                .withExpressionAttributeValues(valueMap);

        return dynamoDBMapper.scan(Exercise.class, scanExpression);
    }

    public List<Exercise> getAllAbsMuscleExercises(String exerciseStartKey) {
        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":workingMuscle", new AttributeValue().withS("Abdominal"));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("workingMuscle = :workingMuscle")
                .withExpressionAttributeValues(valueMap);

        return dynamoDBMapper.scan(Exercise.class, scanExpression);
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
