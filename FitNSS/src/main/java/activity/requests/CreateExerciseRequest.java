package activity.requests;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = CreateExerciseRequest.Builder.class)
public class CreateExerciseRequest {

    private final String exerciseId;

    private final String exerciseName;

    private final String workingMuscle;

    private final String exerciseMovementGroup;

    public CreateExerciseRequest(String exerciseId, String exerciseName, String workingMuscle, String exerciseMovementGroup) {
        this.exerciseId = exerciseId;
        this.exerciseName = exerciseName;
        this.workingMuscle = workingMuscle;
        this.exerciseMovementGroup = exerciseMovementGroup;
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
        public CreateExerciseRequest build() {
            return new CreateExerciseRequest(
                    exerciseId,
                    exerciseName,
                    workingMuscle,
                    exerciseMovementGroup);
        }

    }
}
