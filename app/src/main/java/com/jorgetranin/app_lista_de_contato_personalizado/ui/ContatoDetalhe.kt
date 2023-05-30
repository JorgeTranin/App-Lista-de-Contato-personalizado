package com.jorgetranin.app_lista_de_contato_personalizado.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.jorgetranin.app_lista_de_contato_personalizado.R
import com.jorgetranin.app_lista_de_contato_personalizado.databinding.ActivityContatoDetalheBinding
import com.jorgetranin.app_lista_de_contato_personalizado.model.Contact

class ContatoDetalhe : AppCompatActivity() {
    private var contact: Contact ? = null
    private lateinit var binding: ActivityContatoDetalheBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContatoDetalheBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)



        getContactExtras()
        bindViews()


    }

    fun getContactExtras(){
        contact = intent.getParcelableExtra(INDEX_CONTACT)

    }
    fun bindViews(){
        binding.tvName.text = contact?.name
        binding.tvTelefone.text = contact?.telefone

        Glide.with(binding.ivOwner)
            .load(contact?.image)
            .centerCrop()
            .placeholder(R.drawable.loading_spinner)
            .into(binding.ivOwner)
    }
    companion object{
        const val INDEX_CONTACT: String = "INDEX_CONTACT"
    }
}