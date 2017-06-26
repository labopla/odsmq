package io.github.labopla.odsmq.components

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import io.github.labopla.odsmq.R
import io.github.labopla.odsmq.models.Quest

class MyArrayAdapter(context: Context, layoutId: Int, items: List<Quest>): ArrayAdapter<Quest>(context, layoutId, items) {
    val quests = items
    val listLayoutId = layoutId
    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: inflater.inflate(listLayoutId, null)
        val item = quests[position]
        (view.findViewById(R.id.detail) as TextView).text = item.detail
        (view.findViewById(R.id.createdBy) as TextView).text = item.client.name
        return view
    }
}