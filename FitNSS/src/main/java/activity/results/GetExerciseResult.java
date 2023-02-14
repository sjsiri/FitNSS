package activity.results;

import dynamodb.models.Exercise;
import models.ExerciseModel;

public class GetExerciseResult {

    private final ExerciseModel exercise;
    /**
     * Instantiates a new GetExercise object.
     *
     * @param exercise Exercise to access the exercise table.
     */
    public GetExerciseResult(Exercise exercise) {
        this.exercise = new ExerciseModel(exercise);
    }

    public ExerciseModel getExercise() {
        return exercise;
    }

    @Override
    public String toString() {
        return "GetExerciseResult{" +
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
        public GetExerciseResult build() {
            return new GetExerciseResult(exercise);
        }

    }
}
