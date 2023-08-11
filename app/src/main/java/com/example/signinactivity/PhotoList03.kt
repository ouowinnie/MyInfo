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

class PhotoList03 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_photo_list03, container, false)

        val items = mutableListOf<Pair<Any, String>>()
        items.add(Pair(R.drawable.fragment_img_07, "일하면서 어려웠던 점은? 가 좍같은 분위기"))
        items.add(Pair(R.drawable.fragment_img_08, "공주 하고 싶은 거 다 해 공주는 그래도 돼~"))
        items.add(Pair(R.drawable.fragment_img_09, "공주 앞길 아무도 못 막아 go away"))
        items.add(Pair(R.drawable.fragment_img_07, "일하면서 어려웠던 점은? 가 좍같은 분위기"))
        items.add(Pair(R.drawable.fragment_img_08, "공주 하고 싶은 거 다 해 공주는 그래도 돼~"))
        items.add(Pair(R.drawable.fragment_img_09, "공주 앞길 아무도 못 막아 go away"))

        val rv = view.findViewById<RecyclerView>(R.id.photoRV)
        val rvAdapter = RVAdapter(items)

        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(context)

        val image01 = view.findViewById<ImageView>(R.id.image01)
        image01.setOnClickListener {
            it.findNavController().navigate(R.id.action_photoList03_to_photoList01)
        }
        val image02 = view.findViewById<ImageView>(R.id.image02)
        image02.setOnClickListener {
            it.findNavController().navigate(R.id.action_photoList03_to_photoList02)
        }
        return view
    }
}