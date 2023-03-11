package com.example.feng.bottomnavigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var my_fragments: FrameLayout
    lateinit var myBottomNavMenu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        my_fragments = findViewById(R.id.my_fragments_framelayout)
        myBottomNavMenu = findViewById(R.id.bottom_navigation_view)

        val homeFragment = HomeFragment()
        val profileFragment = ProfileFragment()
        val calendarFragment = CalendarFragment()
        val listFragment = ListFragment()

        setCurrentFragment(homeFragment)

        //Set a Click Listener for the bottom navigation menu
        myBottomNavMenu.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener {
            when(it.itemId){
                R.id.myHomeMenuItem -> setCurrentFragment(homeFragment)
                R.id.myProfileMenuItem -> setCurrentFragment(profileFragment)
                R.id.myCalendarMenuItem -> setCurrentFragment(calendarFragment)
                R.id.myListMenuItem -> setCurrentFragment(listFragment)
            }
            true
        })
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.my_fragments_framelayout, fragment)
            commit()
        }
    }
}