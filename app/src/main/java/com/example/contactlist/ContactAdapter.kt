package com.example.contactlist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(var listener: ClickItemContactListener) :
    RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {

    private val list: MutableList<Contact> = mutableListOf()

    // Cria cada item visual na tela (neste caso ele cria um card para cada item)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactAdapterViewHolder(view, list, listener)
    }

    // Quantidade de items nesta lista
    override fun getItemCount(): Int {
        return list.size
    }

    // Resposavel por popular os items na lista
    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        holder.bing(list[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun upDateList(list: List<Contact>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class ContactAdapterViewHolder(itemView: View, var list: List<Contact>, var listener: ClickItemContactListener) : RecyclerView.ViewHolder(itemView) {
        private val tvName: TextView = itemView.findViewById(R.id.tv_name)
        private val tvPhone: TextView = itemView.findViewById(R.id.tv_phone)
       // private  val ivPhotograghy: TextView = itemView.findViewById(R.id.iv_photograghy)


        init {
            itemView.setOnClickListener {
                listener.clickItemContact(list[adapterPosition])
            }
        }

        fun bing(contact: Contact) {
            tvName.text = contact.name
            tvPhone.text = contact.phone
        }
    }

}
