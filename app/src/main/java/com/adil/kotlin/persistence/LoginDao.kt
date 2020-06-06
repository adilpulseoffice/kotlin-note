package com.adil.kotlin.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LoginDao {

    @Query("delete from tbl_login")
    fun deleteToken()

    @Insert
    fun setToken(loginToken: LoginToken)

    @Query("select * from tbl_login")
    fun getToken(): LoginToken
}