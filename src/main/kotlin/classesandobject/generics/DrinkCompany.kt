package com.shaikhabdulgani.classesandobject.generics

import java.util.UUID

open class Drink {
    fun drink() {
        println("drink")
    }
}

open class ColdDrink : Drink()
open class WarmDrink : Drink()

open class Lemonade : ColdDrink()
open class Cola : ColdDrink()

open class Tea : WarmDrink()
open class Coffee : WarmDrink()

open class Box

open class CardboardBox : Box()
open class PlasticBox : Box()

open class FamilyBox : CardboardBox()
open class DeluxeBox : PlasticBox()

//class DrinkService<DRINK : Drink,  BOX : Box> {
class DrinkService<in D : Drink, out B : Box> {
    val database by lazy { HashMap<UUID, Drink>() }

    fun sendDrink(drink: D) {
        database[UUID.randomUUID()] = drink
    }

    fun getBox(createBox: (Drink) -> Box): B {
        check(database.size > 0) { "0 drink left" }
        return createBox(database.remove(database.keys.last())!!) as B
    }

}

//fun verifyDrinkService(drink: DrinkService<Drink, Box>) {
//    println("verifying")
//}

fun checkCoolerState(drink: DrinkService<ColdDrink, Box>) {
    println("Checking cooler state")
}

fun checkResistanceState(drink: DrinkService<WarmDrink, Box>) {
    println("checking Resistance State")
}

fun main() {
    var warmDrinkService = DrinkService<WarmDrink, DeluxeBox>()
    var coldDrinkService = DrinkService<ColdDrink, FamilyBox>()

    warmDrinkService.sendDrink(Tea())
    warmDrinkService.sendDrink(Coffee())
    warmDrinkService.getBox { FamilyBox() }
    warmDrinkService.getBox { DeluxeBox() }

    coldDrinkService.sendDrink(Cola())
    coldDrinkService.sendDrink(Lemonade())
    coldDrinkService.getBox { DeluxeBox() }
    coldDrinkService.getBox { FamilyBox() }

    checkCoolerState(coldDrinkService)
    checkResistanceState(warmDrinkService)

    var genericDrinkService = DrinkService<Drink, Box>()
    checkCoolerState(genericDrinkService)
    checkResistanceState(genericDrinkService)

//    verifyDrinkService(coldDrinkService)
//    verifyDrinkService(warmDrinkService)
//    verifyDrinkService(genericDrinkService)
}








































//package com.shaikhabdulgani.classesandobject.generics
//
//import java.util.UUID
//
//open class Drink {
//    fun drink() {
//        println("drink")
//    }
//}
//
//open class ColdDrink : Drink()
//open class WarmDrink : Drink()
//
//open class Lemonade : ColdDrink()
//open class Cola : ColdDrink()
//
//open class Tea : WarmDrink()
//open class Coffee : WarmDrink()
//
//open class Box<out T : Drink>(val drink: T) {
//    fun packDrink(): Box<T> {
//        println("packDrink")
//        return this
//    }
//
//    fun getDrink(): T {
//        return drink
//    }
//}
//
//open class CardboardBox<T : Drink>(drink: T) : Box<T>(drink)
//open class PlasticBox<T : Drink>(drink: T) : Box<T>(drink)
//
//open class FamilyBox<T : Drink>(drink: T) : CardboardBox<T>(drink)
//open class DeluxeBox<T : Drink>(drink: T) : PlasticBox<T>(drink)
//
////class DrinkService<DRINK : Drink,  BOX : Box> {
//class DrinkService<in DRINK : Drink, out BOX : Box<Drink>> {
//    val database by lazy { HashMap<UUID, Drink>() }
//
//    fun sendDrink(drink: DRINK) {
//        database[UUID.randomUUID()] = drink
//    }
//
//    fun getBox(createBox: (Drink) -> Box<Drink>): BOX {
//        check(database.size > 0) {
//            "0 drink left"
//        }
//        return createBox(database.remove(database.keys.last())!!).packDrink() as BOX
//    }
//
//}
//
//fun verifyDrinkService(drink: DrinkService<Drink, Box<Drink>>) {
//    println("verifying")
//}
//
//fun checkCoolerState(drink: DrinkService<ColdDrink, Box<ColdDrink>>) {
//    println("Checking cooler state")
//}
//
//fun checkResistanceState(drink: DrinkService<WarmDrink, Box<WarmDrink>>) {
//    println("checking Resistance State")
//}
//
//fun classesandobject.classes.main() {
//    var warmDrinkService = DrinkService<WarmDrink, DeluxeBox<WarmDrink>>()
//    var coldDrinkService = DrinkService<ColdDrink, FamilyBox<ColdDrink>>()
//    var genericDrinkService = DrinkService<Drink, Box<Drink>>()
//
//    warmDrinkService.sendDrink(Tea())
//    warmDrinkService.getBox { drink: Drink -> Box(drink) }
//
//    checkCoolerState(coldDrinkService)
//    checkResistanceState(warmDrinkService)
//
//    checkCoolerState(genericDrinkService)
//    checkResistanceState(genericDrinkService)
//
//    verifyDrinkService(coldDrinkService)
//    verifyDrinkService(warmDrinkService)
//}