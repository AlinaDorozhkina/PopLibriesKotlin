package ru.alinadorozhkina.mvp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.alinadorozhkina.mvp.databinding.ActivityMainBinding
import ru.alinadorozhkina.mvp.mvp.presenter.MainPresenter
import ru.alinadorozhkina.mvp.mvp.view.MainView

class MainActivity : AppCompatActivity(), MainView {

    private val presenter = MainPresenter(this)

    private val ui: ActivityMainBinding
            by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ui.root)

        ui.button1.setOnClickListener {
            presenter.getButton1Value()
        }

        ui.button2.setOnClickListener {
            presenter.getButton2Value()
        }

        ui.button3.setOnClickListener {
            presenter.getButton3Value()
        }
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