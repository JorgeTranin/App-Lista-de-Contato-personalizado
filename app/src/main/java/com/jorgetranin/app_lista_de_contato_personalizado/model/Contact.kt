package com.jorgetranin.app_lista_de_contato_personalizado.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contact(
    val name: String,
    val telefone: String,
    val image: String
): Parcelable
