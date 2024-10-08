package id.biz.equatron.dattebayo.favorite.di

import id.biz.equatron.dattebayo.favorite.FavoriteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteModule = module {
    viewModel { FavoriteViewModel(get()) }
}