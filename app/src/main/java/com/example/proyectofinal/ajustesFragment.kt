package com.example.proyectofinal

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_ajustes.*
import kotlinx.android.synthetic.main.fragment_ajustes.view.*

class ajustesFragment : Fragment(R.layout.fragment_ajustes) {

    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.fragment_ajustes, container, false)

        val bt = v.findViewById<ImageButton>(R.id.btnPerfil)
        val bt2 = v.findViewById<ImageButton>(R.id.btnReportarFallas)
        val bt3 = v.findViewById<ImageButton>(R.id.btnRetro)
        val bt4 = v.findViewById<ImageButton>(R.id.btnPreguntas)

        bt.setOnClickListener{
            val Perfil = Perfil()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.container, Perfil)
            transaction.commit()
        }

        bt2.setOnClickListener{
            val reportarFallas = reportarFallas()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.container, reportarFallas)
            transaction.commit()
        }

        bt3.setOnClickListener{
            val retroalimentacion = retroalimentacion()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.container, retroalimentacion)
            transaction.commit()
        }

        bt4.setOnClickListener{
            val preguntasSobreLaAplicacion = preguntasSobreLaAplicacion()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.container, preguntasSobreLaAplicacion)
            transaction.commit()
        }

        return v
    }
}