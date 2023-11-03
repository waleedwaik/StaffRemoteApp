package com.example.loginwalid


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginwalid.databinding.ActivityRemoveBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RemoveActivity : AppCompatActivity() {

    private lateinit var firstnamedel: EditText
    private lateinit var lastnamedel: EditText
    private lateinit var iddel: EditText
    private lateinit var numberdel: EditText
    private lateinit var deletebtn1: Button
    private lateinit var back: Button
    private var db = Firebase.firestore
    private lateinit var userId: String
    private lateinit var binding: ActivityRemoveBinding

    @SuppressLint("MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityRemoveBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.deletebtn1.setOnClickListener{

            if(binding.iddel.text.isNotEmpty())
            {
                val query =db.collection("user")
                    .whereEqualTo("ID",binding.iddel.text.toString())
                    .get()
                query.addOnSuccessListener {
                    for (document in it){
                        db.collection("user").document(document.id).delete().addOnSuccessListener {
                            Toast.makeText(this, "Staff Member Deleted Successfully", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
            else {
                Toast.makeText(this, "Please Insert ID to Delete", Toast.LENGTH_SHORT).show()
            }
        }

        binding.back.setOnClickListener {
            val intent = Intent(this, adminActivity::class.java)
            startActivity(intent)
        }

        }

}