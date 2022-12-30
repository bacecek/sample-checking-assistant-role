package org.example.dependency

import com.yandex.yatagan.Module

object Side2 {
    @Module(subcomponents = [Enclosing.Main::class])
    interface Main
}