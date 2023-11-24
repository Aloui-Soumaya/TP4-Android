package com.gl4.tp4mobile.Busschedular.Adapter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gl4.tp4mobile.Busschedular.DAO.ScheduleDAO

class BusScheduleViewModelFactory(
    private val scheduleDao: ScheduleDAO
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BusScheduleViewModel::class.java))
        {
            @Suppress("UNCHECKED_CAST")
            return BusScheduleViewModel(scheduleDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}