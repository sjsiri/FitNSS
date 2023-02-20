package activity.requests;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = CreateExerciseRequest.Builder.class)
public class CreateExerciseRequest {

    private final String exerciseId;

    private final String exerciseName;

    private final String workingMuscle;

    private final String exerciseMovementGroup;

    private final String userId;

    public CreateExerciseRequest(String exerciseId, String exerciseName, String workingMuscle, String exerciseMovementGroup, String userId) {
        this.exerciseId = exerciseId;
        this.exerciseName = exerciseName;
        this.workingMuscle = workingMuscle;
        this.exerciseMovementGroup = exerciseMovementGroup;
        this.userId = userId;
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
    public String toString() {
        return "CreateExerciseRequest{" +
                "exerciseId='" + exerciseId + '\'' +
                ", exerciseName='" + exerciseName + '\'' +
                ", workingMuscle='" + workingMuscle + '\'' +
                ", exerciseMovementGroup='" + exerciseMovementGroup + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    public static class Builder {
        private String exerciseId;

        private String exerciseName;

        private String workingMuscle;

        private String exerciseMovementGroup;

        private String userId;

        public Builder withExerciseId(String exerciseId) {
            this.exerciseId = exerciseId;
            return this;
        }

        public Builder withExerciseName(String exerciseName) {
            this.exerciseName = exerciseName;
            return this;
        }

        public Builder withWorkingMuscle(String workingMuscle) {
            this.workingMuscle = workingMuscle;
            return this;
        }

        public Builder withExerciseMovementGroup(String exerciseMovementGroup) {
            this.exerciseMovementGroup = exerciseMovementGroup;
            return this;
        }

        public Builder withUserId(String userId) {
            this.userId = userId;
            return this;
        }
        public CreateExerciseRequest build() {
            return new CreateExerciseRequest(
                    exerciseId,
                    exerciseName,
                    workingMuscle,
                    exerciseMovementGroup, userId);
        }

    }
}
