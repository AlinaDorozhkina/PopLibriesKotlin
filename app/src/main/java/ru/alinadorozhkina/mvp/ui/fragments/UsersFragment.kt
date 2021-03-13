package ru.alinadorozhkina.mvp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.alinadorozhkina.mvp.databinding.FragmentUsersBinding
import ru.alinadorozhkina.mvp.mvp.model.GitHubUsersRepo
import ru.alinadorozhkina.mvp.mvp.presenter.UsersPresenter
import ru.alinadorozhkina.mvp.mvp.view.UsersView
import ru.alinadorozhkina.mvp.ui.App
import ru.alinadorozhkina.mvp.ui.BackClickListener
import ru.alinadorozhkina.mvp.ui.adapters.UsersRVAdapter
import ru.alinadorozhkina.mvp.ui.navigation.AndroidScreens

class UsersFragment : MvpAppCompatFragment(), UsersView, BackClickListener {

    companion object {
        fun newInstance() = UsersFragment()
    }

    private val presenter by moxyPresenter {
        UsersPresenter(
            GitHubUsersRepo(),
            App.instance.router,
            AndroidScreens()
        )
    }

    private var ui: FragmentUsersBinding? = null

    private var adapter: UsersRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUsersBinding.inflate(inflater, container, false).also {
        ui = it
    }.root

    override fun init() {
        ui?.rvUsers?.layoutManager = LinearLayoutManager(requireContext())
        ui?.rvUsers?.addItemDecoration((DividerItemDecoration(requireActivity(), LinearLayoutManager.VERTICAL)))
        adapter = UsersRVAdapter(presenter.usersListPresenter)
        ui?.rvUsers?.adapter = adapter
    }

    override fun updateList() {
        ui?.rvUsers?.adapter?.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        ui = null
        presenter.dispose()
    }

    override fun backPressed() = presenter.backClicked()
}