package com.example.borutoapp.domain.usecase.save_onboarding

import com.example.borutoapp.data.repository.Repository

class SaveOnBoardingUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(completed: Boolean) {
        return repository.saveOnBoardingState(completed)
    }
}