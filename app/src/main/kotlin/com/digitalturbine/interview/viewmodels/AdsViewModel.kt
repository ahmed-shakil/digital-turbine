package com.digitalturbine.interview.viewmodels

import com.digitalturbine.interview.Toolkit
import com.digitalturbine.interview.model.Ads
import retrofit2.Call

/**
 * AdViewModel.
 */
class AdsViewModel: BaseViewModel<Ads>() {

    var id = ""

    override fun api(): Call<Ads> = Toolkit.api.getAds(id)
}