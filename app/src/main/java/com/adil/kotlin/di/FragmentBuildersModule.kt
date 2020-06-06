package com.adil.kotlin.di


import com.adil.kotlin.ui.main.AddFragment
import com.adil.kotlin.ui.main.EditFragment
import com.adil.kotlin.ui.main.ListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeListFragment(): ListFragment

    @ContributesAndroidInjector
    abstract fun contributeAddFragment(): AddFragment

    @ContributesAndroidInjector
    abstract fun contributeEditFragment(): EditFragment
}