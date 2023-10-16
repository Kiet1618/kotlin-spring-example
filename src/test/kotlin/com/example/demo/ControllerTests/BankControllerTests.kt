package com.example.demo

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
internal class BankControllerTests {

    @Autowired lateinit var mockMvc: MockMvc

    @Nested
    @DisplayName(value = "getBanks()")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetBanks {
        @Test
        fun `should return all banks`() {
            // given
            // when/then
            mockMvc.get("/api/banks").andDo { print() }.andExpect {
                status { isOk() }
                content { contentType("application/json") }
                jsonPath("$[0].accountNumber") { value("1234") }
            }
        }
    }

    @Nested
    @DisplayName(value = "getBank(accountNumber: String)")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetBank {
        @Test
        fun `should return the bank with the given account number`() {
            // given

            val accountNumber = 1234

            // when/then

            mockMvc.get("/api/banks/$accountNumber").andDo { print() }.andExpect {
                status { isOk() }
                content { contentType("application/json") }
                jsonPath("$.trust") { value("3.14") }
                jsonPath("$.transactionFee") { value("17") }
            }
        }
    }
}
