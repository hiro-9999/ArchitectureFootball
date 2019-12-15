package io.github.itakahiro.architecturefootball.feature.football

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import io.github.itakahiro.architecturefootball.R
import io.github.itakahiro.architecturefootball.model.PlayCall


class PlayCallHistoryListAdapter(
    fragment: FootballFragment,
    viewModel: FootballViewModel
) : RecyclerView.Adapter<PlayCallHistoryListAdapter.ViewHolder>() {
    init {
        viewModel.playCallHistoryList.observe(fragment, Observer { historyList ->
            historyList.forEach { playCall ->
                setItem(playCall)
            }
        })
    }
    private val items = mutableListOf<PlayCall>()

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_hitory_list, parent, false)
        return ViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position].description
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<View>(R.id.textViewHistoryItem) as TextView
    }

    private fun setItem(item: PlayCall) {
        items.clear()
        items.add(item)
        notifyDataSetChanged()
    }
}