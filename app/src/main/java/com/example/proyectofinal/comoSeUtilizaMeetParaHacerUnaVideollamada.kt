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
import com.google.android.material.internal.NavigationMenu
import com.google.android.material.internal.NavigationMenuItemView

class comoSeUtilizaMeetParaHacerUnaVideollamada : Fragment(R.layout.activity_como_se_utiliza_meet_para_hacer_una_videollamada) {

    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.activity_como_se_utiliza_meet_para_hacer_una_videollamada, container, false)

       val bt = v.findViewById<ImageButton>(R.id.volver)
       /*val bt2 = v.findViewById<NavigationMenuItemView>(R.id.bottomNavigationViewExamen)*/
        val bt3 = v.findViewById<ImageButton>(R.id.IrExamen1)


        bt.setOnClickListener{
            val principalFragment = principalFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.container, principalFragment)
            transaction.commit()
        }

        bt3.setOnClickListener{
            val Examen1 = Examen1()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.containerMeet, Examen1)
            transaction.commit()
        }

      /*  bt2.setOnClickListener{
            val Examen1 = Examen1()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.container, Examen1)
            transaction.commit()
        }*/
        return v
    }



}