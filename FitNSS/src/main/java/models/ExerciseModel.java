package models;

import dynamodb.models.Exercise;

import java.util.Objects;

/**
 * ExerciseModel that is the public API model for FitNSS.
 */
public class ExerciseModel {

    private String exerciseId;
    private String exerciseName;
    private String workingMuscle;
    private String exerciseMovementGroup;

    private String userId;

    public ExerciseModel(Exercise exercise) {
        this.exerciseId = exercise.getExerciseId();
        this.exerciseName = exercise.getExerciseName();
        this.workingMuscle = exercise.getWorkingMuscle();
        this.exerciseMovementGroup = exercise.getExerciseMovementGroup();
        this.userId = exercise.getUserId();
    }

    public String getExerciseId() {
        return exerciseId;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public String getWorkingMuscle() {
        return workingMuscle;
    }

    public String getExerciseMovementGroup() {
        return exerciseMovementGroup;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExerciseModel)) return false;
        ExerciseModel that = (ExerciseModel) o;
        return Objects.equals(exerciseId, that.exerciseId) && Objects.equals(exerciseName, that.exerciseName) && Objects.equals(workingMuscle, that.workingMuscle) && Objects.equals(exerciseMovementGroup, that.exerciseMovementGroup) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exerciseId, exerciseName, workingMuscle, exerciseMovementGroup, userId);
    }

    @Override
    public String toString() {
        return "ExerciseModel{" +
                "exerciseId='" + exerciseId + '\'' +
                ", exerciseName='" + exerciseName + '\'' +
                ", workingMuscle='" + workingMuscle + '\'' +
                ", exerciseMovementGroup='" + exerciseMovementGroup + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
