package com.example.loginwalid

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Page : AppCompatActivity() {

    private lateinit var view: Button

    private lateinit var logout: Button

    private lateinit var viewimage: ImageView

    private lateinit var logoutimage: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page)

        viewimage = findViewById(R.id.viewimage)
        view = findViewById(R.id.view)
        logout = findViewById(R.id.logout)
        logoutimage = findViewById(R.id.logoutimage)

        var intent = intent

        view.setOnClickListener {
            val intent = Intent(this, ViewStaffActivity::class.java)
            startActivity(intent)
        }

        logout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        viewimage.setOnClickListener {
            val intent = Intent(this, ViewStaffActivity::class.java)
            startActivity(intent)
        }

        logoutimage.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }





    }
}






