package com.example.covid_19_app.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.covid_19_app.databinding.ItemCountryBinding
import com.example.covid_19_app.mvp.model.image.IImageLoader
import com.example.covid_19_app.mvp.presenter.CountryListPresenter
import com.example.covid_19_app.mvp.view.CountryItemView

class CountriesRVAdapter(val presenter: CountryListPresenter, val imageLoader: IImageLoader<ImageView>) :
    RecyclerView.Adapter<CountriesRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemCountryBinding.inflate(
                LayoutInflater.from(parent.context), parent,
                false
            )
        ).apply {
            itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
        }

    override fun getItemCount() = presenter.getCount()
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        presenter.bindView(holder.apply { pos = position })
    }

    inner class ViewHolder(val vb: ItemCountryBinding) : RecyclerView.ViewHolder(vb.root),
        CountryItemView {
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

        override fun loadImage(text: String) {
            imageLoader.loadInto(text,vb.ivFlag)
        }
    }
}