package activity.requests;

import com.amazonaws.services.dynamodbv2.model.Delete;

public class DeleteExerciseRequest {

    private String exerciseId;

    private String userId;


    private DeleteExerciseRequest(String exerciseId, String userId) {
        this.exerciseId = exerciseId;
        this.userId = userId;
    }

    public String getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(String exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "DeleteExerciseRequest{" +
                "exerciseId='" + exerciseId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String exerciseId;

        private String userId;

        public Builder withExerciseId(String exerciseId) {
            this.exerciseId = exerciseId;
            return this;
        }

        public Builder withUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public DeleteExerciseRequest build() {
            return new DeleteExerciseRequest(exerciseId, userId);
        }

    }
}
