package dependency;

import activity.*;
import dagger.Component;
import dagger.Provides;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class})
public interface ServiceComponent {
    CreateExerciseActivity provideCreateExerciseActivity();
    GetExerciseActivity provideGetExerciseActivity();
    GetAllExercisesActivity provideGetAllExercisesActivity();
    UpdateExerciseActivity provideUpdateExerciseActivity();

    DeleteExerciseActivity provideDeleteExerciseActivity();

    GetAllExercisesByMovementGroupActivity provideGetAllExercisesByMovementGroupActivity();

    GetAllExercisesByMuscleActivity provideGetAllExercisesByMuscle();

    GetWorkoutPlanActivity provideGetWorkoutPlanActivity();

    GetAllWorkoutPlanActivity provideGetAllWorkoutPlanActivity();

}
