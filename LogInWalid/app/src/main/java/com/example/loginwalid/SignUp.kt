package com.example.loginwalid

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginwalid.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth


class SignUp : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.button2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.button.setOnClickListener {
            val email = binding.email.text.toString()
            val pass = binding.pass.text.toString()
            val confirm = binding.confirm.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && confirm.isNotEmpty()) {
                if (pass == confirm) {
                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)

                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else
                    Toast.makeText(this, "Passwords do not Match", Toast.LENGTH_SHORT).show()
            } else
                Toast.makeText(this, "Please Fill all fields", Toast.LENGTH_SHORT).show()

        }


    }
}