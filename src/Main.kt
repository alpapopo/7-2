import kotlin.system.exitProcess

fun selectAddService(currentPizzaCity: PizzaCity) {
    if (currentPizzaCity is checkPhoto) currentPizzaCity.showCheckPhoto()
    if (currentPizzaCity is Drink) currentPizzaCity.drinkSale()
}

private fun selectPizza(currentPizzaCity: PizzaCity) {
    when (readln()) {
        "1" -> {
            currentPizzaCity.neapolitanPizzaSale()
            selectAddService(currentPizzaCity)
        }

        "2" -> {
            currentPizzaCity.romanPizzaSale()
            selectAddService(currentPizzaCity)
        }

        "3" -> {
            currentPizzaCity.sicilianPizzaSale()
            selectAddService(currentPizzaCity)
        }

        "4" -> {
            currentPizzaCity.tyroleanPizzaSale()
            selectAddService(currentPizzaCity)
        }

        "0" -> currentPizzaCity.showStatistics()

        else -> {
            println("ERROR")
            exitProcess( 1)
        }
    }
}

fun main() {
    val pizzaPeter = PizzaPeter(
        175.0,  241.5,
        167.5,  215.0
    )

    val pizzaMoscow = PizzaMoscow(
         215.0,  250.5,
         189.5,  240.0
    )
    val pizzaNovosibirsk = PizzaNovosibirsk(
        200.0, 230.0,
        180.0, 220.0,
        30.0, 45.0
    )


    var currentPizzaCity: PizzaCity

    while (true) {
        println("Добрый день! Выберите город")
        println("1. Москва\n2. Санкт-Петербург\n3. Новосибирск\n0. Выход из программы")

        currentPizzaCity = when (readln()) {
            "1" -> pizzaMoscow
            "2" -> pizzaPeter
            "3" -> pizzaNovosibirsk
            "0" -> break
            else -> {
                println("ERROR")
                continue
            }
        }

        println("Выберите пиццу:")
        println(
            "1. Неаполитанская пицца\n2. Римская пицца\n3. Сицилийская пицца\n" +
                    "4. Тирольская пицца\n\n0. Показать статистику"
        )

        selectPizza(currentPizzaCity)
    }
}
