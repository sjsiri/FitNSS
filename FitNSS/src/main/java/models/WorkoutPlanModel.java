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

    private String notesBox;

    private String userId;

    public WorkoutPlanModel(WorkoutPlan workoutPlan) {
        this.workoutPlanId = workoutPlan.getWorkoutPlanId();
        this.workoutDayName = workoutPlan.getWorkoutDayName();
        this.exercisesAdded = workoutPlan.getExercisesAdded();
        this.numberOfSets = workoutPlan.getNumberOfSets();
        this.numberOfReps = workoutPlan.getNumberOfReps();
        this.numberOfWeights = workoutPlan.getNumberOfWeights();
        this.notesBox = workoutPlan.getNotesBox();
        this.userId = workoutPlan.getUserId();
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

    public String getNotesBox() {
        return notesBox;
    }


    public String getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkoutPlanModel)) return false;
        WorkoutPlanModel that = (WorkoutPlanModel) o;
        return Objects.equals(workoutPlanId, that.workoutPlanId) && Objects.equals(workoutDayName, that.workoutDayName) &&
                Objects.equals(exercisesAdded, that.exercisesAdded) && Objects.equals(numberOfSets, that.numberOfSets) &&
                Objects.equals(numberOfReps, that.numberOfReps) && Objects.equals(numberOfWeights, that.numberOfWeights) &&
                Objects.equals(notesBox, that.notesBox) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workoutPlanId, workoutDayName, exercisesAdded, numberOfSets,
                numberOfReps, numberOfWeights, notesBox, userId);
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
                ", notesBox='" + notesBox + '\'' +
                '}';
    }
}
