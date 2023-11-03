package com.example.loginwalid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot


class ViewStaffActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var staffArrayList: ArrayList<Staff>
    private lateinit var myAdapter: MyAdapter
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_staff)

        recyclerView = findViewById(R.id.rView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        staffArrayList = arrayListOf()
        myAdapter = MyAdapter(staffArrayList)
        recyclerView.adapter = myAdapter

        EventChangeListener()

    }


    private fun EventChangeListener() {
        db = FirebaseFirestore.getInstance()

            db.collection("user")
                .addSnapshotListener(object : EventListener<QuerySnapshot>
            {
                override fun onEvent(
                    value: QuerySnapshot?,
                    error: FirebaseFirestoreException?
                ) {
                    if (error != null) {

                        Log.e("Firestore Error", error.message.toString())
                        return

                    }
                    for (dc: DocumentChange in value?.documentChanges!!) {

                        if (dc.type == DocumentChange.Type.ADDED) {
                            staffArrayList.add(dc.document.toObject(Staff::class.java))
                        }
                    }
                    myAdapter.notifyDataSetChanged()
                }


            })
    }

}


