package com.example.signinactivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PhotoList02 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_photo_list02, container, false)

        val items = mutableListOf<Pair<Any, String>>()
        items.add(Pair(R.drawable.fragment_img_04, "재밌게 오늘 하루 보내고 돈은 허튼데 써"))
        items.add(Pair(R.drawable.fragment_img_05, "가난을 거꾸로 읽으면? 난가? 아..."))
        items.add(Pair(R.drawable.fragment_img_06, "보고 싶다 말하면 들릴까요 내 맘 알까요"))
        items.add(Pair(R.drawable.fragment_img_04, "재밌게 오늘 하루 보내고 돈은 허튼데 써"))
        items.add(Pair(R.drawable.fragment_img_05, "가난을 거꾸로 읽으면? 난가? 아..."))
        items.add(Pair(R.drawable.fragment_img_06, "보고 싶다 말하면 들릴까요 내 맘 알까요"))

        val rv = view.findViewById<RecyclerView>(R.id.photoRV)
        val rvAdapter = RVAdapter(items)

        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(context)

        val image01 = view.findViewById<ImageView>(R.id.image01)
        image01.setOnClickListener {
            it.findNavController().navigate(R.id.action_photoList02_to_photoList01)
        }
        val image03 = view.findViewById<ImageView>(R.id.image03)
        image03.setOnClickListener {
            it.findNavController().navigate(R.id.action_photoList02_to_photoList03)
        }
        return view
    }

}