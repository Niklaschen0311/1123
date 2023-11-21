package com.example.ch_7

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    data class Data(val photo: Int, val name: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transNameArray = arrayOf("腳踏車", "機車", "汽車", "巴士", "飛機", "輪船")
        val transPhotoIdArray = intArrayOf(
            R.drawable.trans1, R.drawable.trans2, R.drawable.trans3,
            R.drawable.trans4, R.drawable.trans5, R.drawable.trans6
        )
        val transData = Array(transNameArray.size) { i ->
            Data(transPhotoIdArray[i], transNameArray[i])
        }

        val transAdapter = MyAdapter(transData, R.layout.trans_list)
        val spinner: Spinner = findViewById(R.id.spinner)
        spinner.adapter = transAdapter

        val cubeeNameArray = arrayOf(
            "哭哭", "發抖", "再見", "生氣", "昏倒", "竊笑", "很棒", "你好", "驚嚇", "大笑"
        )
        val cubeePhotoIdArray = intArrayOf(
            R.drawable.cubee1, R.drawable.cubee2, R.drawable.cubee3, R.drawable.cubee4,
            R.drawable.cubee5, R.drawable.cubee6, R.drawable.cubee7, R.drawable.cubee8,
            R.drawable.cubee9, R.drawable.cubee10
        )
        val cubeeData = Array(cubeeNameArray.size) { i ->
            Data(cubeePhotoIdArray[i], cubeeNameArray[i])
        }
        val cubeeAdapter = MyAdapter(cubeeData, R.layout.cubee_list)
        val gridView: GridView = findViewById(R.id.gridView)
        gridView.adapter = cubeeAdapter
        gridView.numColumns = 3

        val messageArray = arrayOf("訊息1", "訊息2", "訊息3", "訊息4", "訊息5", "訊息6")
        val messageAdapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, messageArray)
        val listView: ListView = findViewById(R.id.listView)
        listView.adapter = messageAdapter
    }

    inner class MyAdapter(private val data: Array<Data>, private val view: Int) : BaseAdapter() {

        override fun getCount(): Int = data.size

        override fun getItem(position: Int): Any = data[position]

        override fun getItemId(position: Int): Long = 0

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var convertView = convertView
            convertView = layoutInflater.inflate(view, parent, false)
            val name: TextView = convertView.findViewById(R.id.name)
            name.text = data[position].name
            val imageView: ImageView = convertView.findViewById(R.id.imageView)
            imageView.setImageResource(data[position].photo)
            return convertView
        }
    }
}
