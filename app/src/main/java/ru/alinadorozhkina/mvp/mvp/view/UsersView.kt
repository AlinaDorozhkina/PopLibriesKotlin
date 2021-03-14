package ru.alinadorozhkina.mvp.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.alinadorozhkina.mvp.mvp.model.entity.GitUser

@StateStrategyType(AddToEndSingleStrategy::class)
interface UsersView: MvpView {
    fun init()
    fun updateList()
}