package com.adil.kotlin.di

import androidx.lifecycle.ViewModel

import com.adil.kotlin.ui.main.NoteViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NoteViewModel::class)
    abstract fun bindMainViewModel(moviesViewModel: NoteViewModel): ViewModel
}
