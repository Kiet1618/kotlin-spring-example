package com.example.demo

import com.example.demo.datasoucre.mock.MockBankDataSource
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class MockBankDataSoucreTests {

    @Autowired private lateinit var mockBankDataSource: MockBankDataSource

    @Test
    fun `should provide a collection of banks`() {
        // given

        // when
        val banks = mockBankDataSource.getBanks()

        // then
        assertThat(banks).isNotEmpty
        assertThat(banks.size).isGreaterThanOrEqualTo(3)
    }
}
