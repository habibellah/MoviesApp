package com.example.moviesapp.profile_feature.data.local

interface SharedPreferences {
    fun storeUserName(userName : String)
    fun getUserName() : String?
    fun storeSessionId(sessionId : String)
    fun storeAccountId(accountId : Int)
    fun getSessionId(): String?
    fun getAccountId():Int
    fun initSharedStorage()
}