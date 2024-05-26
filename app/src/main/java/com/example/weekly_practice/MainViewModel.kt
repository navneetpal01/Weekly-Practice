package com.example.weekly_practice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weekly_practice.data.remote.CurrencyResult
import com.example.weekly_practice.domain.repository.CurrencyRepository
import com.example.weekly_practice.model.Currency
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val currencyRepository: CurrencyRepository
) : ViewModel() {

    private val _currencyData = MutableStateFlow<Currency?>(null)
    val currencyData = _currencyData.asStateFlow()


    init {
        viewModelScope.launch {
            while (isActive) {
                currencyRepository.getCurrencyDetails().collect { currencyResult ->
                    when (currencyResult) {
                        is CurrencyResult.Failure -> {

                        }
                        is CurrencyResult.Success -> {
                            currencyResult.data?.let { currency ->
                                _currencyData.update { currency }
                            }
                        }
                    }
                }
            }
        }
    }

}