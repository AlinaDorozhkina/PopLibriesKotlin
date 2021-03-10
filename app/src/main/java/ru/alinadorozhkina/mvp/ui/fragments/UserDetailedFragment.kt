package ru.alinadorozhkina.mvp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.alinadorozhkina.mvp.databinding.FragmentUserDetailedBinding
import ru.alinadorozhkina.mvp.mvp.model.entity.GitUser
import ru.alinadorozhkina.mvp.mvp.presenter.UserDetailedPresenter
import ru.alinadorozhkina.mvp.mvp.view.UserDetailedView

private const val USER_VALUE = "user value"

class UserDetailedFragment : MvpAppCompatFragment(), UserDetailedView {

    companion object {
        fun newInstance(user: GitUser): UserDetailedFragment {
            val args = Bundle()
            args.putParcelable(USER_VALUE, user)
            val f = UserDetailedFragment()
            f.arguments = args
            return f
        }
    }

    private var ui: FragmentUserDetailedBinding? = null

    private val user: GitUser?
        get() = arguments?.getParcelable(USER_VALUE)

    private val presenter by moxyPresenter { UserDetailedPresenter(user) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUserDetailedBinding.inflate(inflater, container, false).also {
        ui = it
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        ui = null
    }

    override fun setUserLogin(login: String) {
        ui?.tvUserLogin?.text = login
    }
}