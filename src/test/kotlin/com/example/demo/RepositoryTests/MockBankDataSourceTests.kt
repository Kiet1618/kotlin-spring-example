package com.example.demo

import com.example.demo.datasoucre.mock.MockBankDataSource
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class MockBankDataSoucreTests {

    @Autowired private val mockBankDataSource: MockBankDataSource = MockBankDataSource()

    @Test
    fun `should provide a collection of banks`() {
        // given

        // when
        val banks = mockBankDataSource.retrieveBanks()

        // then
        assertThat(banks).isNotEmpty
        assertThat(banks.size).isGreaterThanOrEqualTo(3)
    }

    @Test
    fun `should provide some mock data`() {
        // when
        val banks = mockBankDataSource.retrieveBanks()

        // then
        // assertThat(banks).isNotEmpty
        // assertThat(banks.size).isGreaterThanOrEqualTo(3)
        assertThat(banks).allMatch { it.accountNumber.isNotBlank() }
        assertThat(banks).anyMatch { it.trust != 0.0 }
        assertThat(banks).anyMatch { it.transactionFee != 0 }
    }
}
