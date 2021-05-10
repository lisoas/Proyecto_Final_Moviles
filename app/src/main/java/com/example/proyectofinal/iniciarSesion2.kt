package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class iniciarSesion2 : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar_sesion2)

        auth = Firebase.auth

       /* val button: Button = findViewById(R.id.iniciar) as Button*/
        val btn_ingresar: Button = findViewById(R.id.iniciar)

        /*button.setOnClickListener{
            var intent: Intent =Intent(this, MenuPrincipal_1::class.java)
            startActivity(intent)
        }*/

        btn_ingresar.setOnClickListener{
            valida_ingreso()
        }

    }

    private fun valida_ingreso(){
        val et_correo: EditText = findViewById(R.id.campoNombre)
        val et_contra: EditText = findViewById(R.id.campoContrasenia)

        var correo: String = et_correo.text.toString()
        var contra: String = et_contra.text.toString()

        if(!correo.isNullOrBlank() && !contra.isNullOrBlank()){
            ingresarFirebase(correo, contra)
        }else{
            Toast.makeText(this, "Ingresar datos",
                Toast.LENGTH_SHORT).show()
        }

    }

    private fun ingresarFirebase(correo: String, contra: String){
        auth.signInWithEmailAndPassword(correo, contra)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information

                    val user = auth.currentUser
                    val intent:  Intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

                } else {
                    // If sign in fails, display a message to the user.

                    Toast.makeText(baseContext, "Error de autenticación.",
                        Toast.LENGTH_SHORT).show()

                }
            }
    }

}