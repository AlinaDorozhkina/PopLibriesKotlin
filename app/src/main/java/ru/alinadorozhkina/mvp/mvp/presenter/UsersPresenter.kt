package ru.alinadorozhkina.mvp.mvp.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.alinadorozhkina.mvp.mvp.model.GitHubUsersRepo
import ru.alinadorozhkina.mvp.mvp.model.entity.GitUser
import ru.alinadorozhkina.mvp.mvp.presenter.list.IUserListPresenter
import ru.alinadorozhkina.mvp.mvp.view.UsersView
import ru.alinadorozhkina.mvp.mvp.view.list.IUserItemView

class UsersPresenter(val userRepo: GitHubUsersRepo, val router: Router) :
    MvpPresenter<UsersView>() {

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

    fun backClicked(): Boolean {
        router.exit()
        return true
    }

}