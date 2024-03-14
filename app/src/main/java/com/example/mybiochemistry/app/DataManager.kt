package com.example.mybiochemistry.app

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.example.mybiochemistry.R

class DataManager(private val baseContext: Context)  {
    private val appName = baseContext.getString(R.string.app_name)
    private lateinit var masterKey: MasterKey
    private lateinit var encryptedSharedPreferences: EncryptedSharedPreferences
    private val tokenString = baseContext.getString(R.string.app_token)
    private val preferences = baseContext.getSharedPreferences(appName, Context.MODE_PRIVATE)

    fun initEncryptedSharedPrefs(context: Context) {
        masterKey = MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build()
        encryptedSharedPreferences = EncryptedSharedPreferences.create(
            context,
            appName,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        ) as EncryptedSharedPreferences
    }
    fun encryptToken(token: String) {
        encryptedSharedPreferences.edit().putString(baseContext.getString(R.string.crypt_token), token).apply()
    }

    fun decryptToken(): String {
        return encryptedSharedPreferences.getString(baseContext.getString(R.string.crypt_token), "") ?: ""
    }
    fun passLogin() {
        preferences.edit().putBoolean(baseContext.getString(R.string.login_passed), true).apply()
    }

    fun isLoginPassed(): Boolean {
        return preferences.getBoolean(baseContext.getString(R.string.login_passed), false)
    }
    fun logout(){
        preferences.edit().putString(tokenString, "").apply()
        preferences.edit().putBoolean(baseContext.getString(R.string.login_passed), false).apply()
    }
}