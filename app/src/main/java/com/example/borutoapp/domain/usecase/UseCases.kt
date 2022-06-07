package com.example.borutoapp.domain.usecase

import com.example.borutoapp.domain.usecase.get_all_heroes.GetAllHeroesUseCase
import com.example.borutoapp.domain.usecase.get_selected_hero.GetSelectedHeroUseCase
import com.example.borutoapp.domain.usecase.read_onboarding.ReadOnBoardingUseCase
import com.example.borutoapp.domain.usecase.save_onboarding.SaveOnBoardingUseCase
import com.example.borutoapp.domain.usecase.search_heroes.SearchHeroesUseCase

data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase,
    val getAllHeroesUseCase: GetAllHeroesUseCase,
    val searchHeroesUseCase: SearchHeroesUseCase,
    val getSelectedHeroUseCase: GetSelectedHeroUseCase
)
