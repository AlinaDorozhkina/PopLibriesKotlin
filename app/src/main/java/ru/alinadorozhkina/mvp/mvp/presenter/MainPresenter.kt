package ru.alinadorozhkina.mvp.mvp.presenter

import ru.alinadorozhkina.mvp.mvp.model.CounterModel
import ru.alinadorozhkina.mvp.mvp.view.MainView

class MainPresenter(private val view: MainView) {

    private val model = CounterModel()

    fun getButton1Value() {
        val nextValue = model.next(0)
        view.setButton1Text(nextValue.toString())
    }

    fun getButton2Value() {
        val nextValue = model.next(1)
        view.setButton2Text(nextValue.toString())
    }

    fun getButton3Value() {
        val nextValue = model.next(2)
        view.setButton3Text(nextValue.toString())
    }
}