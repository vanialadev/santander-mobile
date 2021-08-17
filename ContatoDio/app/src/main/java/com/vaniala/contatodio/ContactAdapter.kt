package com.vaniala.contatodio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(private val contactsList: ArrayList<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(contactsList[position])
    }

    override fun getItemCount(): Int = contactsList.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindItem(contact: Contact) {

            val textName = itemView.findViewById<TextView>(R.id.contact_name)
            val textTelephone = itemView.findViewById<TextView>(R.id.contact_telephone)

            textName.text = contact.name
            textTelephone.text = contact.phoneNumber
        }

    }

}