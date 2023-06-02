package com.example.examencorte1kotlin

import androidx.appcompat.app.AppCompatActivity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtener una referencia al botón
        val btnEntrar: Button = findViewById(R.id.btnEntrar)
        val btnSalir: Button = findViewById(R.id.btnSalir)

        btnEntrar.setOnClickListener {
            // Obtener una referencia al EditText
            val inputUsuario: EditText = findViewById(R.id.inputUsuario)

            val nombreUsuario = inputUsuario.text.toString().trim() // Utiliza trim() para eliminar espacios en blanco al inicio y al final del texto

            if (nombreUsuario.isEmpty()) {
                Toast.makeText(applicationContext, "Ingrese un nombre de usuario", Toast.LENGTH_SHORT).show()
            } else {
                val bundle = Bundle()
                bundle.putString("nombreUsuario", nombreUsuario)

                Toast.makeText(applicationContext, "Bienvenido", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@MainActivity, RectanguloActivity::class.java)
                intent.putExtras(bundle) // Agrega el Bundle al Intent
                startActivity(intent)
            }
        }

        btnSalir.setOnClickListener {
            val builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle("Confirmación")
            builder.setMessage("¿Estás seguro de querer salir?")
            builder.setPositiveButton("Sí") { dialog, which ->
                // Acciones a realizar si se selecciona "Sí"
                finishAffinity() // Cierra todas las actividades y sale de la aplicación
            }
            builder.setNegativeButton("No") { dialog, which ->
                // Acciones a realizar si se selecciona "No"
                dialog.dismiss() // Cierra el diálogo sin realizar ninguna acción adicional
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }
}