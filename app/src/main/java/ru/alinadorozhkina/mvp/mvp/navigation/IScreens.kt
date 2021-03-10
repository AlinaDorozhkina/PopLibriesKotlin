package ru.alinadorozhkina.mvp.mvp.navigation

import com.github.terrakok.cicerone.Screen
import ru.alinadorozhkina.mvp.mvp.model.entity.GitUser

interface IScreens {
    fun users(): Screen
    fun user(user: GitUser): Screen
}