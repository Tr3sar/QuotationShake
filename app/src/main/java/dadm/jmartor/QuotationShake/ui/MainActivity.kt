package dadm.jmartor.QuotationShake.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationBarView
import dadm.jmartor.QuotationShake.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Estava diferent en el pdf de la pràctica
        val navController = binding.fragmentContainerView.getFragment<NavHostFragment>().navController

        (binding.bnvInicial as NavigationBarView).setupWithNavController(navController)
        setSupportActionBar(binding.materialToolbar5)
        setupActionBarWithNavController(navController, AppBarConfiguration(navController.graph))
    }
}