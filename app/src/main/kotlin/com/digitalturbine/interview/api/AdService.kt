package com.digitalturbine.interview.api

import com.digitalturbine.interview.Constants
import com.digitalturbine.interview.Toolkit
import com.digitalturbine.interview.model.Ads
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * ApiService.
 */
interface AdService {

    /**
     * Ad example URL:
     * http://ads.appia.com/getAds?id=236&password=OVUJ1DJN&siteId=10777&deviceId=4230&sessionId=techtestsession&totalCampaignsRequested=10&lname=Shakil
     */
    @GET("getAds")
    fun getAds(
        @Query("id") id: String,
        @Query("siteId") siteId: String = Constants.SITE_ID,
        @Query("password") pwd: String = Constants.API_PWD,
        @Query("deviceId") deviceId: String = Toolkit.deviceId,
        @Query("sessionId") sessionId: String = Toolkit.sessionId,
        @Query("totalCampaignsRequested") pageSize: Int = Constants.PAGE_SIZE,
        @Query("lname") lastname: String = Constants.LAST_NAME
    ): Call<Ads>
}