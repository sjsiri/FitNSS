package activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(builder = GetAllWorkoutPlanRequest.Builder.class)
public class GetAllWorkoutPlanRequest {
    private final String workoutPlanId;

    private final String workoutDayName;

    private final List<String> exercisesAdded;

    private final List<Integer> numberOfSets;

    private final List<String> numberOfReps;

    private final List<String> numberOfWeights;

    private final Boolean isCompleted;

    private final String notesBox;

    private GetAllWorkoutPlanRequest(String workoutPlanId, String workoutDayName, List<String> exercisesAdded,
                                     List<Integer> numberOfSets, List<String> numberOfReps,
                                     List<String> numberOfWeights, Boolean isCompleted, String notesBox) {
        this.workoutPlanId = workoutPlanId;
        this.workoutDayName = workoutDayName;
        this.exercisesAdded = exercisesAdded;
        this.numberOfSets = numberOfSets;
        this.numberOfReps = numberOfReps;
        this.numberOfWeights = numberOfWeights;
        this.isCompleted = isCompleted;
        this.notesBox = notesBox;
    }

    public String getWorkoutPlanId() {
        return workoutPlanId;
    }

    public String getWorkoutDayName() {
        return workoutDayName;
    }

    public List<String> getExercisesAdded() {
        return exercisesAdded;
    }

    public List<Integer> getNumberOfSets() {
        return numberOfSets;
    }

    public List<String> getNumberOfReps() {
        return numberOfReps;
    }

    public List<String> getNumberOfWeights() {
        return numberOfWeights;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public String getNotesBox() {
        return notesBox;
    }

    @Override
    public String toString() {
        return "GetAllWorkoutPlanRequest{" +
                "workoutPlanId='" + workoutPlanId + '\'' +
                ", workoutDayName='" + workoutDayName + '\'' +
                ", exercisesAdded=" + exercisesAdded +
                ", numberOfSets=" + numberOfSets +
                ", numberOfReps=" + numberOfReps +
                ", numberOfWeights=" + numberOfWeights +
                ", isCompleted=" + isCompleted +
                ", notesBox='" + notesBox + '\'' +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String workoutPlanId;

        private String workoutDayName;

        private List<String> exercisesAdded;

        private List<Integer> numberOfSets;

        private List<String> numberOfReps;

        private List<String> numberOfWeights;

        private Boolean isCompleted;

        private String notesBox;

        public Builder withWorkoutPlanId(String workoutPlanId) {
            this.workoutPlanId = workoutPlanId;
            return this;
        }

        public Builder withWorkoutDayName(String workoutDayName) {
            this.workoutDayName = workoutDayName;
            return this;
        }

        public Builder withExercisesAdded(List<String> exercisesAdded) {
            this.exercisesAdded = exercisesAdded;
            return this;
        }

        public Builder withNumberOfSets(List<Integer> numberOfSets) {
            this.numberOfSets = numberOfSets;
            return this;
        }

        public Builder withNumbersOfReps(List<String> numberOfReps) {
            this.numberOfReps = numberOfReps;
            return this;
        }

        public Builder withNumberOfWeights(List<String> numberOfWeights) {
            this.numberOfWeights = numberOfWeights;
            return this;
        }

        public Builder withIsCompleted(Boolean isCompleted) {
            this.isCompleted = isCompleted;
            return this;
        }

        public Builder withNotesBox(String notesBox) {
            this.notesBox = notesBox;
            return this;
        }

        public GetAllWorkoutPlanRequest build() {
            return new GetAllWorkoutPlanRequest(workoutPlanId, workoutDayName, exercisesAdded, numberOfSets, numberOfReps, numberOfWeights, isCompleted, notesBox);
        }
    }
}
