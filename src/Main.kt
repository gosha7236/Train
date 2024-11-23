import kotlin.random.Random
import kotlin.random.nextInt

fun main() {
    println("Шаг 1 'Создать направление' ")
    val Sityes = listOf(
        "Санкт-Петербург",
        "Москва",
        "Бийск",
        "Барнаул",
        "Иркутск",
        "Архангельск",
        "Луга",
        "Сосновый бор",
        "Новгород",
        "Новосибирск",
        "Екатеринбург",
        "Курск",
        "Пермь",
        "Оренбург",
        "Астрахань",
    )
    var sity1 = Sityes.randomOrNull()
    println("Откуда - "+ sity1)
    var sity2 = Sityes.randomOrNull()
    while (sity2 == sity1)
        sity2 = Sityes.randomOrNull()
    println("Куда - "+ sity2)
    println("Шаг 2 'Продать билеты' ")
    var tickets = Train()
    tickets.tickets= Random.nextInt(5,201)
    println("Продано билетов: ${tickets.tickets}")
    println("Шаг 3 'Сформировать поезд' ")
    var CountWaggons = 0
    var Waggon = 0
    var CountPassagis = Train()
    while (tickets.tickets !=0 )
    {
        CountPassagis.CountPassagis = Random.nextInt(5,25)
        if ( CountPassagis.CountPassagis > tickets.tickets)
            CountPassagis.CountPassagis= tickets.tickets
        tickets.tickets -=CountPassagis.CountPassagis
        Waggon++
        CountWaggons++
        println("Количество пассажиров в ${Waggon} вагоне = ${CountPassagis.CountPassagis}")
        CountPassagis.CountPassagis= 0
    }

    println("Шаг 4 'Отправить поезд' ")
    println("Поезд по маршруту '${sity1} - ${sity2}' отправлен, состоит из ${CountWaggons} вагонов")
    println("Выберите действие ниже: \nCONTINUE - программма запустится ещё раз\nEXIT - программа завершается")
    print("Ваш выбор: ")
    var vybor = readln().uppercase()
    when(vybor)
    {
        "EXIT"-> return
        "CONTINUE"-> main()
    }
}
class Train() {
    var CountPassagis = 0
        get() {
            if ((field > 4) || (field < 26)) {
                return field
            } else
               return Random.nextInt(5, 25)
        }
    var tickets= 0
        get() {
            if ((field > 4) || (field < 202)) {
                return field
            } else
                return Random.nextInt(5, 201)
        }
}
