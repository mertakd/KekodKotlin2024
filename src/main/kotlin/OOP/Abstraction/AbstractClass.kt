package OOP.Abstraction

/**
 * Abstract class lar bir şözleşme. temel prensipleri içermesi lazım, ayrıntılar olmaması lazım. İnsan örneği.
   Abastract class lar en tepe de spesific bilgilee sahip olmayan, sadece nelere sahip olduğumuzu söyleyen yapılardır.
 * Abstract class lar inherit edilen yapılardır. yani final olamıyorlar, mutlaka miras alınması gereken sınıflar
 * abstract class lar open kullanılmasının bir gereği yok, zaten abstract keyword un aynımanaya geliyor.
 * cosntructor u olsa bile nesnesi oluşturulamaz.
 * constructor kullanma nedeni: bir tool a event paslamak istiyor olbiliriz(firebase analytics)
   test edilebilmesi için abastract class içinde instance si oluşturulmamalı. bunun yerine abstract class ın construtorında yazılmalı.
   Yani constructor in nesne oluşturma görevinden sonra ikinci görevi, bu abstract class ımızın inject etmesi gereken başka bir class varsa, onu constroctor dan verebiliyoruz.
 * abstract bir property bir değer alamıyorken, open bir property default bir değer alıyor
 * Abstract class ların member ları mutlaka override edilmesi zorunlu denir iş görüşmelerinde.
   Ama bu doğru değil, abstract bir class ın içinde open fonksiyon, open değişken varsa override edilmek zorunlu değil. içinde düz bir değişken varsa yine override dilmek zorunda değil.
   Tüm bu değişkenleri fonksiyonları tutabildiğimiz için state tutabildiğimiz manasına gelir bu.
 * abstract class ın içinde ki abstract olan değişken ve fonksiyon mutlaka override edilmek zorunda.
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
    abstract val middleName:String
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



/**
 * Turk class ında override edilecek değişken vs constructor da değil de içeri de yazılacak sa bir değer istiyor. ama constroctor de yazılacaksa bir değer vermeyebiliriz(istersek constroctor da default bir değer de atayabiliriz.)
   constroctor da değer vermiyoruz, bu constroctor da ki değişken nesne oluşturulurken bir değer atanabilir.
 * bir değer abstract olursa isterse constroctor da ister sınıfın bir üyesi olsun override edilmek zorunda
 * burada age ve getEventType open olduğu için override etmek isteğe bağlıdır.
 * surName -> abstract olarak yazıldığı yerde backing field yok ama child class da bunun backing field ı oluşturulmuş oluyor.
 * abstract classlar başka abstract class ları miras alabilir.
   eğer bir abstract class başka bir abstract class ı miras alıyorsa, bu durumda üst class dan gelen override edilmesi zorunlu olan abstract değişken ve fonksiyonların override edilme zorunluluğu ortadan kalkıyor. iki sınıfta abstract olduğu için.
 * open class abstract class ı miras alıyorsa, abstract class ta ki abstract değişken fonksiyon vs implement etmesi gerekir
 * abstract property veya fonksiyon final yapılmaz, override edilmişse final yapılabilir.
 * body si olan fonksiyonlara tamamlanmış fonksiyonlar deniliyor
 * abstract vbir property saddece abstract class larda kullanılabiliyor. open,final class içinde hata verir.
   */


abstract class Turk(eventManager: EventManager, override val middleName: String ): Human("Turk",eventManager){

    abstract val skinColor:String
    override val surName: String= "asdasd"
    //final override val surName: String= "asdasd"    override edilmişse final olabilir.



}


//open class Kurt(eventManager: EventManager):Human("Kurt", eventManager){}
open class Kurt(eventManager: EventManager, override val middleName: String):Human("Kurt", eventManager){

    //abstract val blalal:String = "asdasd"
    override val surName: String= "adsasds"
    override fun display() {
        TODO("Not yet implemented")
    }

}



/**
 * Childe class yukarıda ne kadar abstract class varsa, yukarı da ki abstract class ların abstract property ve fonksiyonlarını implement etme zorunda
 * human abstract class ında anbstract surname Turk abstract class ında override edilmişse, Adana class ın da bu değeri override etmemize gerek kalmıyor.
 *
 * */
class Adana(): Turk(eventManager = EventManager(), "middleName"){

    override val skinColor: String
        get() = TODO("Not yet implemented")

    override fun display() {
        TODO("Not yet implemented")
    }


}