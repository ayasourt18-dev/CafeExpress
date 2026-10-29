package com.example.cafeexpress

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var b1: Button
    private lateinit var b2: Button
    private lateinit var b3: Button
    private lateinit var b4: Button
    private lateinit var b5: Button
    private lateinit var b6: Button
    private lateinit var b7: Button
    private lateinit var b8: Button

    private lateinit var n1: TextView
    private lateinit var n2: TextView
    private lateinit var n3: TextView

    private lateinit var e1: EditText
    private lateinit var t1: TextView
    private var q1 = 0
    private var q2 = 0
    private var q3 = 0
     private fun calculerTotal() {
        val total = q1 * 10 + q2 * 8 + q3 * 6
        t1.text = "Total : $total DH"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        b1 = findViewById(R.id.btnMoinsCafe)
        b2 = findViewById(R.id.btnMoinsThe)
        b3 = findViewById(R.id.btnMoinsCroissant)

        b4 = findViewById(R.id.btnPlusCafe)
        b5 = findViewById(R.id.btnPlusThe)
        b6 = findViewById(R.id.btnPlusCroissant)

        n1 = findViewById(R.id.txtQteCafe)
        n2 = findViewById(R.id.txtQteThe)
        n3 = findViewById(R.id.txtQteCroissant)

        e1 = findViewById(R.id.edtClient)
        t1 = findViewById(R.id.txtTotal)

        b7 = findViewById(R.id.btnVider)
        b8 = findViewById(R.id.btnCommander)
        b4.setOnClickListener {
            q1++
            n1.text = q1.toString()
        }
        b1.setOnClickListener {
            if (q1 > 0) {
                q1--
                n1.text = q1.toString()
            }
            calculerTotal()
        }
        b5.setOnClickListener {
            q2++
            n2.text = q2.toString()
            calculerTotal()
        }

        b2.setOnClickListener {
            if (q2 > 0) {
                q2--
                n2.text = q2.toString()
                calculerTotal()
            }
        }
        b6.setOnClickListener {
            q3++
            n3.text = q3.toString()
            calculerTotal()
        }

        b3.setOnClickListener {
            if (q3 > 0) {
                q3--
                n3.text = q3.toString()
            }
            calculerTotal()
        }
        b8.setOnClickListener {

            val nom = e1.text.toString().trim()
            val articles = q1 + q2 + q3
            val total = q1 * 10 + q2 * 8 + q3 * 6

            if (nom.isEmpty()) {
                e1.error = "Le nom est obligatoire"
                e1.requestFocus()

            } else if (articles == 0) {
                Toast.makeText(
                    this,
                    "Le panier est vide",
                    Toast.LENGTH_SHORT
                ).show()

            } else {
                Toast.makeText(
                    this,
                    "Merci $nom : $articles articles, $total DH",
                    Toast.LENGTH_LONG
                ).show()
            }
            b7.setOnClickListener {

                q1 = 0
                q2 = 0
                q3 = 0

                n1.text = "0"
                n2.text = "0"
                n3.text = "0"

                e1.text.clear()
                e1.error = null

                calculerTotal()

                Toast.makeText(
                    this,
                    "Commande annulée",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }
}
