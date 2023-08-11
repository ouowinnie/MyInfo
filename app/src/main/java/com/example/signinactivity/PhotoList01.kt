package com.example.signinactivity

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PhotoList01 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_photo_list01, container, false)

        val items = mutableListOf<Pair<Any, String>>()
        items.add(Pair(R.drawable.fragment_img_01, "불규칙한 생활을 규칙적으로 합니다"))
        items.add(Pair(R.drawable.fragment_img_02, "Pretty YangPha.. Beautiful Love..."))
        items.add(Pair(R.drawable.fragment_img_03, "Dog Park센 하루 시작!"))
        items.add(Pair(R.drawable.fragment_img_01, "불규칙한 생활을 규칙적으로 합니다"))
        items.add(Pair(R.drawable.fragment_img_02, "Pretty YangPha.. Beautiful Love..."))
        items.add(Pair(R.drawable.fragment_img_03, "Dog Park센 하루 시작!"))

        val rv = view.findViewById<RecyclerView>(R.id.photoRV)
        val rvAdapter = RVAdapter(items)

        rv.setOnClickListener {
            val dialogView = LayoutInflater.from(context).inflate(R.layout.custom_dialog, null)
            val builder = AlertDialog.Builder(context)
                .setView(dialogView)
            builder.show()
        }

        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(context)

        val image02 = view.findViewById<ImageView>(R.id.image02)
        image02.setOnClickListener {
            it.findNavController().navigate(R.id.action_photoList01_to_photoList02)
        }
        val image03 = view.findViewById<ImageView>(R.id.image03)
        image03.setOnClickListener {
            it.findNavController().navigate(R.id.action_photoList01_to_photoList03)
        }
        return view
    }
}