package dependency;

import activity.CreateExerciseActivity;
import activity.GetExerciseActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class})
public interface ServiceComponent {

    CreateExerciseActivity provideCreateExerciseActivity();

    GetExerciseActivity provideGetExerciseActivity();
}
