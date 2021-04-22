package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button:Button = findViewById(R.id.btnIniciarSesion) as Button

        button.setOnClickListener{
            var intent: Intent = Intent(this, iniciarSesion2::class.java)
            startActivity(intent)
    }
        val button2:Button = findViewById(R.id.btnRegistrarse) as Button
        button2.setOnClickListener{
            var intent: Intent = Intent(this, registrarse::class.java)
            startActivity(intent)
        }

    }

}