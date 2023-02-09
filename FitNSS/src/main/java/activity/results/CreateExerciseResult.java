package activity.results;

import dynamodb.models.Exercise;

public class CreateExerciseResult {
    private final Exercise exercise;

    public CreateExerciseResult(Exercise exercise) {
        this.exercise = exercise;
    }

    public Exercise getExercise(){
        return exercise;
    }

    @Override
    public String toString() {
        return "CreateExerciseResult{" +
                "exercise=" + exercise +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Exercise exercise = new Exercise();

        public Builder withExercise(Exercise exercise) {
            this.exercise = exercise;
            return this;
        }

        public CreateExerciseResult build() {
            return new CreateExerciseResult(exercise);
        }

    }
}
