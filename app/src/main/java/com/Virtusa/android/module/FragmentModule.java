package com.Virtusa.android.module;



import com.Virtusa.android.fragmets.DataFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by sjena on 25/11/18.
 */

@Module
public abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract DataFragment contributeUserProfileFragment();
}
