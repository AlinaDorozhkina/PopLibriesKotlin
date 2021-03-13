package ru.alinadorozhkina.mvp

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.TestScheduler
import java.util.concurrent.TimeUnit
import kotlin.random.Random

/**
 * SwitchMap vs FlatMap
 * SwitchMap лучше всего подходит, когда необходимо проигнорировать промежуточные результаты и
 * оставить последний. SwitchMap отписывается от предыдущего источника Observable, когда новый
 * элемент отдает данные.
 * FlatMap из каждого элемента создает Observable , после чего выполняет слияние этих источников ,
 * не поддерживая порядок исходящих элементов.
 */

class Testing {

    fun exec() {
        Consumer(Producer()).execFlatMap() // вывод в консоль I/System.out: OnNext flatMap [2x, 1x, 3x, 4x]
        Consumer(Producer()).execSwitchMap() //вывод в консоль I/System.out: OnNext SwitchMap [4x]
    }

    class Producer {
        fun just(): Observable<String> = Observable.just("1", "2", "3", "4")
    }

    class Consumer(val producer: Producer) {

        fun execFlatMap() {
            val testScheduler = TestScheduler()
            producer.just().flatMap {
                val delay = Random.nextInt(10).toLong()
                return@flatMap Observable.just(it + 'x')
                    .delay(delay, TimeUnit.SECONDS, testScheduler)
            }
                .toList()
                .subscribe({ list ->
                    println("OnNext flatMap $list")
                }, {
                    println("onError flatMap${it.message}")
                })
            testScheduler.advanceTimeBy(1, TimeUnit.MINUTES)
        }

        fun execSwitchMap() {
            val testScheduler = TestScheduler()
            producer.just().switchMap {
                val delay = Random.nextInt(10).toLong()
                return@switchMap Observable.just(it + 'x')
                    .delay(delay, TimeUnit.SECONDS, testScheduler)
            }
                .toList()
                .subscribe({ list ->
                    println("OnNext SwitchMap $list")
                }, {
                    println("onError SwitchMap ${it.message}")
                })
            testScheduler.advanceTimeBy(1, TimeUnit.MINUTES)
        }
    }
}