package com.example.and08_recyclerview

import android.view.View

interface OnPersonItemClickListener {
    fun onItemClick(holder : PersonAdapter.ViewHolder, view : View, position : Int)
}