package dependency;

import activity.*;
import dagger.Component;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Dagger component for providing dependency injection in the FitNSS.
 */
@Singleton
@Component(modules = {DaoModule.class})
public interface ServiceComponent {

    /**
     * Provides the relevant activity.
     * @return CreateExerciseActivity
     */
    CreateExerciseActivity provideCreateExerciseActivity();

    /**
     * Provides the relevant activity.
     * @return GetExerciseActivity
     */
    GetExerciseActivity provideGetExerciseActivity();

    /**
     * Provides the relevant activity.
     * @return GetAllExercisesActivity
     */
    GetAllExercisesActivity provideGetAllExercisesActivity();

    /**
     * Provides the relevant activity.
     * @return UpdateExerciseActivity
     */
    UpdateExerciseActivity provideUpdateExerciseActivity();

    /**
     * Provides the relevant activity.
     * @return DeleteExerciseActivity
     */
    DeleteExerciseActivity provideDeleteExerciseActivity();


    /**
     * Provides the relevant activity.
     * @return GetAllExercisesByMovementGroupActivity
     */
    GetAllExercisesByMovementGroupActivity provideGetAllExercisesByMovementGroupActivity();

    /**
     * Provides the relevant activity.
     * @return GetAllExercisesByMuscleActivity
     */
    GetAllExercisesByMuscleActivity provideGetAllExercisesByMuscle();

    /**
     * Provides the relevant activity.
     * @return GetWorkoutPlanActivity
     */
    GetWorkoutPlanActivity provideGetWorkoutPlanActivity();

    /**
     * Provides the relevant activity.
     * @return GetAllWorkoutPlanActivity
     */
    GetAllWorkoutPlanActivity provideGetAllWorkoutPlanActivity();

    /**
     * Provides the relevant activity.
     * @return CreateWorkoutPlanActivity
     */
    CreateWorkoutPlanActivity provideCreateWorkoutPlanActivity();

    /**
     * Provides the relevant activity.
     * @return UpdateWorkoutPlanActivity
     */
    UpdateWorkoutPlanActivity provideUpdateWorkoutPlanActivity();

    /**
     * Provides the relevant activity.
     * @return DeleteWorkoutPlanActivity
     */
    DeleteWorkoutPlanActivity provideDeleteWorkoutPlanActivity();
}
