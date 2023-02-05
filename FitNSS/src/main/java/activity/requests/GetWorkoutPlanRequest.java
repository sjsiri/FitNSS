package activity.requests;

public class GetWorkoutPlanRequest {

    private final String workoutPlanId;


    public GetWorkoutPlanRequest(String workoutPlanId) {
        this.workoutPlanId = workoutPlanId;
    }

    public String getWorkoutPlanId() {
        return workoutPlanId;
    }

    @Override
    public String toString() {
        return "GetWorkoutPlanRequest{" +
                "workoutPlanId='" + workoutPlanId + '\'' +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String workoutPlanId;

        public Builder withWorkoutPlanId(String workoutPlanId) {
            this.workoutPlanId = workoutPlanId;
            return this;
        }

        public GetWorkoutPlanRequest build() {
            return new GetWorkoutPlanRequest(workoutPlanId);
        }

    }
}
