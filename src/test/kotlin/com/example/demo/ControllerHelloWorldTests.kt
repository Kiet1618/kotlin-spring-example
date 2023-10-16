package com.example.demo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ControllerHelloWorldTests {

    @Autowired private lateinit var controllerHelloWorld: ControllerHelloWorld

    @Test
    fun `Testing on the ControllerHelloWorld`() {
        assertThat(controllerHelloWorld).isNotNull()
        assertThat(controllerHelloWorld.helloWorld()).isEqualTo("Hello, world!")
    }
}
