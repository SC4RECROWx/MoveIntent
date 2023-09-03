package com.dicoding.myintentapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.lang.invoke.MethodHandles

class MoveWithObj : AppCompatActivity() {
    companion object{
        const val  EXTRA_PERSON = "extra_person"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_obj)

        val tvObj: TextView = findViewById(R.id.tvMoveObj)

        val person = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Person>(EXTRA_PERSON, Person::class.java)
        }else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Person>(EXTRA_PERSON)
        }

        if (person != null){
            val text = "Name: ${person.name.toString()},\nEmail: ${person.email},\nAge: ${person.age},\nLocation: ${person.city}"
            tvObj.text = text
        }
    }
}