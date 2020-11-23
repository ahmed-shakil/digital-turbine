package com.digitalturbine.interview.viewmodels

import androidx.lifecycle.*
import com.digitalturbine.interview.DigitalTurbineApp
import com.digitalturbine.interview.Toolkit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * BaseViewModel.
 */
abstract class BaseViewModel<T>: AndroidViewModel(DigitalTurbineApp.context), Callback<T> {

    protected val data = MutableLiveData<T>()

    fun get (): T? = data.value

    open fun fetch (owner: LifecycleOwner, observer: Observer<T>) {
        data.observe( owner, observer )
        api().enqueue(this)
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        data.value = response.body()
    }

    override fun onFailure (call: Call<T>, t: Throwable) = Toolkit.error(t)
    fun remove (observer: Observer<T>) = data.removeObserver( observer )

    protected abstract fun api (): Call<T>

}