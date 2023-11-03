package com.example.loginwalid

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginwalid.databinding.ActivityAddBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Suppress("NAME_SHADOWING")
class AddActivity : AppCompatActivity() {

    private lateinit var firstname: EditText
    private lateinit var lastname: EditText
    private lateinit var email: EditText
    private lateinit var number: EditText
    private lateinit var idnum: EditText
    private lateinit var submit: Button
    private lateinit var back: Button

    private lateinit var Firestore: FirebaseFirestore
    private var db = Firebase.firestore
    private lateinit var binding: ActivityAddBinding
    private lateinit var database: DatabaseReference
    private lateinit var staffArrayList: ArrayList<Staff>
    private lateinit var myAdapter: MyAdapter


//start

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
//vars
        firstname = findViewById(R.id.firstname)
        lastname = findViewById(R.id.lastname)
        email = findViewById(R.id.email)
        number = findViewById(R.id.number)
        submit = findViewById(R.id.submit)
        back = findViewById(R.id.back)
        idnum = findViewById(R.id.idnum)
//button
        submit.setOnClickListener {

            val firstname1 = firstname.text.toString().trim()
            val lastname1 = lastname.text.toString().trim()
            val email = email.text.toString().trim()
            val number = number.text.toString().trim()
            val idnum = idnum.text.toString().trim()


            val db = FirebaseFirestore.getInstance()
            val user: MutableMap<String, Any> = HashMap()
            user["FirstName"] = firstname1+"waleed"
            user["LastName"] = lastname1
            user["email"] = email
            user["number"] = number
            user["ID"]= idnum


            db.collection("user")
                .add(user)
                .addOnSuccessListener {
                    Toast.makeText(this, "Successfully Saved", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Failed To Save", Toast.LENGTH_SHORT).show()
                }

        }

// cancel button
        back.setOnClickListener {
            val intent = Intent(this, adminActivity::class.java)
            startActivity(intent)


        }

        }
    }






