package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class registrarse : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse)

        auth = Firebase.auth

        val btn_ingresar: Button = findViewById(R.id.iniciar2)

        btn_ingresar.setOnClickListener{
            valida_registro()
        }
    }

    private fun valida_registro(){
        val et_correo: EditText = findViewById(R.id.campoCorreo)
        val et_contra1: EditText = findViewById(R.id.campoContrasenia)
       /* val et_contra2: EditText = findViewById(R.id.et_contra2_reg)*/

        var correo: String = et_correo.text.toString()
        var contra1: String = et_contra1.text.toString()
        /*var contra2: String = et_contra2.text.toString()*/

        if(!correo.isNullOrBlank() && !contra1.isNullOrBlank()){

            registrarFirebase(correo, contra1)
            Toast.makeText(this, "Se ha registrado correctamente",
                Toast.LENGTH_SHORT).show()

        }else{
            Toast.makeText(this, "Ingresar datos",
                Toast.LENGTH_SHORT).show()
        }
    }

    private fun registrarFirebase(correo:String, contra1:String){
        auth.createUserWithEmailAndPassword(correo, contra1)

            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    //Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    Toast.makeText(baseContext, "${user.email} se ha creado correctamente",
                        Toast.LENGTH_SHORT).show()
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    //Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    //updateUI(null)
                }
            }
    }
}