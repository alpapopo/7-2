class PizzaNovosibirsk(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double,
    private val sauce1Price: Double = 30.0,
    private val sauce2Price: Double = 45.0
) : PizzaCity(
    neapolitanPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice
), checkPhoto, Drink {

    var currentPizzaType: String? = null

    override fun showCheckPhoto() {
        println("У вас есть фотография чека?")
        println("1. Да\n2. Нет")
        if (readln() == "1") {
            checkShownCount++
            totalDiscounts += 50.0
            println("Вам будет скидка 50 рублей с покупки")
        } else {
            checkNotShownCount++
        }
    }

    override fun drinkSale() {
        println("Вы будете кофе?")
        println("1. Да\n2. Нет")
        coffeeOfferedCount++
        if (readln() == "1") {
            coffeeSoldCount++
            coffeeRevenue += 200.0
            when (currentPizzaType) {
                "neapolitan" -> coffeeWithNeapolitan++
                "roman" -> coffeeWithRoman++
                "sicilian" -> coffeeWithSicilian++
                "tyrolean" -> coffeeWithTyrolean++
            }
            println("С вас 200 рублей")
        }
    }


    private fun selectSauce() {
        println("Выберите соус к пицце:")
        println("1. Соус BBQ ($sauce1Price рублей)")
        println("2. Чесночный соус ($sauce2Price рублей)")
        val choice = readln()
        when (choice) {
            "1" -> {
                sauce1Count++
                sauce1Revenue += sauce1Price
                println("Вы выбрали соус BBQ за $sauce1Price рублей")
            }
            "2" -> {
                sauce2Count++
                sauce2Revenue += sauce2Price
                println("Вы выбрали чесночный соус за $sauce2Price рублей")
            }
            else -> {
                println("Соус не выбран")
            }
        }
    }



    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
        currentPizzaType = "neapolitan"
        println("Спасибо за покупку неаполитанской пиццы в Новосибирске")
        selectSauce()
    }

    override fun romanPizzaSale() {
        romanPizzaCount++
        currentPizzaType = "roman"
        println("Спасибо за покупку римской пиццы в Новосибирске")
        selectSauce()
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        currentPizzaType = "sicilian"
        println("Спасибо за покупку сицилийской пиццы в Новосибирске")
        selectSauce()
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        currentPizzaType = "tyrolean"
        println("Спасибо за покупку тирольской пиццы в Новосибирске")
        selectSauce()
    }
}
