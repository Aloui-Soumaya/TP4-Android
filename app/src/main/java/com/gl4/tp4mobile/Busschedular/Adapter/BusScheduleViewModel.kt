package com.gl4.tp4mobile.Busschedular.Adapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.gl4.tp4mobile.Busschedular.DAO.ScheduleDAO
import com.gl4.tp4mobile.Busschedular.entity.Schedule

class BusScheduleViewModel(private val scheduleDAO: ScheduleDAO): ViewModel() {
    fun fullSchedule(): LiveData<List<Schedule>> = scheduleDAO.getAll()

    fun scheduleForStopName(name: String): LiveData<List<Schedule>> = scheduleDAO.getByStopName(name)
}