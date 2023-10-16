package com.example.demo

import com.example.demo.controller.HelloController
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class HelloControllerTests {

    @Autowired private val controllerHelloWorld = HelloController()

    @Test
    fun `Testing on the ControllerHelloWorld`() {
        assertThat(controllerHelloWorld).isNotNull()
        assertThat(controllerHelloWorld.helloWorld()).isEqualTo("Hello, world!")
    }
}
