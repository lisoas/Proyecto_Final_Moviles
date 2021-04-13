package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuPrincipalMeet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal_meet)

        val button: Button = findViewById(R.id.btnRegistrarse) as Button
        button.setOnClickListener{
            var intent: Intent = Intent(this, grabarVideoconferencias::class.java)
            startActivity(intent)
        }

    }
}