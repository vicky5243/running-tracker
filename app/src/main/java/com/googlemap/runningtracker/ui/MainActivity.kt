package com.googlemap.runningtracker.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.googlemap.runningtracker.R
import com.googlemap.runningtracker.utils.Constants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.d("onCreate called!")

        navigateToTrackingFragment(intent)

        setSupportActionBar(toolbar)
        bottomNavigationView.setupWithNavController(main_nav_host_fragment.findNavController())

        // to prevent reload the selected fragment (re-selecting)
        bottomNavigationView.setOnNavigationItemReselectedListener { /* NO-OPERATION */ }

        main_nav_host_fragment.findNavController()
            // trigger when destination change with navigation components
            .addOnDestinationChangedListener { _, destination, _ ->
                when (destination.id) {
                    R.id.settingsFragment, R.id.runFragment, R.id.statisticsFragment ->
                        bottomNavigationView.visibility = View.VISIBLE
                    else -> bottomNavigationView.visibility = View.GONE
                }
            }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        navigateToTrackingFragment(intent)
    }

    private fun navigateToTrackingFragment(intent: Intent?) {
        if (intent?.action == Constants.ACTION_SHOW_TRACKING_FRAGMENT) {
            main_nav_host_fragment.findNavController().navigate(R.id.action_global_trackingFragment)
        }
    }
}