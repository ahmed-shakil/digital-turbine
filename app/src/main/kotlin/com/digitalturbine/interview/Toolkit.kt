package com.digitalturbine.interview

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.digitalturbine.interview.api.AdService
import com.digitalturbine.interview.api.ApiFactory
import kotlin.reflect.KClass

/**
 * System tools and utilities
 */
object Toolkit {

    private const val TAG = "${Constants.TAG}::Toolkit"

    val context: Context get() = DigitalTurbineApp.context
    val resources: Resources get() = context.resources

    val api: AdService = ApiFactory.createAdService()

    val deviceId = "4230"
    val sessionId = "techtestsession"

    private val vmf: ViewModelProvider.Factory = ViewModelProvider.NewInstanceFactory()

    fun <T: ViewModel> getViewModel (a: AppCompatActivity, c: KClass<T>) : T = ViewModelProvider(a, vmf).get(c.java)
    fun <T: ViewModel> getViewModel (f: Fragment, c: KClass<T>) : T = ViewModelProvider(f, vmf).get(c.java)

    /** Get drawable from resource */
    fun getDrawable (id: Int) = ContextCompat.getDrawable(context, id)

    /** Launch a browser for the provided URL **/
    fun browse (url: String) {
        context.startActivity( Intent( Intent.ACTION_VIEW, Uri.parse( url ) ) )
    }

    /** Display quick error message.
     * NOTE:- In production code better mechanism will be implemented.
     */
    fun error (err: String) {
        Toast.makeText(context, err, Toast.LENGTH_LONG).show()
    }

    fun error (err: Throwable) {
        val msg = err.localizedMessage!!
        error( msg )
        Log.e(TAG, msg, err)
    }
}