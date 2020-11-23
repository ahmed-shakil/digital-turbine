@file:Suppress("DEPRECATION")

package com.digitalturbine.interview.api

import com.digitalturbine.interview.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.util.concurrent.TimeUnit

/**
 * ApiFactory.
 */
object ApiFactory {

    /**
     * Create Api service object.
     */
    fun createAdService(): AdService {

        // okHttp
        val okHttpClient = createHttpBuilder().build()

        // Using deprecated converter: SimpleXmlConvertFactory
        // The new JaxbConverterFactory is not supported on Android
        val xmlConverter = SimpleXmlConverterFactory.create()

        // retrofit
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(Constants.API_URL)
            .addConverterFactory( xmlConverter )
            .client(okHttpClient)

        return retrofitBuilder.build().create(AdService::class.java)
    }

    private fun createHttpBuilder () = OkHttpClient().newBuilder()
        .readTimeout(300, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS)
}
