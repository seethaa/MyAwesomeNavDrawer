package com.example.seetha.myawesomenavdrawer

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureToolBar()
        configureDrawerLayout()
        configureNavigationView()
    }

    override fun onBackPressed() {
        super.onBackPressed()

        if (activity_main_drawer_layout.isDrawerOpen(GravityCompat.START)) {
            activity_main_drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.activity_main_drawer_news -> null
            R.id.activity_main_drawer_profile -> null
            R.id.activity_main_drawer_settings -> null
            else -> null
        }

        activity_main_drawer_layout.closeDrawer(GravityCompat.START)

        return true
    }

    private fun configureToolBar() {
        setSupportActionBar(activity_main_toolbar)
    }

    private fun configureDrawerLayout() {
        val toggle = ActionBarDrawerToggle(this, activity_main_drawer_layout,
                activity_main_toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        activity_main_drawer_layout.addDrawerListener(toggle);
        toggle.syncState()
    }

    private fun configureNavigationView() {
        activity_main_nav_view.setNavigationItemSelectedListener(this);

    }

}






