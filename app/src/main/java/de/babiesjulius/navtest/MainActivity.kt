package de.babiesjulius.navtest

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.tbMain))

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController: NavController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        findViewById<MaterialToolbar>(R.id.tbMain)
            .setupWithNavController(navController, appBarConfiguration)
        findViewById<BottomNavigationView>(R.id.bnb)
            .setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, _, arguments ->
            findViewById<BottomNavigationView>(R.id.bnb).isVisible =
                arguments?.getBoolean("ShowAppBar", false) == true
        }
    }
}