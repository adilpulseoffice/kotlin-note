package com.adil.kotlin.di

import android.app.Application
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.adil.kotlin.R
import dagger.Module
import dagger.Provides

@Module
class LoginModule {

    @Provides
    fun providesGso(app: Application): GoogleSignInOptions {
        return GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(app.getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
    }

    @Provides
    fun providesGoogleSignInClients(
        gso: GoogleSignInOptions,
        app: Application
    ): GoogleSignInClient {
        return GoogleSignIn.getClient(app, gso)
    }
}
