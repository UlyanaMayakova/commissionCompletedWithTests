import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calculateCommission_forMasterCard() {
        val thisCard = 2
        val thisMoneySent = 100 * 100
        val thisMoney = 1000 * 100

        val result = calculateCommission(
            card = thisCard,
            moneySent = thisMoneySent,
            money = thisMoney
        )

        assertEquals("Комиссия составила 7 рублей", result)
    }
}