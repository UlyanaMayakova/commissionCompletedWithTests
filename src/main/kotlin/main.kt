import kotlin.math.roundToInt

fun main() {

    println(
        """
        Выберите тип Вашей карты (введите число от 1 до 3):
        1. Mastercard или Maestro
        2. Visa или Мир
        3. VK Pay
        """
    )
    val card: Int = readLine()!!.toInt()

    println("Введите сумму переводов в этом месяце")
    val moneySent = readLine()!!.toInt() * 100
    if (moneySent > 600_000 * 100) {
        println("Превышен лимит суммы отправки за месяц")
    } else {
        println("Введите сумму перевода")
        val money = readLine()!!.toInt() * 100
        cardType(card, money)
    }
}

fun cardType(card: Int = 3, money: Int, moneySent: Int = 0) {
    return when (card) {
        1 -> masterMaestroCommission(money, moneySent)
        2 -> visaMirCommission(money)
        else -> vkPayCommission()
    }
}

fun masterMaestroCommission(moneySent: Int, money: Int) {
    when {
        moneySent < 75_000 * 100 -> println("Комиссия не взимается")
        else -> {
            val userCommission = (money * 0.006 + 20 * 100).roundToInt().toDouble() / 100
            println("Комиссия: $userCommission рублей")
        }
    }
}

fun visaMirCommission(money: Int) {
    val commission = 0.0075
    val minimalSum = 3500
    val userCommission: Double

    if (money >= minimalSum) {
        userCommission = (money * commission).roundToInt().toDouble() / 100
        println("Сумма комиссии $userCommission рублей")
    } else {
        println("Возможен перевод только от 35 рублей")
    }
}

fun vkPayCommission() {
    println("Комиссия не взимается")
}