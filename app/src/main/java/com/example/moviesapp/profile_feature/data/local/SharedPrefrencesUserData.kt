package com.example.moviesapp.profile_feature.data.local

import android.content.Context
import android.content.SharedPreferences

class SharedPrefrencesUserData(private val context : Context) :
   com.example.moviesapp.profile_feature.data.local.SharedPreferences {
    private lateinit var sharedPref : SharedPreferences

    override fun storeUserName(userName : String) {
        initSharedStorage()
        val e = sharedPref.edit()
        e.putString(SharedPreferencesConstants.USER_NAME_KEY, userName)
        e.apply()
    }

    override fun getUserName() : String? {
        initSharedStorage()
        return sharedPref.getString(SharedPreferencesConstants.USER_NAME_KEY, null)
    }

    override fun storeSessionId(sessionId : String) {
        initSharedStorage()
        val e = sharedPref.edit()
        e.putString(SharedPreferencesConstants.SESSION_ID_KEY, sessionId)
        e.apply()
    }

    override fun storeAccountId(accountId : Int) {
        initSharedStorage()
        val e = sharedPref.edit()
        e.putInt(SharedPreferencesConstants.ACCOUNT_ID_KEY, accountId)
        e.apply()
    }

    override fun getSessionId() : String? {
        initSharedStorage()
        return sharedPref.getString(SharedPreferencesConstants.SESSION_ID_KEY,null)
    }

    override fun getAccountId() : Int {
       initSharedStorage()
        return sharedPref.getInt(SharedPreferencesConstants.ACCOUNT_ID_KEY,0)
    }

    override fun initSharedStorage() {
        sharedPref = context.getSharedPreferences(
            SharedPreferencesConstants.SHARED_STORE_NAME,
            Context.MODE_PRIVATE
        )
    }
}