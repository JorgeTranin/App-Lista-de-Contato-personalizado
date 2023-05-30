package com.jorgetranin.app_lista_de_contato_personalizado.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar
import com.jorgetranin.app_lista_de_contato_personalizado.R
import com.jorgetranin.app_lista_de_contato_personalizado.databinding.ActivityMainBinding
import com.jorgetranin.app_lista_de_contato_personalizado.model.Contact
import com.jorgetranin.app_lista_de_contato_personalizado.ui.adapter.ContactAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var appBarLayout: AppBarLayout
    private lateinit var adapter: ContactAdapter
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        // Configuração da barra de aplicativo
        val toolbar: MaterialToolbar = findViewById(R.id.topAppBar)
        setSupportActionBar(toolbar)

        appBarLayout = findViewById(R.id.menu)
        setupListContato()

    }

    fun mockListFake() {

    }

    fun setupListContato() {
        var list: MutableList<Contact> = mutableListOf()
        list = arrayListOf(
            Contact(
                name = "jorge",
                telefone = "123321",
                image = ""
            ),
            Contact(
                name = "Messias",
                telefone = "981329831",
                image = ""
            ),
            Contact(
                name = "Pedro",
                telefone = "124u2897482",
                image = ""
            ),
            Contact(
                name = "Pedro",
                telefone = "124u2897482",
                image = ""
            ),
            Contact(
                name = "Pedro",
                telefone = "124u2897482",
                image = ""
            ),
            Contact(
                name = "Pedro",
                telefone = "124u2897482",
                image = ""
            ),
            Contact(
                name = "Pedro",
                telefone = "124u2897482",
                image = ""
            ),
            Contact(
                name = "Pedro",
                telefone = "124u2897482",
                image = ""
            )
        )
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ContactAdapter(list)
        binding.recyclerView.adapter = adapter
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //identifica qual item foi clicado
        return when(item.itemId){
            R.id.item_menu_1 ->{
                toast("Item 1")
                true
            }
            R.id.item_menu_2 ->{
                toast("Item 2")
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun toast(msg: String){
        Toast.makeText(this@MainActivity,  msg, Toast.LENGTH_LONG).show()
    }
}