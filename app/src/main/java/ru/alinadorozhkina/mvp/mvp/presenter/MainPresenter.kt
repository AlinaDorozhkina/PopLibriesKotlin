package ru.alinadorozhkina.mvp.mvp.presenter

import moxy.MvpPresenter
import ru.alinadorozhkina.mvp.mvp.model.CounterModel
import ru.alinadorozhkina.mvp.mvp.view.MainView

class MainPresenter(val model: CounterModel): MvpPresenter<MainView>() {

    fun clickButton1() {
        val nextValue = model.next(0)
        viewState.setButton1Text(nextValue.toString())
    }

    fun clickButton2() {
        val nextValue = model.next(1)
        viewState.setButton2Text(nextValue.toString())
    }

    fun clickButton3() {
        val nextValue = model.next(2)
        viewState.setButton3Text(nextValue.toString())
    }
}