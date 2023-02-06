package activity.results;

import dynamodb.models.WorkoutPlan;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GetAllWorkoutPlanResult {

    private final List<WorkoutPlan> workoutPlanList;

    public GetAllWorkoutPlanResult(List<WorkoutPlan> workoutPlanList) {
        this.workoutPlanList = workoutPlanList;
    }

    public List<WorkoutPlan> getWorkoutPlanList() {
        return new ArrayList<>(workoutPlanList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetAllWorkoutPlanResult)) return false;
        GetAllWorkoutPlanResult that = (GetAllWorkoutPlanResult) o;
        return Objects.equals(workoutPlanList, that.workoutPlanList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workoutPlanList);
    }

    @Override
    public String toString() {
        return "GetAllWorkoutPlanResult{" +
                "workoutPlanList=" + workoutPlanList +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private List<WorkoutPlan> workoutPlanList;

        public Builder withWorkoutPlanList(List<WorkoutPlan> workoutPlanList) {
            this.workoutPlanList = new ArrayList<>(workoutPlanList);
            return this;
        }

        public GetAllWorkoutPlanResult build() {
            return new GetAllWorkoutPlanResult(workoutPlanList);
        }
    }
}
