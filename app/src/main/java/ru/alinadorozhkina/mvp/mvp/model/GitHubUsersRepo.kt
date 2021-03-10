package ru.alinadorozhkina.mvp.mvp.model

import ru.alinadorozhkina.mvp.mvp.model.entity.GitUser

class GitHubUsersRepo {
    private val users = listOf(
        GitUser("login1"),
        GitUser("login2"),
        GitUser("login3"),
        GitUser("login4"),
        GitUser("login5")
    )

    fun getUsers(): List<GitUser> = users
}