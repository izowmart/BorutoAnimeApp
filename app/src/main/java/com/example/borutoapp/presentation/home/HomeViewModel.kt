package com.example.borutoapp.presentation.home

import androidx.lifecycle.ViewModel
import com.example.borutoapp.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    useCases: UseCases
): ViewModel() {

    val getAllHeroes = useCases.getAllHeroesUseCase()

}