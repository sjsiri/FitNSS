package dynamodb.models;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class WorkoutPlan {

    private String workoutPlanId;
    private String workoutDayName;
    private Set<String> exercisesAdded;
    private Set<Integer> numberOfSets;
    private Set<String> numberOfReps;
    private Set<String> numberOfWeights;
    private Boolean isCompleted;
    private String notesBox;

    public String getWorkoutPlanId() {
        return workoutPlanId;
    }

    public void setWorkoutPlanId(String workoutPlanId) {
        this.workoutPlanId = workoutPlanId;
    }

    public String getWorkoutDayName() {
        return workoutDayName;
    }

    public void setWorkoutDayName(String workoutDayName) {
        this.workoutDayName = workoutDayName;
    }

    public Set<String> getExercisesAdded() {
        return exercisesAdded;
    }

    public void setExercisesAdded(Set<String> exercisesAdded) {
        this.exercisesAdded = exercisesAdded;
    }

    public Set<Integer> getNumberOfSets() {
        return numberOfSets;
    }

    public void setNumberOfSets(Set<Integer> numberOfSets) {
        this.numberOfSets = numberOfSets;
    }

    public Set<String> getNumberOfReps() {
        return numberOfReps;
    }

    public void setNumberOfReps(Set<String> numberOfReps) {
        this.numberOfReps = numberOfReps;
    }

    public Set<String> getNumberOfWeights() {
        return numberOfWeights;
    }

    public void setNumberOfWeights(Set<String> numberOfWeights) {
        this.numberOfWeights = numberOfWeights;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

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
