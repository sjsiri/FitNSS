package activity.requests;

public class DeleteWorkoutPlanRequest {

    private String workoutPlanId;

    private String userId;

    private DeleteWorkoutPlanRequest(String workoutPlanId, String userId) {
        this.workoutPlanId = workoutPlanId;
        this.userId = userId;
    }

    public String getWorkoutPlanId() {
        return workoutPlanId;
    }

    public void setWorkoutPlanId(String workoutPlanId) {
        this.workoutPlanId = workoutPlanId;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "DeleteWorkoutPlanRequest{" +
                "workoutPlanId='" + workoutPlanId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String workoutPlanId;

        private String userId;

        public Builder withWorkoutPlanId(String workoutPlanId) {
            this.workoutPlanId = workoutPlanId;
            return this;
        }

        public Builder withUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public DeleteWorkoutPlanRequest build() {
            return new DeleteWorkoutPlanRequest(workoutPlanId, userId);
        }
    }
}
