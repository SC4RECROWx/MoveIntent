package com.dicoding.myintentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val BtnMoveActivities: Button = findViewById(R.id.BtnMoveAct)
        BtnMoveActivities.setOnClickListener(this)

        val BtnMoveWithData: Button = findViewById(R.id.BtnMvData)
        BtnMoveWithData.setOnClickListener(this)

        val BtnMoveWithObj: Button = findViewById(R.id.BtnMoveObj)
        BtnMoveWithObj.setOnClickListener(this)
    }

    override fun onClick(p0: View?){
        when(p0?.id){
            R.id.BtnMoveAct -> {
                val moveIntent = Intent(this@MainActivity,MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.BtnMvData -> {
                val moveWithData = Intent(this@MainActivity,MoveActivityData::class.java)
                moveWithData.putExtra(MoveActivityData.EXTRA_NAME,"Nur Muhammad Akbar")
                moveWithData.putExtra(MoveActivityData.EXTRA_AGE,5)
                startActivity(moveWithData)
            }
            R.id.BtnMoveObj -> {
                val person = Person(
                    "Nur Muhammad Akbar",
                    22,
                    "jieakbar903@gmail.com",
                    "South Sulawesi, Makassar"
                )
                val moveWithObjIntent = Intent(this@MainActivity,MoveWithObj::class.java)
                moveWithObjIntent.putExtra(MoveWithObj.EXTRA_PERSON,person)
                startActivity(moveWithObjIntent)
            }
        }
    }
}