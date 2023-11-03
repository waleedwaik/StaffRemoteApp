package com.example.loginwalid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class adminActivity : AppCompatActivity() {

    private lateinit var add: Button
    private lateinit var view: Button
    private lateinit var remove: Button
    private lateinit var logout: Button
    private lateinit var searchBut: Button
    private lateinit var addimage: ImageView
    private lateinit var viewimage: ImageView
    private lateinit var removeimage: ImageView
    private lateinit var logoutimage: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        add = findViewById(R.id.add)
        searchBut = findViewById(R.id.searchBut)
        view = findViewById(R.id.view)
        remove = findViewById(R.id.remove)
        logout = findViewById(R.id.logout)
        addimage = findViewById(R.id.addimage)
        viewimage = findViewById(R.id.viewimage)
        removeimage = findViewById(R.id.removeimage)
        logoutimage = findViewById(R.id.logoutimage)

        add.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }

        view.setOnClickListener {
            val intent = Intent(this, ViewStaffActivity::class.java)
            startActivity(intent)
        }

        searchBut.setOnClickListener {
            val intent = Intent(this, UserSearchActivity::class.java)
            startActivity(intent)
        }

        remove.setOnClickListener {
            val intent = Intent(this, RemoveActivity::class.java)
            startActivity(intent)
        }

        logout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        addimage.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }

        viewimage.setOnClickListener {
            val intent = Intent(this, ViewStaffActivity::class.java)
            startActivity(intent)
        }

        removeimage.setOnClickListener {
            val intent = Intent(this, RemoveActivity::class.java)
            startActivity(intent)
        }

        logoutimage.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}