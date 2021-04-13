package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class iniciarSesion2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar_sesion2)
        val button: Button = findViewById(R.id.iniciar) as Button

        button.setOnClickListener{
            var intent: Intent =Intent(this, MenuPrincipal_1::class.java)
            startActivity(intent)
        }
    }
}