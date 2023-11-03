package com.example.loginwalid

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await




class UserSearchActivity : AppCompatActivity() {

    private val database = Firebase.firestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_search)


        val searchET = findViewById<EditText>(R.id.searchET)
        val searchBT = findViewById<Button>(R.id.searchBT)
        val first = findViewById<TextView>(R.id.first)
        val last = findViewById<TextView>(R.id.last)
        val email2 = findViewById<TextView>(R.id.email2)
        val num2 = findViewById<TextView>(R.id.num2)
        val id2 = findViewById<TextView>(R.id.id2)

        searchBT.setOnClickListener {
            val search2 = searchET.text.toString()
            searchName(search2, first, last, email2, num2, id2)
        }

    }

    private fun searchName(
        search2: String,
        first: TextView,
        last: TextView,
        email2: TextView,
        num2: TextView,
        id2: TextView
    ) {
        val collectionRef = database.collection("user")
        val query = collectionRef.whereEqualTo("firstName", search2)

        GlobalScope.launch(Dispatchers.IO) {
            val snapshot = query.get().await()
            try {
                if (!snapshot.isEmpty) {
                    val document = snapshot.documents[0]
                    val firstname = document.getString("FirstName")
                    val lastname = document.getString("LastName")
                    val emailAdd = document.getString("email")
                    val number2 = document.getString("number")
                    val idd = document.getString("ID")

                    runOnUiThread {
                        first.text = firstname
                        last.text = lastname
                        email2.text = emailAdd
                        num2.text = number2
                        id2.text = idd
                    }
                } else {
                    runOnUiThread {
                    }
                    }
                }catch(e: Exception) {
                e.printStackTrace()
            }
            }
        }
    }
