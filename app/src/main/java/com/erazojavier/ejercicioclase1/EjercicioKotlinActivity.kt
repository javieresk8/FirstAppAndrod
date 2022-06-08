package com.erazojavier.ejercicioclase1

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.erazojavier.ejercicioclase1.databinding.ActivityEjercicioKotlinBinding

class EjercicioKotlinActivity : AppCompatActivity() {
    //Declaracion de variables
    lateinit var buttonSaludo: Button //lateinit para inicializar despues
    var buttonSaludo2: Button? = null

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityEjercicioKotlinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicioKotlinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Inicio del codigo custom
        //Inicializacion de variables
        buttonSaludo = findViewById<Button>(R.id.buttonSaludo)



        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_ejercicio_kotlin)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        //Eventos click
        buttonSaludo.setOnClickListener { miVista: View ->
            Toast.makeText(this, "Saludos desde click", Toast.LENGTH_LONG).show()
            miVista.setBackgroundColor(Color.GREEN)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
    val navController = findNavController(R.id.nav_host_fragment_content_ejercicio_kotlin)
    return navController.navigateUp(appBarConfiguration)
            || super.onSupportNavigateUp()
    }
}