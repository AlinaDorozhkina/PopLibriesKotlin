package ru.alinadorozhkina.mvp.mvp.presenter

import ru.alinadorozhkina.mvp.mvp.model.CounterModel
import ru.alinadorozhkina.mvp.mvp.view.MainView

class MainPresenter(private val view: MainView) {

    private val model = CounterModel()

    fun clickButton1() {
        val nextValue = model.next(0)
        view.setButton1Text(nextValue.toString())
    }

    fun clickButton2() {
        val nextValue = model.next(1)
        view.setButton2Text(nextValue.toString())
    }

    fun clickButton3() {
        val nextValue = model.next(2)
        view.setButton3Text(nextValue.toString())
    }
}