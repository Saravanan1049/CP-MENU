package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(),ContextClick {
    lateinit var recyclerView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        var dataList = mutableListOf(
            Recycle("saravanan"),
            Recycle("Neeraj"),
            Recycle("Syed"),
            Recycle("Vinod"),
            Recycle("Lakshmi Narasimhan"),
            Recycle("Ragunath"),
            Recycle("Rafiudeen")
        )
        val adapter = RecycleAdapter(dataList,this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter.notifyDataSetChanged()

        val image = findViewById<ImageButton>(R.id.imgBtn)

    }


    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.contect_menu,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.edit ->{
                editList()
            }
            R.id.share ->{
                shareList()
            }
        }
        return super.onContextItemSelected(item)
    }

    private fun shareList() {


    }

    private fun editList(){


    }


    override fun onClick(view: View) {

        registerForContextMenu(view)
        Toast.makeText(this,"EditList",Toast.LENGTH_LONG).show()
Log.d("onCliclk","ndnfjjfbjf")

    }
    fun showPopup(view:View){
        val popup = PopupMenu(this,view)
        menuInflater.inflate(R.menu.contect_menu,popup.menu)
        popup.show()
    }


}