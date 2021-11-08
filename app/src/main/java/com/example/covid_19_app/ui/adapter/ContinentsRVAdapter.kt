package com.example.covid_19_app.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covid_19_app.databinding.ItemContinentBinding
import com.example.covid_19_app.mvp.presenter.ContinentListPresenter
import com.example.covid_19_app.mvp.view.ContinentItemView

class ContinentsRVAdapter(val presenter: ContinentListPresenter) :
    RecyclerView.Adapter<ContinentsRVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemContinentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
        .apply {
            itemView.setOnClickListener {
                presenter.itemClickListener?.invoke(this)
            }
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        presenter.bindView(holder.apply { pos = position })

    override fun getItemCount() = presenter.getCount()
    inner class ViewHolder(val vb: ItemContinentBinding) : RecyclerView.ViewHolder(vb.root),
        ContinentItemView {

        override var pos = -1

        override fun setName(text: String) {
            vb.tvName.text = text
        }

        override fun setCases(text: String) {
            vb.tvCases.text = text
        }

        override fun setTodayCases(text: String) {
            vb.tvTodayCases.text = text
        }

        override fun setDeaths(text: String) {
            vb.tvDeaths.text = text
        }

        override fun setTodayDeaths(text: String) {
            vb.tvTodayDeaths.text = text
        }

        override fun setRecovered(text: String) {
            vb.tvRecovered.text = text
        }

        override fun setTodayRecovered(text: String) {
            vb.tvTodayRecovered.text = text
        }


    }


}