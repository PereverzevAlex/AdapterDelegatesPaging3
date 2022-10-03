package com.hannesdorfmann.adapterdelegates4.paging3

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate

abstract class AbsItemAdapterDelegate<I : T, T, VH : RecyclerView.ViewHolder> :
    AdapterDelegate<AdapterItemProvider<T>>() {
    override fun isForViewType(items: AdapterItemProvider<T>, position: Int): Boolean {
        val item = items.getAdapterItem(position)
        return item != null && isForViewType(item, items, position)
    }

    override fun onBindViewHolder(
        items: AdapterItemProvider<T>, position: Int,
        holder: RecyclerView.ViewHolder, payloads: List<Any>
    ) {
        @Suppress("UNCHECKED_CAST")
        onBindViewHolder(items.getAdapterItem(position) as I, holder as VH, payloads)
    }

    protected abstract fun isForViewType(
        item: T,
        items: AdapterItemProvider<T>,
        position: Int,
    ): Boolean

    abstract override fun onCreateViewHolder(parent: ViewGroup): VH

    protected abstract fun onBindViewHolder(
        item: I,
        holder: VH,
        payloads: List<Any>,
    )
}
