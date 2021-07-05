package com.example.covid_19_app.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covid_19_app.databinding.FragmentCountriesBinding
import com.example.covid_19_app.mvp.model.image.IImageLoader
import com.example.covid_19_app.mvp.model.repo.ContinentsRepo
import com.example.covid_19_app.mvp.presenter.CountriesPresenter
import com.example.covid_19_app.mvp.view.CountriesView
import com.example.covid_19_app.ui.AbsFragment
import com.example.covid_19_app.ui.BackButtonListener
import com.example.covid_19_app.ui.adapter.CountriesRVAdapter
import io.reactivex.rxjava3.core.Scheduler
import com.example.covid_19_app.R.layout.fragment_countries
import moxy.ktx.moxyPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject


class CountriesFragment : AbsFragment(fragment_countries), CountriesView, BackButtonListener {
    companion object {
        private const val CONTINENT_NAME = "CONTINENT_NAME"

        @JvmStatic
        fun newInstance(continentName: String) =
            CountriesFragment().apply {
                arguments = Bundle().apply {
                    putString(CONTINENT_NAME, continentName)
                }
            }

    }

    private var _binding: FragmentCountriesBinding? = null
    private val binding get() = _binding!!
    private val continentName by lazy {
        arguments?.getString(CONTINENT_NAME) ?: ""
    }

    @Inject
    lateinit var continentsRepo: ContinentsRepo

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var scheduler: Scheduler

    @Inject
    lateinit var imageLoader: IImageLoader<ImageView>

    private val presenter by moxyPresenter {
        CountriesPresenter(
            continentName,
            continentsRepo,
            scheduler,
            router
        )
    }

    private var adapter: CountriesRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return FragmentCountriesBinding.inflate(inflater, container, false).also {
            _binding = it
        }.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun setName(text: String) {
        binding.tvName.text = text
    }

    override fun setCases(text: String) {
        binding.tvCases.text = text
    }

    override fun setTodayCases(text: String) {
        binding.tvTodayCases.text = text
    }

    override fun setDeaths(text: String) {
        binding.tvDeaths.text = text
    }

    override fun setTodayDeaths(text: String) {
        binding.tvTodayDeaths.text = text
    }

    override fun setRecovered(text: String) {
        binding.tvRecovered.text = text
    }

    override fun setTodayRecovered(text: String) {
        binding.tvTodayRecovered.text = text
    }

    override fun init() {
        binding.rvCountries.layoutManager = LinearLayoutManager(context)
        adapter = CountriesRVAdapter(presenter.countriesListPresenter,imageLoader)
        binding.rvCountries.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()


}