package activity.results;

import dynamodb.models.WorkoutPlan;
import models.WorkoutPlanModel;

public class GetWorkoutPlanResult {

    private final WorkoutPlanModel workoutPlan;

    public GetWorkoutPlanResult(WorkoutPlan workoutPlan) {
        this.workoutPlan = new WorkoutPlanModel(workoutPlan);
    }

    public WorkoutPlanModel getWorkoutPlan() {
        return workoutPlan;
    }

    @Override
    public String toString() {
        return "GetWorkoutPlanResult{" +
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

        public GetWorkoutPlanResult build() {
            return new GetWorkoutPlanResult(workoutPlan);
        }
    }
}
