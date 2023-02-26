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

class calculator : AppCompatActivity() {
    lateinit var inputText: EditText
    lateinit var txtMessage:TextView;
    var firstNumber:Double=0.0;
    var secondNumber:Double=0.0;
    var result:Double=0.0;
    var operator:Char='+';
    var isSecond=false;
    private fun getButtons(): Map<Char, Button> {
        val ids = mapOf('+' to R.id.btnPlus, '-' to R.id.btnMinus, '*' to R.id.btnMultiplicate, '/' to R.id.btnDivide);
        return ids.mapValues { findViewById(it.value) }
    }
    private fun setNumberAndOperator(c:Char){
        firstNumber = inputText.text.toString().toDouble();
       if(firstNumber==0.0){
           Toast.makeText(this,"Ingrese su primer numero",Toast.LENGTH_SHORT).show();
           return
       }else if(isSecond){
           Toast.makeText(this,"No se puede operar dos veces",Toast.LENGTH_SHORT).show();
           return
       }
        txtMessage.text = "Ingrese su segundo numero";
        firstNumber = inputText.text.toString().toDouble();
        operator=c;
        isSecond=true;
        inputText.text=null;
    }
    private  fun operateNumber():Double{
        println("Operator--->"+operator);
        println("firstNumber--->"+firstNumber);
        println("secondNumber--->"+secondNumber);

       return when(operator){
            '+' -> (firstNumber + secondNumber);
            '/' -> (firstNumber / secondNumber);
            '*' -> (firstNumber * secondNumber);
            '-' -> (firstNumber - secondNumber);
            else -> 0.0;
        }
    }
    private  fun cleanAll(){
        firstNumber=0.0;
        secondNumber=0.0;
        result=0.0;
        txtMessage.text = "Ingrese su primer numero";
        inputText.text=null;
        isSecond=false;

    }
    private fun showResult(){
        secondNumber = inputText.text.toString().toDouble();
        inputText.text=null;

        result = operateNumber();
        txtMessage.text = "Resultado: " + result.toString();

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        val buttons: Map<Char, Button> = getButtons();
        val btnAc = findViewById<Button>(R.id.btnAC);
        val btnEquals = findViewById<Button>(R.id.btnEquals);
        inputText=findViewById<EditText>(R.id.txtNumber);
        txtMessage= findViewById<TextView>(R.id.txtMessage);
        buttons.forEach { (c, button) -> button.setOnClickListener { setNumberAndOperator(c) } }
        btnAc.setOnClickListener {cleanAll()}
        btnEquals.setOnClickListener {showResult()}

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