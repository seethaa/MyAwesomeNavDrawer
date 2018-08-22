package com.example.seetha.myawesomenavdrawer

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
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

        showFirstFragment()
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

        val fragment = when (item.itemId) {
            R.id.activity_main_drawer_news -> NewsFeedFragment.newInstance()
            R.id.activity_main_drawer_profile -> ProfilePageFragment.newInstance()
            R.id.activity_main_drawer_settings -> SettingsFragment.newInstance()
            else -> null
        }

        if (fragment != null) showFragment(fragment)

        activity_main_drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun showFirstFragment() {
        val visibleFragment = supportFragmentManager.findFragmentById(R.id.activity_main_frame_layout)
        if (visibleFragment == null) {
            showFragment(NewsFeedFragment.newInstance())
            activity_main_nav_view.setCheckedItem(0)
        }
    }

    private fun showFragment(fragment: Fragment) {
        if (!fragment.isVisible) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.activity_main_frame_layout, fragment).commit()
        }

    }

    private fun configureToolBar() {
        setSupportActionBar(activity_main_toolbar)
    }

    private fun configureDrawerLayout() {
        val toggle = ActionBarDrawerToggle(this, activity_main_drawer_layout,
                activity_main_toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        activity_main_drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun configureNavigationView() {
        activity_main_nav_view.setNavigationItemSelectedListener(this)
    }

}






