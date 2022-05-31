package com.example.borutoapp.domain.usecase

import com.example.borutoapp.domain.usecase.read_onboarding.ReadOnBoardingUseCase
import com.example.borutoapp.domain.usecase.save_onboarding.SaveOnBoardingUseCase

data class UsesCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase
)
