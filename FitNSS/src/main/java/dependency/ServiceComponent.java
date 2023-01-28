package dependency;

import activity.CreateExerciseActivity;
import activity.GetAllExercisesActivity;
import activity.GetExerciseActivity;
import activity.UpdateExerciseActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class})
public interface ServiceComponent {

    CreateExerciseActivity provideCreateExerciseActivity();

    GetExerciseActivity provideGetExerciseActivity();

    GetAllExercisesActivity provideGetAllExercisesActivity();

    UpdateExerciseActivity provideUpdateExerciseActivity();
}
