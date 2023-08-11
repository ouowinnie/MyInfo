package com.example.signinactivity

import android.app.AlertDialog
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(val items: MutableList<Pair<Any, String>>) : RecyclerView.Adapter<RVAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return ViewHolder(view)
    }
    // 뷰 홀더에 바인딩 해주는 친구
    // 뷰 바인딩 : 어뎁터에 넣어온 데이터를 아이템에 넣어서 리사이클러뷰에 넣어주는 작업
    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {
        val (itemImage, itemText) = items[position]
        holder.bindImageResource(itemImage as Int)
        holder.bindTextItem(itemText)
    }
    // 전체 리사이클러뷰의 갯수를 알려주는 친구
    override fun getItemCount(): Int {
        return items.size

    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindImageResource(imageRes: Int) {
            val imageView = itemView.findViewById<ImageView>(R.id.imageView)
            imageView.setImageResource(imageRes)
            imageView.setOnClickListener {
//                val dialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null)
//                val builder = AlertDialog.Builder(this)
//                    .setView(dialogView)
//                builder.show()
            }
        }
        fun bindTextItem(text: String) {
            val rvText = itemView.findViewById<TextView>(R.id.rvItem)
            rvText.text = text
        }
    }

}