package com.smart.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner:Spinner = findViewById(R.id.spinner)
        val titleEditBox:EditText = findViewById(R.id.titleedittext)
        val textEdit:EditText = findViewById(R.id.textedittext)
        val buildButton:Button = findViewById(R.id.buildbutton)

        val array = arrayOf("android","comment","chat")

        spinner.adapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,array)




        buildButton.setOnClickListener {

            val intent= Intent(this,SecondActivity::class.java)
            intent.putExtra("spinner", array[spinner.selectedItemPosition])
            intent.putExtra("title", titleEditBox.text.toString())
            intent.putExtra("text",textEdit.text.toString())
            startActivity(intent)

        }

    }
}

