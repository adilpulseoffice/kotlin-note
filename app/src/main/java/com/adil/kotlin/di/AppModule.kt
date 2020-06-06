package com.adil.kotlin.di

import android.app.Application
import androidx.room.Room
import com.google.firebase.database.FirebaseDatabase
import com.adil.kotlin.persistence.LoginDao
import com.adil.kotlin.persistence.NoteDao
import com.adil.kotlin.persistence.NoteDatabase
import com.adil.kotlin.repository.NoteRepository
import com.adil.kotlin.session.SessionManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun providesAppDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(app, NoteDatabase::class.java, "note_database").build()
    }

    @Singleton
    @Provides
    fun providesNoteDao(db: NoteDatabase): NoteDao {
        return db.noteDao()
    }

    @Provides
    fun providesRepository(noteDao: NoteDao): NoteRepository {
        return NoteRepository(noteDao)
    }

    @Singleton
    @Provides
    fun providesFirebaseDatabse(): FirebaseDatabase {
        return FirebaseDatabase.getInstance()
    }

    // Method #5
    @Provides
    fun providesSessionManager(loginDao: LoginDao): SessionManager {
        return SessionManager(loginDao)
    }

    @Singleton
    @Provides
    fun providesLoginDao(db: NoteDatabase): LoginDao {
        return db.loginDao()
    }
}