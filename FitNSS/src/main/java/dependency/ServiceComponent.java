package dependency;

import activity.CreateExerciseActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class})
public interface ServiceComponent {

    CreateExerciseActivity provideCreateExerciseActivity();
}
