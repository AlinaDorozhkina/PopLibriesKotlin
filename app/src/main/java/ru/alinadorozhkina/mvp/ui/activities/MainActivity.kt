package ru.alinadorozhkina.mvp.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.alinadorozhkina.mvp.databinding.ActivityMainBinding
import ru.alinadorozhkina.mvp.mvp.model.CounterModel
import ru.alinadorozhkina.mvp.mvp.presenter.MainPresenter
import ru.alinadorozhkina.mvp.mvp.view.MainView

class MainActivity : MvpAppCompatActivity (), MainView {

    private val presenter  by moxyPresenter { MainPresenter(CounterModel()) }

    private val ui: ActivityMainBinding
            by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ui.root)

        ui.button1.setOnClickListener { presenter.clickButton1() }
        ui.button2.setOnClickListener { presenter.clickButton2() }
        ui.button3.setOnClickListener { presenter.clickButton3() }
    }

    override fun setButton1Text(text: String) {
        ui.button1.text = text
    }

    override fun setButton2Text(text: String) {
        ui.button2.text = text
    }

    override fun setButton3Text(text: String) {
        ui.button3.text = text
    }
}