package dadm.jmartor.QuotationShake.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.view.MenuProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationBarView
import dadm.jmartor.QuotationShake.R
import dadm.jmartor.QuotationShake.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MenuProvider {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Estava diferent en el pdf de la pràctica
        navController = binding.fragmentContainerView.getFragment<NavHostFragment>().navController

        val appBarConfiguration = AppBarConfiguration(setOf(R.id.newSettingsFragment, R.id.newQuotationFragment, R.id.newFavouritesFragment))

        (binding.bnvInicial as NavigationBarView).setupWithNavController(navController)
        setSupportActionBar(binding.materialToolbar5)
        setupActionBarWithNavController(navController, appBarConfiguration)

        addMenuProvider(this)
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_about, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when(menuItem.itemId) {
            R.id.aboutDialogFragment -> {
                navController.navigate(R.id.aboutDialogFragment)
                true
            }
            else -> false
        }
    }
}