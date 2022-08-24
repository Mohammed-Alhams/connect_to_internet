package com.example.connecttointernet.viewModels

import androidx.lifecycle.*
import com.example.connecttointernet.model.domain.User
import com.example.connecttointernet.model.domain.Wisdom
import com.example.connecttointernet.model.repos.MainRepo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repo = MainRepo()
    private val disposable = CompositeDisposable()

    private val _currentUser = MutableStateFlow(repo.getUser())
    val currentUser: StateFlow<User>
        get() = _currentUser

    private val _wisdom = repo.getWisdomFlow().asLiveData()
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

//    fun getSomeWisdom() = _wisdom.postValue(repo.getWisdom())

    fun getRxSomeWisdom() {
        disposable.add(
            repo.getRxWisdom()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onFetchWisdomSuccess, this::onFetchWisdomFailure)
        )
    }

//    fun getCoroutinesSomeWisdom() {
//        viewModelScope.launch {
//            val result = repo.getWisdom()
//            _wisdom.postValue(result)
//        }
//    }

//    fun getWisdomFlow() {
//        viewModelScope.launch {
//            repo.getWisdomFlow().collect{
//                _wisdom.postValue(it)
//            }
//        }
//    }


    fun onFetchWisdomSuccess(wisdom: Wisdom) {
//        _wisdom.postValue(wisdom)
    }

    fun onFetchWisdomFailure(throwable: Throwable) {

    }
    
    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }


}