package com.example.demo.datasoucre.mock

import com.example.demo.datasource.BankDataSource
import com.example.demo.model.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource : BankDataSource {
        val banks =
                        listOf(
                                        Bank("1234", 3.14, 17),
                                        Bank("1010", 17.0, 0),
                                        Bank("5678", 0.0, 100),
                        )

        override public fun retrieveBanks(): Collection<Bank> = banks
        override public fun retrieveBank(accountNumber: String): Bank =
                        banks.first() { it.accountNumber == accountNumber }
}
