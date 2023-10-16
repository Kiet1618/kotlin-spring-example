package com.example.demo

import com.example.demo.datasource.BankDataSource
import com.example.demo.service.BankService
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class BankServiceTest {

    private val dataSource: BankDataSource = mockk(relaxed = true)
    private val bankService: BankService = BankService(dataSource)

    @Test
    fun `should call its data source to get banks`() {
        // given
        // every { dataSource.retrieveBanks() } returns emptyList()
        // when
        bankService.getBanks()
        // then
        verify(exactly = 1) { dataSource.retrieveBanks() }
    }
}
