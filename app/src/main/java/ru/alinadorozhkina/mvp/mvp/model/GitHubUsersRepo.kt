package ru.alinadorozhkina.mvp.mvp.model

import io.reactivex.rxjava3.core.Observable
import ru.alinadorozhkina.mvp.mvp.model.entity.GitUser

class GitHubUsersRepo {
    private val users = listOf(
        GitUser("login1"),
        GitUser("login2"),
        GitUser("login3"),
        GitUser("login4"),
        GitUser("login5")
    )

    fun getUsers(): Observable<GitUser> = Observable.fromIterable(users)
}