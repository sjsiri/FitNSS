package dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class WorkoutPlan {

    private String workoutPlanId;
    private String workoutDayName;
    private List<String> exercisesAdded;
    private List<Integer> numberOfSets;
    private List<String> numberOfReps;
    private List<String> numberOfWeights;
    private Boolean isCompleted;
    private String notesBox;

    @DynamoDBHashKey(attributeName = "workoutPlanId")
    public String getWorkoutPlanId() {
        return workoutPlanId;
    }

    public void setWorkoutPlanId(String workoutPlanId) {
        this.workoutPlanId = workoutPlanId;
    }

    @DynamoDBAttribute(attributeName = "workoutDayName")
    public String getWorkoutDayName() {
        return workoutDayName;
    }

    public void setWorkoutDayName(String workoutDayName) {
        this.workoutDayName = workoutDayName;
    }

    @DynamoDBAttribute(attributeName = "exercisesAdded")
    public List<String> getExercisesAdded() {
        return exercisesAdded;
    }

    public void setExercisesAdded(List<String> exercisesAdded) {
        this.exercisesAdded = exercisesAdded;
    }

   @DynamoDBAttribute(attributeName = "numberOfSets")
    public List<Integer> getNumberOfSets() {
        return numberOfSets;
    }

    public void setNumberOfSets(List<Integer> numberOfSets) {
        this.numberOfSets = numberOfSets;
    }

    @DynamoDBAttribute(attributeName = "numberOfReps")
    public List<String> getNumberOfReps() {
        return numberOfReps;
    }

    public void setNumberOfReps(List<String> numberOfReps) {
        this.numberOfReps = numberOfReps;
    }

    @DynamoDBAttribute(attributeName = "numberOfWeights")
    public List<String> getNumberOfWeights() {
        return numberOfWeights;
    }

    public void setNumberOfWeights(List<String> numberOfWeights) {
        this.numberOfWeights = numberOfWeights;
    }

    @DynamoDBAttribute(attributeName = "isCompleted")
    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    @DynamoDBAttribute(attributeName = "notesBox")
    public String getNotesBox() {
        return notesBox;
    }

    public void setNotesBox(String notesBox) {
        this.notesBox = notesBox;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkoutPlan)) return false;
        WorkoutPlan that = (WorkoutPlan) o;
        return Objects.equals(workoutPlanId, that.workoutPlanId) &&
                Objects.equals(workoutDayName, that.workoutDayName) &&
                Objects.equals(exercisesAdded, that.exercisesAdded) &&
                Objects.equals(numberOfSets, that.numberOfSets) &&
                Objects.equals(numberOfReps, that.numberOfReps) &&
                Objects.equals(numberOfWeights, that.numberOfWeights) &&
                Objects.equals(isCompleted, that.isCompleted) &&
                Objects.equals(notesBox, that.notesBox);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workoutPlanId, workoutDayName, exercisesAdded, numberOfSets, numberOfReps, numberOfWeights, isCompleted, notesBox);
    }

    @Override
    public String toString() {
        return "WorkoutPlan{" +
                "workoutPlanId='" + workoutPlanId + '\'' +
                ", workoutDayName='" + workoutDayName + '\'' +
                ", exercisesAdded=" + exercisesAdded +
                ", numberOfSets=" + numberOfSets +
                ", numberOfReps=" + numberOfReps +
                ", numberOfWeights=" + numberOfWeights +
                ", isCompleted=" + isCompleted +
                ", notesBox='" + notesBox + '\'' +
                '}';
    }
}
