package com.gl4.tp4mobile

import BusClassAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gl4.tp4mobile.Busschedular.Adapter.BusScheduleViewModel
import com.gl4.tp4mobile.Busschedular.Adapter.BusScheduleViewModelFactory
import com.gl4.tp4mobile.Busschedular.BusScheduleApplication

class DetailsActivity : AppCompatActivity() {
    private val busScheduleViewModel : BusScheduleViewModel by viewModels() {
        BusScheduleViewModelFactory((application as BusScheduleApplication).database.getScheduleDao())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_act)
        val stopName = intent.getStringExtra("stopName")!!
        InitAdapter(stopName)
    }

    private fun InitAdapter(stopName: String) {
        val busClassAdapter = BusClassAdapter(null)
        SetupRecycleView(busClassAdapter)
        InitList(busClassAdapter, stopName)
    }
    private fun InitList(busClassAdapter: BusClassAdapter, stopName: String) {
        busScheduleViewModel
            .scheduleForStopName(stopName)
            .observe(this) {
                busClassAdapter.updateList(it)
            }
    }
    private fun SetupRecycleView(busClassAdapter: BusClassAdapter) {
        val recyclerView: RecyclerView = findViewById(R.id.recycleView)
        recyclerView.layoutManager = LinearLayoutManager(this@DetailsActivity)
        recyclerView.adapter = busClassAdapter
    }

}