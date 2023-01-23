package main.dynamodb.models;

import java.util.Objects;

public class Exercise {

    private String exerciseId;
    private String exerciseName;
    private String workingMuscle;
    private String exerciseMovementGroup;


    public String getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(String exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getWorkingMuscle() {
        return workingMuscle;
    }

    public void setWorkingMuscle(String workingMuscle) {
        this.workingMuscle = workingMuscle;
    }

    public String getExerciseMovementGroup() {
        return exerciseMovementGroup;
    }

    public void setExerciseMovementGroup(String exerciseMovementGroup) {
        this.exerciseMovementGroup = exerciseMovementGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exercise)) return false;
        Exercise exercise = (Exercise) o;
        return Objects.equals(exerciseId, exercise.exerciseId) &&
                Objects.equals(exerciseName, exercise.exerciseName) &&
                Objects.equals(workingMuscle, exercise.workingMuscle) &&
                Objects.equals(exerciseMovementGroup, exercise.exerciseMovementGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exerciseId, exerciseName, workingMuscle, exerciseMovementGroup);
    }
}
