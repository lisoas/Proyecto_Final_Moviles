package com.example.proyectofinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.FragmentTransaction


class principalFragment : Fragment(R.layout.fragment_principal) {

    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)



    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.fragment_principal, container, false)

        val bt = v.findViewById<Button>(R.id.comoseutilizameetparahacervideollamadas)
        val bt2 = v.findViewById<Button>(R.id.comograbartusvideoconferencias)
        val bt3 = v.findViewById<Button>(R.id.comoprogramarunavideollamada)


        bt.setOnClickListener {
            val comoSeUtilizarMeetParaHacerUnaVideollamada = comoSeUtilizaMeetParaHacerUnaVideollamada()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.container, comoSeUtilizarMeetParaHacerUnaVideollamada)
            transaction.commit()
        }
        bt2.setOnClickListener {
            val grabarVideoconferencias = grabarVideoconferencias()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.container, grabarVideoconferencias)
            transaction.commit()
        }
        bt3.setOnClickListener {
            val comoprogramarunavideollamada = comoprogramarunaVideollamada()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.container, comoprogramarunavideollamada)
            transaction.commit()
        }

        return v
    }

}