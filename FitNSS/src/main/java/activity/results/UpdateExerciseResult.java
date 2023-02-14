package activity.results;

import dynamodb.models.Exercise;
import models.ExerciseModel;

public class UpdateExerciseResult {
    private final ExerciseModel exerciseModel;


    public UpdateExerciseResult(ExerciseModel exerciseModel) {
        this.exerciseModel = exerciseModel;
    }

    public ExerciseModel getExercise() {
        return exerciseModel;
    }

    @Override
    public String toString() {
        return "UpdateExerciseResult{" +
                "exerciseModel=" + exerciseModel +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ExerciseModel exerciseModel;

        public Builder withExerciseModel(ExerciseModel exerciseModel) {
            this.exerciseModel = exerciseModel;
            return this;
        }

        public UpdateExerciseResult build() {
            return new UpdateExerciseResult(exerciseModel);

        }
    }
}
