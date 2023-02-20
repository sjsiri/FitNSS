package activity.results;

import activity.requests.DeleteWorkoutPlanRequest;
import dynamodb.models.WorkoutPlan;
import models.WorkoutPlanModel;

public class DeleteWorkoutPlanResult {

    private final WorkoutPlanModel workoutPlan;

    public DeleteWorkoutPlanResult(WorkoutPlan workoutPlan) {
        this.workoutPlan = new WorkoutPlanModel(workoutPlan);
    }

    public WorkoutPlanModel getWorkoutPlan() {
        return workoutPlan;
    }

    @Override
    public String toString() {
        return "DeleteWorkoutPlanResult{" +
                "workoutPlan=" + workoutPlan +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private WorkoutPlan workoutPlan;

        public Builder withWorkoutPlan(WorkoutPlan workoutPlan) {
            this.workoutPlan = workoutPlan;
            return this;
        }

        public DeleteWorkoutPlanResult build() {
            return new DeleteWorkoutPlanResult(workoutPlan);
        }
    }
}
