package dadm.jmartor.QuotationShake.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import dadm.jmartor.QuotationShake.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Estava diferent en el pdf de la pràctica
        val navController = binding.fragmentContainerView.getFragment<NavHostFragment>().navController

        binding.bnvInicial.setupWithNavController(navController)
    }
}