package com.example.weekly_practice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weekly_practice.data.remote.CatFact
import com.example.weekly_practice.data.remote.CatFactResult
import com.example.weekly_practice.domain.repository.CatFactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val catFactRepository: CatFactRepository
) : ViewModel() {

    private val _catFact = MutableStateFlow(CatFact())
    val catFact = _catFact.asStateFlow()



    init {

        viewModelScope.launch {

            catFactRepository.getCatFact().collect { catFactResult ->
                when (catFactResult) {
                    is CatFactResult.Failure -> {

                    }

                    is CatFactResult.Success -> {
                        catFactResult.data?.let { catFact ->
                            _catFact.update { catFact }
                        }
                    }
                }
            }

        }

    }

}