package activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = GetAllExercisesRequest.Builder.class)
public class GetAllExercisesRequest {

    private final String exerciseId;
    private final String exerciseName;
    private final String exerciseMuscle;
    private final String exerciseMovementGroup;

    private GetAllExercisesRequest(String exerciseId, String exerciseName, String exerciseMuscle, String exerciseMovementGroup) {
        this.exerciseId = exerciseId;
        this.exerciseName = exerciseName;
        this.exerciseMuscle = exerciseMuscle;
        this.exerciseMovementGroup = exerciseMovementGroup;
    }

    public String getExerciseId() {
        return exerciseId;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public String getExerciseMuscle() {
        return exerciseMuscle;
    }

    public String getExerciseMovementGroup() {
        return exerciseMovementGroup;
    }


    @Override
    public String toString() {
        return "GetAllExercisesRequest{" +
                "exerciseId='" + exerciseId + '\'' +
                ", exerciseName='" + exerciseName + '\'' +
                ", exerciseMuscle='" + exerciseMuscle + '\'' +
                ", exerciseMovementGroup='" + exerciseMovementGroup + '\'' +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String exerciseId;
        private String exerciseName;
        private String exerciseMuscle;
        private String exerciseMovementGroup;

        public Builder withExerciseId(String exerciseId) {
            this.exerciseId = exerciseId;
            return this;
        }

        public Builder withExerciseName(String exerciseName) {
            this.exerciseName = exerciseName;
            return this;
        }

        public Builder withExerciseMuscle(String exerciseMuscle) {
            this.exerciseMuscle = exerciseMuscle;
            return this;
        }

        public Builder withExerciseMovementGroup(String exerciseMovementGroup) {
            this.exerciseMovementGroup = exerciseMovementGroup;
            return this;
        }

        public GetAllExercisesRequest build() {
            return new GetAllExercisesRequest(exerciseId, exerciseName, exerciseMuscle, exerciseMovementGroup);
        }
    }
}
