package com.example.loginwalid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (private val staffList : ArrayList<Staff>): RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,
            parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val staff : Staff = staffList[position]
        holder.firstname.text = staff.FirstName
        holder.lastname.text = staff.LastName
        holder.email.text = staff.email
        holder.number.text = staff.number.toString()
        holder.idnum.text = staff.ID



    }

    override fun getItemCount(): Int {
        return staffList.size
    }

    public class MyViewHolder(ItemView : View) : RecyclerView.ViewHolder(ItemView){

        val firstname : TextView =itemView.findViewById(R.id.FirstName)
        val lastname : TextView =itemView.findViewById(R.id.LastName)
        val email : TextView =itemView.findViewById(R.id.email)
        val number : TextView =itemView.findViewById(R.id.number)
        val idnum : TextView =itemView.findViewById(R.id.idnum)

    }
}