package activity.requests;

import com.amazonaws.services.dynamodbv2.model.Delete;

public class DeleteExerciseRequest {

    private String exerciseId;

    private String pathExerciseId;

    private String exerciseName;

    private String workingMuscle;

    private String exerciseMovementGroup;

    private DeleteExerciseRequest(String exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(String exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getPathExerciseId() {
        return pathExerciseId;
    }

    public void setPathExerciseId(String pathExerciseId) {
        this.pathExerciseId = pathExerciseId;
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

    @Override
    public String toString() {
        return "DeleteExerciseRequest{" +
                "exerciseId='" + exerciseId + '\'' +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String exerciseId;

        public Builder withExerciseId(String exerciseId) {
            this.exerciseId = exerciseId;
            return this;
        }

        public DeleteExerciseRequest build() {
            return new DeleteExerciseRequest(exerciseId);
        }

    }
}
