package com.example.lesson5

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val informations:ArrayList<Informations> = ArrayList()
    val setup = SetUpInformations(informations , this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        informations.add(Informations("Lao Hac","60" , "123"))
        informations.add(Informations("Cau Vang","3" , "132"))
        informations.add(Informations("Ong Giao","30" , "145"))
        informations.add(Informations("John Wick","35" , "999"))
        informations.add(Informations("Hachiko","3" , "892"))

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = SetUpInformations(informations,this)

        val add : Button = buttonAdd
        add.setOnClickListener{
            startActivityForResult(Intent (this , Main2Activity::class.java) , 1999)
        }

        val sort : Button = buttonSort
        sort.setOnClickListener{
            Log.i("aaa","hu")
            var sortList = informations.sortedWith(compareBy ({ it.name }))
            var newList : ArrayList<Informations> = ArrayList<Informations>()
            for (index in sortList) {
                newList.add(index)
            }
            Log.i("aaa","endfor")
            setup.sortData(newList)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if(resultCode == Activity.RESULT_OK){
                val newGuy: ArrayList<Informations> = ArrayList()
                val nameString: String = intent?.getStringExtra("name").toString()
                val ageString: String = intent?.getStringExtra("age").toString()
                val phoneString: String = intent?.getStringExtra("phone").toString()
                newGuy.add(Informations(nameString,ageString,phoneString))
                setup.add(newGuy)
                recyclerView.smoothScrollToPosition(setup.itemCount-1)
        }
    }
}