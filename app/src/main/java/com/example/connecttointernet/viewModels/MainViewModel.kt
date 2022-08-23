package com.example.connecttointernet.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.connecttointernet.model.domain.User
import com.example.connecttointernet.model.domain.Wisdom
import com.example.connecttointernet.model.repos.MainRepo

class MainViewModel : ViewModel() {

    private val repo = MainRepo()
    val currentUser = MutableLiveData<User>()
    val wisdom = MutableLiveData<Wisdom>()

    fun getWisdom() = wisdom.postValue(repo.getWisdom())

    fun getUserInfo() = currentUser.postValue(repo.getUser())

}