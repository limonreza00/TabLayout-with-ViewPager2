package com.coderscastle.tablayout

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var tabLayout : TabLayout
    private lateinit var viewPager : ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager2)

        val pageAdapter = FragmentAdapter (supportFragmentManager,lifecycle)
        pageAdapter.addFragment(HomeFragment(),"Home")
        pageAdapter.addFragment(ProfileFragment(),"Profile")
        pageAdapter.addFragment(NotificationFragment(),"Notification")

        viewPager.adapter = pageAdapter
        TabLayoutMediator(tabLayout,viewPager){tab,position ->
            tab.text = pageAdapter.getPageTitle(position)
        }.attach()
    }
}