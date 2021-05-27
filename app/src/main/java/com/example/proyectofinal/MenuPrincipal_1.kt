package com.example.proyectofinal

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.internal.ContextUtils.getActivity
import kotlinx.android.synthetic.main.activity_menu_principal_1.*
import kotlinx.android.synthetic.main.fragment_ajustes.*

class MenuPrincipal_1 : AppCompatActivity() {

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal_1)

        setCurrentFragment(principalFragment())

        var principalfrag = principalFragment()
        var ajusfrag = ajustesFragment()
        var preguntasFrefrag = preguntasFrecuentesFragment()

        bottomNavigationView.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.nav_principal -> {
                    setCurrentFragment(principalfrag)
                    true
                }
                R.id.nav_preguntasFrecuentes -> {
                    setCurrentFragment(preguntasFrefrag)
                    true
                }
                R.id.nav_ajustes -> {
                    setCurrentFragment(ajusfrag)
                    true

                }
                else -> false
            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
                replace(R.id.containerView, fragment)
                commit()
        }

    }

}