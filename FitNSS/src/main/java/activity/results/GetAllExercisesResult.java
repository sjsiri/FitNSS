package activity.results;

import dynamodb.models.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GetAllExercisesResult {

    private final List<Exercise> exerciseList;

    /**
     * Instantiates a new GetAllExercisesResult object.
     *
     * @param exerciseList to access the exercise table.
     */
    public GetAllExercisesResult(List<Exercise> exerciseList) {
        this.exerciseList = new ArrayList<>(exerciseList);
    }

    public List<Exercise> getExerciseList() {
        return new ArrayList<>(exerciseList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetAllExercisesResult)) return false;
        GetAllExercisesResult that = (GetAllExercisesResult) o;
        return Objects.equals(exerciseList, that.exerciseList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exerciseList);
    }

    @Override
    public String toString() {
        return "GetAllExercisesResult{" +
                "exerciseList=" + exerciseList +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<Exercise> exerciseList;

        public Builder withExerciseList(List<Exercise> exerciseList) {
            this.exerciseList = new ArrayList<>(exerciseList);
            return this;
        }

        public GetAllExercisesResult build() {
            return new GetAllExercisesResult(exerciseList);
        }
    }
}
