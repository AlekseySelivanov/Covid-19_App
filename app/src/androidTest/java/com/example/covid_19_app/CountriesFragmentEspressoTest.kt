package com.example.covid_19_app

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.covid_19_app.ui.adapter.CountriesRVAdapter
import com.example.covid_19_app.ui.fragment.CountriesFragment
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class CountriesFragmentEspressoTest {
    private lateinit var scenario: FragmentScenario<CountriesFragment>

    @Before
    fun setup() {
        scenario = launchFragmentInContainer()
    }


    @Test
    fun fragment_AssertNotNull() {
        scenario.onFragment {
            TestCase.assertNotNull(it)
        }
    }

    @Test
    fun fragment_RecyclerViewIsNotNull() {

        scenario.onFragment {
            onView(withId(R.id.rv_countries))
            val rv = it.view?.findViewById<RecyclerView>(R.id.rv_countries)
            TestCase.assertNotNull(rv)
        }
    }

    @Test
    fun fragment_CountrieScrollTo() {
        onView(withId(R.id.rv_countries))
            .perform(
                RecyclerViewActions.scrollToPosition<CountriesRVAdapter.ViewHolder>(2)
            )
    }

    @Test
    fun fragment_CountriePerformClickAtPosition() {
        onView(withId(R.id.rv_countries))
            .perform(
                RecyclerViewActions.scrollToPosition<CountriesRVAdapter.ViewHolder>(3),
                click()
            )
    }


}