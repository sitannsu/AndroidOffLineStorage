package com.Virtusa.android.di.component;

import android.app.Application;

import com.Virtusa.android.App;
import com.Virtusa.android.di.module.ActivityModule;
import com.Virtusa.android.di.module.AppModule;
import com.Virtusa.android.di.module.FragmentModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by sjena on 25/11/18.
 */

@Singleton
@Component(modules={AndroidSupportInjectionModule.class, ActivityModule.class, FragmentModule.class, AppModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }

    void inject(App app);
}
