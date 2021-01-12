import kotlin.math.roundToInt

fun main() {
//    println(
//        """
//        Выберите тип Вашей карты (введите число от 1 до 3):
//        1. Mastercard или Maestro
//        2. Visa или Мир
//        3. VK Pay
//        """
//    )

    val card = 1
    val moneySent = 100 * 100
    val money = 1000 * 100

    calculateCommission(card, moneySent, money)
}

fun calculateCommission(card: Int, moneySent: Int, money: Int): String {
//    card = readLine()!!.toInt()

//    println("Введите сумму переводов в этом месяце")
//    val moneySent = readLine()!!.toInt() * 100
    return if (moneySent > 600_000 * 100) {
        ("Превышен лимит суммы отправки за месяц")
    } else {
//        println("Введите сумму перевода")
//        val money = readLine()!!.toInt() * 100
        if (card == 2 && money < 35 * 100) {
            ("Возможен перевод только от 35 рублей")
        } else {
            val userCommission = cardType(card, money, moneySent)
            val commission = userCommission / 100
            ("Комиссия составила $commission рублей")
        }
    }
}

fun cardType(card: Int = 3, money: Int, moneySent: Int = 0): Int {
    return when (card) {
        1 -> masterMaestroCommission(money, moneySent)
        2 -> visaMirCommission(money)
        else -> vkPayCommission()
    }
}

fun masterMaestroCommission(money: Int, moneySent: Int): Int {
    return when {
        moneySent < 75_000 * 100 -> 0
        else -> {
            val userCommission = (money * 0.006 + 20 * 100).roundToInt()
            userCommission
        }
    }
}

fun visaMirCommission(money: Int): Int {
    val commission = 0.0075
    return (money * commission).roundToInt()
}

fun vkPayCommission(): Int {
    return 0
}