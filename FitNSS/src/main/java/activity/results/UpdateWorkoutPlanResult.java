package activity.results;

import activity.requests.UpdateWorkoutPlanRequest;
import models.WorkoutPlanModel;

public class UpdateWorkoutPlanResult {

    private final WorkoutPlanModel workoutPlanModel;

    /**
     * Constructs results.
     *
     * @param workoutPlanModel the workoutplan to be updated.
     */
    public UpdateWorkoutPlanResult(WorkoutPlanModel workoutPlanModel) {
        this.workoutPlanModel = workoutPlanModel;
    }

    public WorkoutPlanModel getWorkoutPlanModel() {
        return workoutPlanModel;
    }

    @Override
    public String toString() {
        return "UpdateWorkoutPlanResult{" +
                "workoutPlanModel=" + workoutPlanModel +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private WorkoutPlanModel workoutPlanModel;

        public Builder withWorkoutPlanModel(WorkoutPlanModel workoutPlanModel) {
            this.workoutPlanModel = workoutPlanModel;
            return this;
        }

        public UpdateWorkoutPlanResult build() {
            return new UpdateWorkoutPlanResult(workoutPlanModel);
        }
    }
}
