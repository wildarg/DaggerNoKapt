package com.wild.mydaggernokaptapp.di;

import com.wild.mydaggernokaptapp.AndroidToaster;
import com.wild.mydaggernokaptapp.Greetings;
import com.wild.mydaggernokaptapp.GreetingsImpl;
import com.wild.mydaggernokaptapp.Toaster;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ToolsModule {
    @Binds
    abstract Toaster provideToaster(AndroidToaster impl);

    @Binds
    abstract Greetings provideGreetings(GreetingsImpl impl);
}
