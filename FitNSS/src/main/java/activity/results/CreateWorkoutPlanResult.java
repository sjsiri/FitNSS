package activity.results;

import activity.requests.CreateWorkoutPlanRequest;
import dynamodb.models.WorkoutPlan;

public class CreateWorkoutPlanResult {

    private final WorkoutPlan workoutPlan;

    public CreateWorkoutPlanResult(WorkoutPlan workoutPlan) {
        this.workoutPlan = workoutPlan;
    }

    public WorkoutPlan getWorkoutPlan() {
        return workoutPlan;
    }

    @Override
    public String toString() {
        return "CreateWorkoutPlanResult{" +
                "workoutPlan=" + workoutPlan +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private WorkoutPlan workoutPlan = new WorkoutPlan();

        public Builder withWorkoutPlan(WorkoutPlan workoutPlan) {
            this.workoutPlan = workoutPlan;
            return this;
        }

        public CreateWorkoutPlanResult build() {
            return new CreateWorkoutPlanResult(workoutPlan);
        }
    }
}
