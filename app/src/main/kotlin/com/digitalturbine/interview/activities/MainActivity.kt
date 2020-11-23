package com.digitalturbine.interview.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.digitalturbine.interview.DetailsActivity
import com.digitalturbine.interview.R
import com.digitalturbine.interview.Toolkit
import com.digitalturbine.interview.adapters.AdAdapter
import com.digitalturbine.interview.model.Ad
import com.digitalturbine.interview.model.Ads
import com.digitalturbine.interview.viewmodels.AdsViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*


/**
 * Main activity:
 *   1- Show splash screen
 *   2- Load Ads
 *   3- Show ads in main activity
 */
class MainActivity : AppCompatActivity(), Observer<Ads> {

    /**
     * Create UI for this activity.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_main)  // splash page

        // ----- FAKE SPLASH SCREEN DELAY ------ //
        // ----- NOT  FOR PRODUCTION CODE ------ //
        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main) { loadData() }
        }
    }

    /**
     * Set to main layout.
     */
    private fun createContent(ads: List<Ad>) {
        setContentView(R.layout.activity_main)

        rv.adapter = AdAdapter(ads) { ad ->
            startActivity(Intent(baseContext, DetailsActivity::class.java).apply {
                putExtra(DetailsActivity.PARAM_AD, ad)
            })
        }
        rv.layoutManager = LinearLayoutManager(this)
    }

    /**
     * Fetch data from the view model.
     */
    private fun loadData () =
        Toolkit.getViewModel(this, AdsViewModel::class).apply { id = "236" }.fetch(this, this)

    /**
     * Business details callback.
     */
    override fun onChanged(ads: Ads) {
        createContent(ads.items)
    }
}