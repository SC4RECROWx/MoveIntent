package com.dicoding.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvresult: TextView
    private val resultLaucher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
            tvresult.text = "Hasil $selectedValue"
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val BtnMoveActivities: Button = findViewById(R.id.BtnMoveAct)
        BtnMoveActivities.setOnClickListener(this)

        val BtnMoveWithData: Button = findViewById(R.id.BtnMvData)
        BtnMoveWithData.setOnClickListener(this)

        val BtnMoveWithObj: Button = findViewById(R.id.BtnMoveObj)
        BtnMoveWithObj.setOnClickListener(this)

        val BtnDialWithNumber: Button = findViewById(R.id.BtnDialNumber)
        BtnDialWithNumber.setOnClickListener(this)

        val BtnMoveResult:Button = findViewById(R.id.BtnMoveForResult)
        BtnMoveResult.setOnClickListener(this)
        tvresult = findViewById(R.id.tvResult)
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
            R.id.BtnDialNumber -> {
                val phoneNumber = "081341151741"
                val dialPhoneNumber = Intent(Intent.ACTION_DIAL,Uri.parse("tel: $phoneNumber"))
                startActivity(dialPhoneNumber)
            }
            R.id.BtnMoveForResult -> {
                val moveForResultIntent = Intent(this@MainActivity, MoveForResultActivity::class.java)
                resultLaucher.launch(moveForResultIntent)
            }
        }
    }
}