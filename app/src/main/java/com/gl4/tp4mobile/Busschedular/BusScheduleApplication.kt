package com.gl4.tp4mobile.Busschedular

import android.app.Application

class BusScheduleApplication : Application() {
    val database: AppDatabase by lazy{
        AppDatabase.getDatabase(this);
    }
}