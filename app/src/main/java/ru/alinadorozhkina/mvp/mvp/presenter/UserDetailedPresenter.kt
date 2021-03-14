package ru.alinadorozhkina.mvp.mvp.presenter

import moxy.MvpPresenter
import ru.alinadorozhkina.mvp.mvp.model.entity.GitUser
import ru.alinadorozhkina.mvp.mvp.view.UserDetailedView

class UserDetailedPresenter(val user: GitUser?) : MvpPresenter<UserDetailedView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        user?.login?.let { viewState.setUserLogin(it) }
    }
}