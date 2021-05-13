package com.example.proyectofinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class MenuPrincipal_1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal_1)
        //val navView: BottomNavigationView = findViewById(R.id.nav_view)

        //val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        //setupActionBarWithNavController(navController, appBarConfiguration)
        //navView.setupWithNavController(navController)

        /*val button: ImageButton = findViewById(R.id.btnMeet) as ImageButton
        button.setOnClickListener{
            var intent: Intent = Intent(this, MenuPrincipalMeet::class.java)
            startActivity(intent)
        }*/

    }


}