package activity.requests;

public class GetExerciseRequest {

    private final String exerciseId;

    private GetExerciseRequest(String exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getExerciseId() {
        return exerciseId;
    }

    @Override
    public String toString() {
        return "GetExerciseRequest{" +
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

        public GetExerciseRequest build() {
            return new GetExerciseRequest(exerciseId);
        }
    }
}
