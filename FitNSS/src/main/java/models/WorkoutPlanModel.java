package models;

import dynamodb.models.WorkoutPlan;

import java.util.List;
import java.util.Objects;

public class WorkoutPlanModel {

    private String workoutPlanId;

    private String workoutDayName;

    private List<String> exercisesAdded;

    private List<Integer> numberOfSets;

    private List<String> numberOfReps;

    private List<String> numberOfWeights;

    private Boolean isCompleted;

    private String notesBox;

    public WorkoutPlanModel(WorkoutPlan workoutPlan) {
        this.workoutPlanId = workoutPlan.getWorkoutPlanId();
        this.workoutDayName = workoutPlan.getWorkoutDayName();
        this.exercisesAdded = workoutPlan.getExercisesAdded();
        this.numberOfSets = workoutPlan.getNumberOfSets();
        this.numberOfReps = workoutPlan.getNumberOfReps();
        this.numberOfWeights = workoutPlan.getNumberOfWeights();
        this.isCompleted = workoutPlan.getCompleted();
        this.notesBox = workoutPlan.getNotesBox();
    }


    public String getWorkoutPlanId() {
        return workoutPlanId;
    }

    public String getWorkoutDayName() {
        return workoutDayName;
    }

    public List<String> getExercisesAdded() {
        return exercisesAdded;
    }

    public List<Integer> getNumberOfSets() {
        return numberOfSets;
    }

    public List<String> getNumberOfReps() {
        return numberOfReps;
    }

    public List<String> getNumberOfWeights() {
        return numberOfWeights;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public String getNotesBox() {
        return notesBox;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkoutPlanModel)) return false;
        WorkoutPlanModel that = (WorkoutPlanModel) o;
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
        return "WorkoutPlanModel{" +
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
