package com.example.mytodoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialization of list
        var items = arrayListOf<String>()
        var arradapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, items)
        android.R.layout.simple_list_item_multiple_choice;items
        val add = findViewById<Button>(R.id.btnAdd)
        val delete = findViewById<Button>(R.id.Delete)
        val editText = findViewById<EditText>(R.id.etTodo)
        val listView = findViewById<ListView>(R.id.listView)

        // Add button
        add.setOnClickListener {
            items.add(editText.text.toString())
            listView.adapter =  arradapter
            arradapter.notifyDataSetChanged()
            editText.text.clear()

            //Delete button
            delete.setOnClickListener {
                val position: SparseBooleanArray = listView.checkedItemPositions
                val count = listView.count
                var item = count - 1
                while (item >= 0) {
                    if (position.get(item))
                    {
                        arradapter.remove(items.get(item))

                    }
                    item--
                }
                position.clear()
                arradapter.notifyDataSetChanged()
            }


        }

    }
}
