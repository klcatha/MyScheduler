package com.example.kengomaruyama.myscheduler

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import io.realm.Realm
import io.realm.kotlin.where

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {
    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        realm = Realm.getDefaultInstance()
        val schedules = realm.where<Schedule>().findAll()
        listView.adapter=ScheduleAdapter(schedules)

        fab.setOnClickListener { view ->
            startActivity<ScheduleEditActivity>()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}
