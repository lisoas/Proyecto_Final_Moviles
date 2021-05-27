package com.example.proyectofinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class Examen1 : Fragment(R.layout.activity_examen1) {
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.activity_examen1, container, false)

        val bt = v.findViewById<ImageButton>(R.id.volverExamen1)

        bt.setOnClickListener{
            val comoSeUtilizaMeetParaHacerUnaVideollamada = comoSeUtilizaMeetParaHacerUnaVideollamada()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.container, comoSeUtilizaMeetParaHacerUnaVideollamada)
            transaction.commit()
        }

        return v
    }
}