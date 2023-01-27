package activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = UpdateExerciseRequest.Builder.class)
public class UpdateExerciseRequest {

    private String exerciseId;
    private String exerciseName;
    private String workingMuscle;
    private String exerciseMovementGroup;

    public UpdateExerciseRequest(String exerciseId, String exerciseName, String workingMuscle, String exerciseMovementGroup) {
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

    @Override
    public String toString() {
        return "UpdateExerciseRequest{" +
                "exerciseId='" + exerciseId + '\'' +
                ", exerciseName='" + exerciseName + '\'' +
                ", workingMuscle='" + workingMuscle + '\'' +
                ", exerciseMovementGroup='" + exerciseMovementGroup + '\'' +
                '}';
    }

    @JsonPOJOBuilder
    public static class Builder {
        private String exerciseId;
        private String exerciseName;
        private String workingMuscle;
        private String exerciseMovementGroup;

        public Builder withExerciseId(String exerciseId) {
            this.exerciseId =  exerciseId;
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

        public UpdateExerciseRequest build() {
            return new UpdateExerciseRequest(exerciseId, exerciseName, workingMuscle, exerciseMovementGroup);
        }

    }
}
