package com.example.covid_19_app.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covid_19_app.databinding.FragmentContinentsBinding
import com.example.covid_19_app.mvp.model.repo.ContinentsRepo
import com.example.covid_19_app.mvp.view.ContinentsView
import com.example.covid_19_app.ui.AbsFragment
import com.example.covid_19_app.ui.BackButtonListener
import com.example.covid_19_app.ui.adapter.ContinentsRVAdapter
import io.reactivex.rxjava3.core.Scheduler
import com.example.covid_19_app.R.layout.fragment_countries
import com.example.covid_19_app.mvp.presenter.ContinentsPresenter
import moxy.ktx.moxyPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject


class ContinentsFragment : AbsFragment(fragment_countries), ContinentsView, BackButtonListener {

    companion object {
        @JvmStatic
        fun newInstance() =
            ContinentsFragment()

    }

    private var _binding: FragmentContinentsBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var continentsRepo: ContinentsRepo

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var scheduler: Scheduler

    val presenter by moxyPresenter {
        ContinentsPresenter(continentsRepo, scheduler, router)
    }
    var adapter: ContinentsRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return FragmentContinentsBinding.inflate(inflater, container, false)
            .also { _binding = it }.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun init() {
        binding.rvContinents.layoutManager = LinearLayoutManager(context)
        adapter = ContinentsRVAdapter(presenter.continentListPresenter)
        binding.rvContinents.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()
}