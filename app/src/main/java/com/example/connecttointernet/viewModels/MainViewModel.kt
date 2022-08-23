package com.example.connecttointernet.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.connecttointernet.model.domain.User
import com.example.connecttointernet.model.domain.Wisdom
import com.example.connecttointernet.model.repos.MainRepo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repo = MainRepo()
    private val disposable = CompositeDisposable()

    private val _currentUser = MutableLiveData<User>()
    val currentUser: LiveData<User>
        get() = _currentUser

    private val _wisdom = MutableLiveData<Wisdom>()
    val wisdom: LiveData<Wisdom>
        get() = _wisdom

//    val color = MutableLiveData<Colors>()
//    fun changeColorRandomly(){
//        color.postValue(Colors.values().random())
//    }
//
//    val loading = MutableLiveData<Boolean>(true)
//    fun changeLoading(){
//        if (loading.value == true) loading.postValue(false) else loading.postValue(true)
//    }


    init {
        getUserInfo()
    }

//    fun getSomeWisdom() = _wisdom.postValue(repo.getWisdom())

    fun getRxSomeWisdom() {
        disposable.add(
            repo.getRxWisdom()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onFetchWisdomSuccess, this::onFetchWisdomFailure)
        )
    }

    fun getCoroutinesSomeWisdom() {
        viewModelScope.launch {
            val result = repo.getWisdom()
            _wisdom.postValue(result)
        }
    }

    fun onFetchWisdomSuccess(wisdom: Wisdom) {
        _wisdom.postValue(wisdom)
    }

    fun onFetchWisdomFailure(throwable: Throwable) {

    }


    fun getUserInfo() = _currentUser.postValue(repo.getUser())

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }


}