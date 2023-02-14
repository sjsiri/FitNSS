package activity;

import activity.requests.CreateWorkoutPlanRequest;
import activity.results.CreateWorkoutPlanResult;
import dynamodb.WorkoutPlanDao;
import dynamodb.models.WorkoutPlan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.FitNSSserviceUtils;

import javax.inject.Inject;

public class CreateWorkoutPlanActivity {

    private final Logger log;

    private final WorkoutPlanDao workoutPlanDao;

    @Inject
    public CreateWorkoutPlanActivity(WorkoutPlanDao workoutPlanDao) {
        this.workoutPlanDao = workoutPlanDao;
        log = LogManager.getLogger();
    }

    public CreateWorkoutPlanResult handleRequest(CreateWorkoutPlanRequest request) {
        log.info("Received Create Workout Plan Request {}", request);

        String userId = request.getUserId();

        WorkoutPlan workoutPlan = new WorkoutPlan();
        workoutPlan.setWorkoutPlanId(FitNSSserviceUtils.generateExerciseId());
        workoutPlan.setWorkoutDayName(request.getWorkoutDayName());
        workoutPlan.setUserId(request.getUserId());
        workoutPlan.setExercisesAdded(request.getExercisesAdded());
        workoutPlan.setNumberOfSets(request.getNumberOfSets());
        workoutPlan.setNumberOfReps(request.getNumberOfReps());
        workoutPlan.setNumberOfWeights(request.getNumberOfWeights());
        workoutPlan.setNotesBox(request.getNotesBox());

        workoutPlanDao.saveWorkoutPlan(workoutPlan);

        return CreateWorkoutPlanResult.builder()
                .withWorkoutPlan(workoutPlan)
                .build();
    }
}
