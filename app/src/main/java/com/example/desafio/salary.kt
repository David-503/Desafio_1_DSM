package com.example.desafio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class salary : AppCompatActivity() {
    private lateinit var txtNombre: EditText
    private lateinit var inputSalary: EditText
    private lateinit var btnCalcular:Button
    private lateinit var txtResultado :TextView
    private  fun calcularSalario(){
        var salary:Double = inputSalary.text.toString().toDouble();
        var result:Double = salary - ( 0.03*salary + 0.04*salary + 0.05*salary )
        txtResultado.text= "El salario de, " + txtNombre.text + " es de: " + result;
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salary)
        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener {  calcularSalario()}
        txtNombre = findViewById(R.id.txtNombre);
        txtResultado = findViewById(R.id.txtResultado);
        inputSalary = findViewById(R.id.txtSalary);
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.omenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.home) {
            Toast.makeText(this, "Opcion main", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        if (id == R.id.average) {
            Toast.makeText(this, "Opcion average", Toast.LENGTH_LONG).show()
            val intent = Intent(this, average::class.java)
            startActivity(intent)
        }
        if (id == R.id.calculator) {
            Toast.makeText(this, "Opcion calculator", Toast.LENGTH_LONG).show()
            val intent = Intent(this, calculator::class.java)
            startActivity(intent)
        }
        if (id == R.id.salary) {
            Toast.makeText(this, "Opcion salary", Toast.LENGTH_LONG).show()
            val intent = Intent(this, salary::class.java)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }
}