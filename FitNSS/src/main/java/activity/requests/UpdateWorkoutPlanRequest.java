package activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.List;

@JsonDeserialize(builder = UpdateWorkoutPlanRequest.Builder.class)
public class UpdateWorkoutPlanRequest {

    private String workoutPlanId;

    private String workoutDayName;

    private List<String> exercisesAdded;

    private List<Integer> numberOfSets;

    private List<String> numberOfReps;

    private List<String> numberOfWeights;

    private String notesBox;

    private String userId;


    public UpdateWorkoutPlanRequest(String workoutPlanId, String workoutDayName,
                                    List<String> exercisesAdded, List<Integer> numberOfSets,
                                    List<String> numberOfReps, List<String> numberOfWeights,
                                    String notesBox, String userId) {
        this.workoutPlanId = workoutPlanId;
        this.workoutDayName = workoutDayName;
        this.exercisesAdded = exercisesAdded;
        this.numberOfSets = numberOfSets;
        this.numberOfReps = numberOfReps;
        this.numberOfWeights = numberOfWeights;
        this.notesBox = notesBox;
        this.userId = userId;
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

    public String getNotesBox() {
        return notesBox;
    }
    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "UpdateWorkoutPlanRequest{" +
                "workoutPlanId='" + workoutPlanId + '\'' +
                ", pathWorkoutPlanId='" +
                ", workoutDayName='" + workoutDayName + '\'' +
                ", exercisesAdded=" + exercisesAdded +
                ", numberOfSets=" + numberOfSets +
                ", numberOfReps=" + numberOfReps +
                ", numberOfWeights=" + numberOfWeights +
                ", notesBox='" + notesBox + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + '\'' +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    public static class Builder {

        private String workoutPlanId;

        private String workoutDayName;

        private List<String> exercisesAdded;

        private List<Integer> numberOfSets;

        private List<String> numberOfReps;

        private List<String> numberOfWeights;

        private String notesBox;

        private String userId;

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

        public Builder withNumberOfReps(List<String> numberOfReps) {
            this.numberOfReps = numberOfReps;
            return this;
        }

        public Builder withNumberOfWeights(List<String> numberOfWeights) {
            this.numberOfWeights = numberOfWeights;
            return this;
        }

        public Builder withNotesBox(String notesBox) {
            this.notesBox = notesBox;
            return this;
        }

        public Builder withUserId(String userId) {
            this.userId = userId;
            return this;
        }


        public UpdateWorkoutPlanRequest build() {
            return new UpdateWorkoutPlanRequest(workoutPlanId, workoutDayName, exercisesAdded,
                    numberOfSets, numberOfReps, numberOfWeights, notesBox, userId);
        }

    }
}
