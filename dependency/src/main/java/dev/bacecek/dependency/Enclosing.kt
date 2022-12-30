package org.example.dependency

import com.yandex.yatagan.Component

interface Enclosing {
    interface Builder

    @Component(isRoot = false, modules = [Side.Main::class])
    interface Main : Enclosing {
        val hello: String

        @Component.Builder
        interface Builder : Enclosing.Builder {
            fun create(): Main
        }
    }
}