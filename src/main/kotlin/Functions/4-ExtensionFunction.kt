package Functions

/**
 *  Bu dünyayı çekilebilie kılan şeylerin başında gelir Extension Functions
 *
 *  Üzerinden değişiklik yapamadığımız (readonly) sınıflara , ya da yapmak istediğimiz sınıflara, bu sınıflarlar
    içerisinde yazmadan fonksiyon tanımlayabilmemizi sağlar.
    Örneğin Double normal de readonly ama ek özellik ekleyebiliriz. Yada çok uzun bir Dasboard sınıfı var, bu sınıfa ek bir extension ekleyebilirz.
    Kısaca değiştiremediğin ya da değiştirebilsen de  üzerine eklemek istemediğin class lara ekleme yapabilmeni sağlatan fonksiyondur.
 * Arka planda birşey değişmiyor. Bir class a extension function yazdığımız da o class ın üye fonksiyonu oluyor. biz bunu ön planda görmüyoruz sadece.
   O yüzden artı veya eksi anlamda bir performansa etkisi yok.Ama gerçekten çok daha yöenetilebilir kodlar yazmamıza neden oluyor.
   Ayrıca test yazmayı çok kolaylaştırıyor.
 * Receiver diye adlandıracağımız bir sınıfa ihtiyaç duyar. Extension yazacağımız sınıfı ifade eder Receiver tanımı
 *
 * fun String.extPrint(handsomeValue: HandsomeOne): Unit{
 *
 * }
 * bu fonksiyonda String sınıfı veriliyor. bu sınıfın tabirine receiver(alıcı) da deniliyor.
 *
 * Arka planda Extension Fonksiyon Statik bir fonksiyondur.
   Eskiden java da extension fonksiyon yazmak için statik bir fonksiyon oluşturuluyor, ilk parametre hangi class ı extend etmek istineiyorsa o class ın instance içeriyordu.ikinci parametre de kullanmak istediğimiz parametre yi temsil ediyordu.
 * */


fun main4() {


    val number1 = "5"
    val number2 = "10"

    val result = number1.extPlus(number2)
    println("Total: $result")

    val resultInfix = number1 extPlusInfix number2
    println("Total: $resultInfix")

}

    fun String.extPlus(otherString: String): Int = this.toInt() + otherString.toInt()

    infix fun String.extPlusInfix(otherString: String): Int = this.toInt() + otherString.toInt()







fun main() {

    //normalde değişkenlere değer atayıp, print işlemini aşağıdakiler gibi yaparız. ama burada gereksiz println() fonksiyonunu sürekli kullanıyoruz. o yüzden buan extension fonsiyon yazılabilir.
    val pi: Double = 3 + 0.14
    println("Double number : $pi")

    val schoolNumber: Int = 1341
    println("Int Number : $schoolNumber")

    val tcIdentityNumber: Long = 186608268888
    println("Long Number : $tcIdentityNumber")


    log2(pi)
    log2(schoolNumber)
    log2(tcIdentityNumber)



    //Extension Fonksiyonun farkı
    log2b(pi,"Double Number:")
    log2b(schoolNumber,"Int Number:")
    log2b(tcIdentityNumber,"Long Number:")


    pi.log("Double Number:")
    schoolNumber.log("Int Number:")
    tcIdentityNumber.log("Long Number:")


}


fun log2(number: Number){
    println(number)
}




//Extension Fonksiyonun farkı
fun log2b(number: Number, message:String){
    println("$message $number")
}

//yukarıda ki fonksiyonda number ı sınıf olarak dışarı çıkarıp extend et, aşağıda ki extension funksiyona çevir. ikisi aynı şeyi yapıyor ama aşağıda ki daha kısa yoldan yapıyor.
// bu şekilde extension fonksiyonla oop yapısnın dışına çıkmış daha özgür hale geliyorsunuz, yani class ın üye fonksiyonu olarak göstermiyoruz. Bu fonksiyonu bir sınıfa bağlı kalmadan istediğiniz yerde kullanabiliyorsunuz. BU bir fonksiyonel programlama yaklaşımı
//extension fonksiyonu bir class ın içinde yazıyorsak artık global olarak kullanamayız. ama extension fonksiyonu top level bir fonksiyon olarak yazarsak global olarak kullanabilirz.
infix fun Number.log(emptyParam: String) {
    println(emptyParam + this)
}







open class Shape {

    private var intNumber = 0

    fun setNumber(intNumber: Int){
        this.intNumber = intNumber
    }



    fun main(){
        intNumber.exToString()
        intNumber.log("")
    }

    open fun Int.exToString(){
        println("")


        exToString()

        this@Shape.extToString()

        println("Awesome class printi")



    }

    fun extToString(){
        println()
    }
}



//Bir sınıfa extension fonksiyon yazılabildiği gibi extension property de yazılabilir.
// Bunun sebebi aslında property lerin get()  ve set() metodlarından olusmasından dolayıdır.
// Bu extension property lerin içerisinde field tanımlanamaz
// Dolasısıyla aslında gerçek anlamda bir değişken extension yapılamaz.
// bu konu property vs field konusu ile beraber sınıflar işlenirken detaylı anlatılacaktır.
var Shape.type
    get() = "Rectangle"
    set(value) {
        type = value
    }







// Open(extend edilebilir) bir sınıfa,  sınıfın içinde bir open (override edilebilir) extension fonksiyon yazılırsa,
 // bu sınıfı miras (inherit) alan sınıflar, ilgili extension fonksiyonu override edilebilir.
class Rectangle: Shape() {
    override fun Int.exToString() {
        TODO("Not yet implemented")
    }
}