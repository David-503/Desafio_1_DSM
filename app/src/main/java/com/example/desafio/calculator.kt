package com.example.desafio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class calculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
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