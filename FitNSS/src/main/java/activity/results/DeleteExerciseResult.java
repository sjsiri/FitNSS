package activity.results;

import dynamodb.models.Exercise;
import models.ExerciseModel;

public class DeleteExerciseResult {

    private final ExerciseModel exercise;

    public DeleteExerciseResult(Exercise exercise) {
        this.exercise = new ExerciseModel(exercise);
    }

    public ExerciseModel getExercise() {
        return exercise;
    }

    @Override
    public String toString() {
        return "DeleteExerciseResult{" +
                "exercise=" + exercise +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Exercise exercise;

        public Builder withExercise(Exercise exercise) {
            this.exercise = exercise;
            return this;
        }

        public DeleteExerciseResult build() {
            return new DeleteExerciseResult(exercise);
        }

    }
}
