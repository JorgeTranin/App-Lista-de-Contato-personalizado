package com.jorgetranin.app_lista_de_contato_personalizado.ui

import com.jorgetranin.app_lista_de_contato_personalizado.model.Contact

interface OnItemClickListener {
    fun onItemClick(contact: Contact)
}