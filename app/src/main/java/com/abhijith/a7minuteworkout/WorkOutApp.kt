package com.abhijith.a7minuteworkout

import android.app.Application

class WorkOutApp : Application() {

    val db by lazy {
        HistoryDatabase.getInstance(this)
    }
}