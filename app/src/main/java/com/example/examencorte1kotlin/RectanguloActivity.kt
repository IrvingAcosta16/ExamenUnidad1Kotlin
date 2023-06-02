package com.example.examencorte1kotlin

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RectanguloActivity : AppCompatActivity() {

    private lateinit var lblArea: TextView
    private lateinit var lblPerimetro: TextView
    private lateinit var editTextBase: EditText
    private lateinit var editTextAltura: EditText
    private lateinit var btnCalcular: Button
    private lateinit var btnLimpiar: Button
    private lateinit var btnRegresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activityrectangulo)

        lblArea = findViewById(R.id.lblArea)
        lblPerimetro = findViewById(R.id.lblPerimetro)
        editTextBase = findViewById(R.id.editTextBase)
        editTextAltura = findViewById(R.id.editTextAltura)
        btnCalcular = findViewById(R.id.btnCalcular)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnRegresar = findViewById(R.id.btnRegresar)

        //MOSTRAR EL NOMBRE
        val textViewNombreUsuario: TextView = findViewById(R.id.putNombredeUsuario)
        val extras = intent.extras
        if (extras != null && extras.containsKey("nombreUsuario")) {
            val nombreUsuario = extras.getString("nombreUsuario")
            textViewNombreUsuario.text = nombreUsuario
        }

        btnCalcular.setOnClickListener {
            if (validarInputs()) {
                val base = editTextBase.text.toString().toDouble()
                val altura = editTextAltura.text.toString().toDouble()

                val area = base * altura
                val perimetro = 2 * (base + altura)

                lblArea.text = area.toString()
                lblPerimetro.text = perimetro.toString()
            }
        }

        btnLimpiar.setOnClickListener {
            editTextBase.setText("")
            editTextAltura.setText("")
            lblArea.text = ""
            lblPerimetro.text = ""
        }

        btnRegresar.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Confirmación")
            builder.setMessage("¿Estás seguro de querer regresar?")
            builder.setPositiveButton("Sí") { dialog, _ ->
                // Acciones a realizar si se selecciona "Sí"
                val intent = Intent(this@RectanguloActivity, MainActivity::class.java)
                startActivity(intent)
                finish() // Finaliza la actividad actual (RectanguloActivity)
                dialog.dismiss()
            }
            builder.setNegativeButton("No") { dialog, _ ->
                // Acciones a realizar si se selecciona "No"
                dialog.dismiss() // Cierra el diálogo sin realizar ninguna acción adicional
            }
            val dialog = builder.create()
            dialog.show()
        }
    }

    private fun validarInputs(): Boolean {
        val baseText = editTextBase.text.toString().trim()
        val alturaText = editTextAltura.text.toString().trim()

        return if (baseText.isNotEmpty() && alturaText.isNotEmpty()) {
            // Ambos campos están llenos
            true
        } else {
            Toast.makeText(applicationContext, "Ambos campos son requeridos", Toast.LENGTH_SHORT).show()
            false
        }
    }
}