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
        BtnMoveWithData.setOnCLickListener(this)
    }

    override fun onClick(p0: View?){
        when(p0?.id){
            R.id.BtnMoveAct -> {
                val moveIntent = Intent(this@MainActivity,MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.BtnMvData -> {
                val moveWithData = Intent
            }
        }
    }
}