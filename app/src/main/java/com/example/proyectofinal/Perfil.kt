package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_iniciar_sesion2.*
import kotlinx.android.synthetic.main.activity_perfil.*
import kotlinx.android.synthetic.main.activity_registrarse.*
import kotlinx.android.synthetic.main.activity_registrarse.campoCorreo
import kotlinx.android.synthetic.main.fragment_ajustes.*

class Perfil : Fragment(R.layout.activity_perfil) {

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)


    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.activity_perfil, container, false)

        val bt = v.findViewById<ImageButton>(R.id.volver)
        val btnGC = v.findViewById<Button>(R.id.buttonGuardarCambios)

        btnGC.setOnClickListener{
            val ajustesFragment = ajustesFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.container, ajustesFragment)
            transaction.commit()
            //actualizar()
        }

            bt.setOnClickListener{
            val ajustesFragment = ajustesFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.container, ajustesFragment)
            transaction.commit()
        }


         return v
    }
/*
    fun actualizar(){
        db.collection("users").document(campoCorreo.text.toString())
            .update(mapOf("nombre" to nombrePerfil.text.toString()))
    }*/

}