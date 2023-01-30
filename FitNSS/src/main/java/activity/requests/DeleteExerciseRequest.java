package activity.requests;

import com.amazonaws.services.dynamodbv2.model.Delete;

public class DeleteExerciseRequest {

    private final String exerciseId;

    private DeleteExerciseRequest(String exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getExerciseId() {
        return exerciseId;
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
