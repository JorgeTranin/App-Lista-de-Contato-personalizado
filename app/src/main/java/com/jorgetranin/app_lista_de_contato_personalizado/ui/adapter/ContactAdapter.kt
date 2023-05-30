package com.jorgetranin.app_lista_de_contato_personalizado.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jorgetranin.app_lista_de_contato_personalizado.R
import com.jorgetranin.app_lista_de_contato_personalizado.databinding.ItemContatoBinding
import com.jorgetranin.app_lista_de_contato_personalizado.model.Contact

class ContactAdapter(
    private val list: MutableList<Contact>,
    private val onItemClick: (Contact) -> Unit
) : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemContatoBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(val binding: ItemContatoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: Contact) {
            binding.tvName.text = contact.name
            binding.tvTelefone.text = contact.telefone

            Glide.with(binding.ivOwner)
                .load(contact.image)
                .centerCrop()
                .placeholder(R.drawable.loading_spinner)
                .into(binding.ivOwner)

            binding.root.setOnClickListener {
                onItemClick.invoke(contact)
            }
        }
    }
}
