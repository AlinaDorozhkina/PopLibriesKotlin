package ru.alinadorozhkina.mvp.mvp.presenter.list

interface IListPresenter<V> {
    var itemClickListener: ((V) -> Unit)?

    fun bindView(view: V)
    fun getCount(): Int
}