package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_registrarse.*
import java.lang.ref.PhantomReference

class registrarse : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()

    private lateinit var auth: FirebaseAuth

    var databaseReference: DatabaseReference? = null
    var database: FirebaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse)
        supportActionBar?.hide()

        auth = Firebase.auth
        database = FirebaseDatabase.getInstance()
        databaseReference =  database?.reference!!.child("profile")

        val btn_ingresar: Button = findViewById(R.id.iniciar2)

        btn_ingresar.setOnClickListener{
            valida_registro()

        }
    }

    private fun valida_registro(){
        val et_correo: EditText = findViewById(R.id.campoCorreo)
        val et_contra1: EditText = findViewById(R.id.campoContrasenia)
        val nombre: EditText = findViewById(R.id.campoNombre)

        var correo: String = et_correo.text.toString()
        var contra1: String = et_contra1.text.toString()
        var nombre1: String = nombre.text.toString()


        if(!correo.isNullOrBlank() && !contra1.isNullOrBlank() && !nombre1.isNullOrBlank() ){
            if(contra1.length >= 6){
                registrarFirebase(correo, contra1, nombre1)
                Toast.makeText(this, "Se ha registrado correctamente",
                    Toast.LENGTH_SHORT).show()
                    db.collection("users").document(correo).set(
                        hashMapOf("nombre" to campoNombre.text.toString(),
                            "correo" to campoCorreo.text.toString())
                    )
                    var intent: Intent = Intent(this, iniciarSesion2::class.java)
                    startActivity(intent)


            }else{
                Toast.makeText(this, "la contraseña debe de tener minimo 6 caracteres",
                    Toast.LENGTH_SHORT).show()
            }


        }else{
            Toast.makeText(this, "Ingresar datos",
                Toast.LENGTH_SHORT).show()
        }
    }

    private fun registrarFirebase(correo:String, contra1:String, nombre1: String){
        auth.createUserWithEmailAndPassword(correo, contra1).addOnCompleteListener(this) { task ->

                if (task.isSuccessful) {
                    val currentUser = auth.currentUser
                    val currentUserDb = databaseReference?.child((currentUser?.uid!!))

                    currentUserDb?.child("nombre")?.setValue(findViewById(R.id.campoNombre))
                    currentUserDb?.child("correo")?.setValue(findViewById(R.id.campoCorreo))
                    currentUserDb?.child("contrasenia")?.setValue(findViewById(R.id.campoContrasenia))

                    Toast.makeText(baseContext, "${currentUser.email} Se ha creado correctamente",
                        Toast.LENGTH_SHORT).show()




                } else {

                    Toast.makeText(baseContext, "Autenticación fallida",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
}