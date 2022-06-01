package com.example.borutoapp.domain.usecase

import com.example.borutoapp.domain.usecase.get_all_heroes.GetAllHeroesUseCase
import com.example.borutoapp.domain.usecase.read_onboarding.ReadOnBoardingUseCase
import com.example.borutoapp.domain.usecase.save_onboarding.SaveOnBoardingUseCase

data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase,
    val getAllHeroesUseCase: GetAllHeroesUseCase
)
