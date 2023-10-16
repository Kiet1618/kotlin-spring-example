package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/hello")
class ControllerHelloWorld {

    @GetMapping
    fun helloWorld(): String {
        return "Hello, world!"
    }
}

// Controller viet code j
// Service viet code j
// Duoi Service la Repository
// unit test la gi
// the nao la unit test va khong phai la unit test
// tai sao lai chia ra 3 Controller, Service, Repository
