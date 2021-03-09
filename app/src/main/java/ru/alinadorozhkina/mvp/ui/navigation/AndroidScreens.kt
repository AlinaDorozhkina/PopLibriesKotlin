package ru.alinadorozhkina.mvp.ui.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.alinadorozhkina.mvp.mvp.navigation.IScreens
import ru.alinadorozhkina.mvp.ui.fragments.UsersFragment


class AndroidScreens: IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
}