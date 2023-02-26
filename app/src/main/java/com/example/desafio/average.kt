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

class average : AppCompatActivity() {
    lateinit var txtMessage: TextView;
    var result:Double=0.0;
    private lateinit var inputs: List<EditText>;
    lateinit var txtNombre: TextView;

    private fun getInputs(): List<EditText> {
        val ids = mutableListOf<Int>(R.id.txtNota1, R.id.txtNota2, R.id.txtNota3, R.id.txtNota4, R.id.txtNota5);
        var respond= mutableListOf<EditText>();
        val idsIterator = ids.iterator()
         while (idsIterator.hasNext()) {
             respond.add(findViewById(idsIterator.next()));
        }
      return respond;
    }
    private fun averageResul(){

        for (input in inputs){
            result+=input.text.toString().toDouble();
        }
        result=result/inputs.size;
        if(result>=6){
            txtMessage.text= txtNombre.text.toString() + ", usted ha aprobado con un promedio de: " + result;
        }else{
            txtMessage.text= txtNombre.text.toString() + ", usted ha reprobado con un promedio de: " + result;

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_average)
        inputs = getInputs();
        val btnResult = findViewById<Button>(R.id.btnResult);
        btnResult.setOnClickListener { averageResul() }
        txtNombre= findViewById(R.id.txtName);
        txtMessage=findViewById(R.id.txtViewResultado);
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