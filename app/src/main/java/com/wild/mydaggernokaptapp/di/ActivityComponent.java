package com.wild.mydaggernokaptapp.di;

import com.wild.mydaggernokaptapp.MainActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Singleton
@Component(
        modules = {
                AndroidInjectionModule.class,
                ActivityModule.class
        }
)
public abstract class ActivityComponent implements AndroidInjector<MainActivity> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder activity(MainActivity activity);
        Builder activityModule(ActivityModule module);
        ActivityComponent build();
    }

    public static ActivityComponent initAndInject(MainActivity activity) {
        final ActivityComponent component = DaggerActivityComponent.builder()
                .activity(activity)
                .activityModule(new ActivityModule(activity))
                .build();

        component.inject(activity);
        return component;
    }

}

