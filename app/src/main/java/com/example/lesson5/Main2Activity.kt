package com.example.lesson5

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val intent : Intent = Intent (this , MainActivity::class.java)
        val bundle : Bundle = Bundle()
        val add : Button = findViewById(R.id.addNew)

        add.setOnClickListener {
            bundle.putString("name" , editTextName.text.toString())
            bundle.putString("age" , editTextAge.text.toString())
            bundle.putString("phone" , editTextPhone.text.toString())

            intent.putExtras(bundle)
            setResult(Activity.RESULT_OK , intent)
            finish()
        }
    }
}
