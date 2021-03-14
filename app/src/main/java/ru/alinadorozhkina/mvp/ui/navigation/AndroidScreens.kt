package ru.alinadorozhkina.mvp.ui.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.alinadorozhkina.mvp.mvp.model.entity.GitUser
import ru.alinadorozhkina.mvp.mvp.navigation.IScreens
import ru.alinadorozhkina.mvp.ui.fragments.UserDetailedFragment
import ru.alinadorozhkina.mvp.ui.fragments.UsersFragment


class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
    override fun user(user: GitUser) = FragmentScreen { UserDetailedFragment.newInstance(user) }
}