package ru.alinadorozhkina.mvp.mvp.presenter

import moxy.MvpPresenter
import ru.alinadorozhkina.mvp.mvp.model.GitHubUsersRepo
import ru.alinadorozhkina.mvp.mvp.model.entity.GitUser
import ru.alinadorozhkina.mvp.mvp.presenter.list.IUserListPresenter
import ru.alinadorozhkina.mvp.mvp.view.MainView
import ru.alinadorozhkina.mvp.mvp.view.list.IUserItemView

class MainPresenter(val userRepo: GitHubUsersRepo) : MvpPresenter<MainView>() {

    class UserListPresenter : IUserListPresenter {
        val users = mutableListOf<GitUser>()
        override var itemClickListener: ((IUserItemView) -> Unit)? = null

        override fun bindView(view: IUserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }

        override fun getCount(): Int = users.size
    }

    val usersListPresenter = UserListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
    }

    private fun loadData() {
        val users = userRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }
}