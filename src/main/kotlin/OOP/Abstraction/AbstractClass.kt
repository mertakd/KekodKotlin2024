package OOP.Abstraction

/**
 * Abstract class lar bir şözleşme. temel prensipleri içermesi lazım, ayrıntılar olmaması lazım. İnsan örneği.
   Abastract class lar en tepe de spesific bilgilee sahip olmayan, sadece nelere sahip olduğumuzu söyleyen yapılardır.
 * Abstract class lar inherit edilen yapılardır. yani final olamıyorlar, mutlaka miras alınması gereken sınıflar
 * cosntructor u olsa bile nesnesi oluşturulamaz.
 * constructor kullanma nedeni: bir tool a event paslamak istiyor olbiliriz(firebase analytics)
   test edilebilmesi için abastract class içinde instance si oluşturulmamalı. bunun yerine abstract class ın construtorında yazılmalı.
   Yani constructor in nesne oluşturma görevinden sonra ikinci görevi, bu abstract class ımızın inject etmesi gereken başka bir class varsa, onu constroctor dan verebiliyoruz.
 * abstract bir property bir değer alamıyorken, open bir property default bir değer alıyor
 * */

class EventManager {
    fun sendEvent(name: String) {
        TODO("Not yet implemented")
    }
}

abstract class Human(val name:String, val eventManager: EventManager){

    // val eventManager = EventManager()  yapılmamalı
    // constructor(name: String, age:Int) : this(name){}

    abstract val surName: String
    open val age: Int = 34
    val eyeColor:String = "blue"


    fun sendEvent(){
        eventManager.sendEvent(name)
    }

    open fun getEventType(){
        eventManager.sendEvent(name)
    }


    abstract fun display()

}


fun main() {
    //val human = Human("Arkhu", 18)
}