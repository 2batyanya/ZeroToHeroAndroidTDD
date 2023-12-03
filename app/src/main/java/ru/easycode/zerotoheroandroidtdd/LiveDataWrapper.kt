package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper: ProvideLiveData  {

    fun update(value: UiState)

    // OOP solution instead Google which always write 2 liveData
    class Base(private val liveData: MutableLiveData<UiState> = MutableLiveData()
    ) : LiveDataWrapper {
        override fun update(value: UiState) {
            liveData.value = value
        }

        override fun liveData(): LiveData<UiState> {
            return liveData
        }

    }
}
// interface segregation SOLID
interface ProvideLiveData {
    fun liveData(): LiveData<UiState>
}