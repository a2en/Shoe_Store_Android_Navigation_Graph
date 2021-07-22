package io.github.a2en.shoestore.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.a2en.shoestore.model.Shoe

class ShoeViewModel : ViewModel() {
    private val _shoes = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

    fun addShoe(detail: Shoe?) {
        detail?.let {
            _shoes.value?.add(it)
        }
    }
}