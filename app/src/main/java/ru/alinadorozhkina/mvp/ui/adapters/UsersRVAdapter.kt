package ru.alinadorozhkina.mvp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.alinadorozhkina.mvp.databinding.ItemViewBinding
import ru.alinadorozhkina.mvp.mvp.presenter.list.IUserListPresenter
import ru.alinadorozhkina.mvp.mvp.view.list.IUserItemView

class UsersRVAdapter(val presenter: IUserListPresenter) :
    RecyclerView.Adapter<UsersRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
        }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        presenter.bindView(holder.apply {
            pos = position
        })


    override fun getItemCount() = presenter.getCount()

    inner class ViewHolder(val vb: ItemViewBinding) : RecyclerView.ViewHolder(vb.root),
        IUserItemView {

        override var pos = -1

        override fun setLogin(text: String) = with(vb) {
            tvLogin.text = text
        }
    }
}