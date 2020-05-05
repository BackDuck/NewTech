package com.example.presentation.ui.main

import androidx.lifecycle.*
import com.example.domain.State
import com.example.domain.entity.PhotoEntity
import com.example.domain.usecase.GetPhotosUseCase
import com.example.presentation.ui.base.BasePresenter
import kotlinx.coroutines.launch
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance


class TestViewModel(override val kodein: Kodein) : BasePresenter(){

    val getPhotoUseCase: GetPhotosUseCase by instance()

    fun getData(): MutableLiveData<State>{
        return getPhotoUseCase.data
    }

    fun requestChanged(query: String){
        viewModelScope.launch {
            getPhotoUseCase.getPhotos(query)
        }
    }

    class Factory(val kdin: Kodein) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return TestViewModel(kdin) as T
        }
    }

}