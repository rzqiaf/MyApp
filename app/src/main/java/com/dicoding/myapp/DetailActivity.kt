package com.dicoding.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val band = intent.getParcelableExtra<Band>(MainActivity.INTENT_PARCELABLE)

        val  photo = findViewById<ImageView>(R.id.img_item_photo)
        val  name = findViewById<TextView>(R.id.tv_item_name)
        val  description = findViewById<TextView>(R.id.tv_item_description)

        photo.setImageResource(band?.photo!!)
        name.text = band.name
        description.text = band.description
    }


}