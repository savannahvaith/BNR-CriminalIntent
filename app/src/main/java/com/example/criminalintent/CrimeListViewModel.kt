package com.example.criminalintent

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.criminalintent.CrimeRepository.Companion
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Date
import java.util.UUID

private const val TAG = "CrimeListViewModel"
class CrimeListViewModel : ViewModel() {

    val crimes = mutableListOf<Crime>()

    init {
        Log.d(TAG,"init starting")
        viewModelScope.launch {
        Log.d(TAG,"coroutine launched")
            crimes += loadCrimes()
            Log.d(TAG,"Loading crimes finished")
        }

    }

    suspend fun loadCrimes() = CrimeRepository.get().getCrimes()
}
