package com.example.proyectofinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class preguntasSobreLaAplicacion : Fragment(R.layout.activity_preguntas_sobre_la_aplicacion) {

    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.activity_preguntas_sobre_la_aplicacion, container, false)

        val bt = v.findViewById<ImageButton>(R.id.volver)


        bt.setOnClickListener{
            val ajustesFragment = ajustesFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.container, ajustesFragment)
            transaction.commit()
        }

        return v
    }
}