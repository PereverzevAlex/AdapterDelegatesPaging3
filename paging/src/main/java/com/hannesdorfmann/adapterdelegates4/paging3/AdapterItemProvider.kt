package com.hannesdorfmann.adapterdelegates4.paging3

interface AdapterItemProvider<T> {
    fun getAdapterItem(position: Int): T?

    val adapterItemCount: Int
}