package com.vaniala.navegacaoaparenciaestilo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(var listener: ClickItemContactListener) :
    RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {


    private val list: MutableList<Contact> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactAdapterViewHolder(view, list, listener)
    }

    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun updateList(list: List<Contact>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }


    class ContactAdapterViewHolder(
        itemview: View,
        list: List<Contact>,
        listener: ClickItemContactListener
    ) : RecyclerView.ViewHolder(itemview) {

        private val txtName: TextView = itemview.findViewById(R.id.tv_name)
        private val txtPhone: TextView = itemview.findViewById(R.id.tv_phone)
        private val txtImg: ImageView = itemview.findViewById(R.id.iv_photograph)

        init {
            itemview.setOnClickListener {
                listener.clickItemContact(list[adapterPosition])
            }
        }

        fun bind(contact: Contact) {

            txtName.text = contact.name
            txtPhone.text = contact.phone
        }
    }

}