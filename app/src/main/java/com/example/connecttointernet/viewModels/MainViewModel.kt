package com.example.connecttointernet.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.connecttointernet.model.domain.User
import com.example.connecttointernet.model.domain.Wisdom
import com.example.connecttointernet.model.repos.MainRepo
import com.example.connecttointernet.ui.bindingAdapters.Colors

class MainViewModel : ViewModel() {

    private val repo = MainRepo()

    private val _currentUser = MutableLiveData<User>()
    val currentUser: LiveData<User>
        get() = _currentUser

    private val _wisdom = MutableLiveData<Wisdom>()
    val wisdom: LiveData<Wisdom>
        get() = _wisdom

    val color = MutableLiveData<Colors>()
    fun changeColorRandomly(){
        color.postValue(Colors.values().random())
    }

    val loading = MutableLiveData<Boolean>(true)
    fun changeLoading(){
        if (loading.value == true) loading.postValue(false) else loading.postValue(true)
    }


    init {
        getUserInfo()
    }

    fun getSomeWisdom() = _wisdom.postValue(repo.getWisdom())

    fun getUserInfo() = _currentUser.postValue(repo.getUser())

}