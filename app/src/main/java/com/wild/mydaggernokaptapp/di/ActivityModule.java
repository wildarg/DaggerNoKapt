package com.wild.mydaggernokaptapp.di;

import android.content.Context;

import com.wild.mydaggernokaptapp.AndroidToaster;
import com.wild.mydaggernokaptapp.Greetings;
import com.wild.mydaggernokaptapp.GreetingsImpl;
import com.wild.mydaggernokaptapp.Toaster;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private final Context context;

    public ActivityModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    Context provideContext() {
        return context;
    }

    @Provides
    Toaster provideToaster(Context context) {
        return new AndroidToaster(context);
    }

    @Provides
    Greetings provideGreetings(Toaster toaster) {
        return new GreetingsImpl(toaster);
    }

}