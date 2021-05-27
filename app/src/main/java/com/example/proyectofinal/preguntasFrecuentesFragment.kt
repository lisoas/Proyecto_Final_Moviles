package com.example.proyectofinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.FragmentTransaction

class preguntasFrecuentesFragment : Fragment(R.layout.fragment_preguntas_frecuentes) {

    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.fragment_preguntas_frecuentes, container, false)


        val bt2 = v.findViewById<ImageButton>(R.id.pfComoempiezoutilizarMeet)
        val bt3 = v.findViewById<ImageButton>(R.id.pfComoutilizarMeetparahacerllamadas)

        bt2.setOnClickListener{
            val comoEmpiezoUtilizarMeet = comoEmpiezoUtilizarMeet()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.container, comoEmpiezoUtilizarMeet)
            transaction.commit()
        }

        bt3.setOnClickListener{
            val comoSeutilizaMeetParaHacerUnavideollamada = comoSeUtilizaMeetParaHacerUnaVideollamada()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.container, comoSeutilizaMeetParaHacerUnavideollamada)
            transaction.commit()
        }

        return v
    }

}