package Basics.Characters

/**
 *Ders5: Kotlin | Basic Types Part3
 *
 * Stack ve Heap
 *
 * Nullable bir değişkenin bir değere sahip olması ile null olması arasında bellek yönetimi açısından nasıl bir fark vardır?
 * Nullable bir değişkenin bir değere sahip olması veya null olması bellekte bir miktar yer kaplar. Yani, null değer almış bir değişkenin bellekte yer kaplamadığını söyleyemeyiz.
 * Memory stack ve heap den oluşuyor. stack daha hızlıdır heap e göre.
 * Primitive tipler hem değişkenin kendisini hem de içerdiği value yu stack de yani daha hızlı çalışan alanda tutarlar.
 * Ama biz referans tipli bir değişkenle çalışıyorsak, o referans tipli değişkenin ismi stack de tutulur yine ama value su heap de tutulur.
 * Bu durumda nullable değer null veya bir değer atanmış durumdaysa, değişken ismi stack de tutuluyor, içerdiği değer de heap de tutuluyor.
   Bu durumda nullable olabilen bir değişkene null verirsek, heap de ki kullanım alanı boş oluyor, ama stack de ki isminin kapladığı yer hala stack de hala duruyor.
   Bu neden bir değişkeni null yapmamız, memory de bir alan tutulmuyor demek değil, değişkenin kendisi için bir lana tutuluyor ama value su için bir alan tutulmuyor demektir.
   val age:Int? = null -> bir değer atadık sonra diyeli 23 diye bu 23 değeri heap e yazılıyor. stack de zaten age bilgisi vardı. age burada ki 23 alanını refere ediyor.
 * Primitive de hem değişken hem de değeri tutulduğu için daha hızlı oluyor.
 *
 *
 * */




/**
 * Ders5: Kotlin | Basic Types Part3
 *
 * Smart Case/ Akıllı Dönüşüm
 *
 * Aşağıda ki değer basit bir string değil de daha geniş bir değer aralığına sahip olsaydı.
 * Referans tipli Class larda mesela Any var tüm classların üstünde bulunuyor.
 * Ya da miras alma da üst sınıflarımız alt sınıflarımız olur. Bu durumlar da biz aşağıda ki değişkene üst sınıfın tipini vermiş olabiliriz, ama değer olarak alt sınıfın değeri verilebilir olacak.
 * İşte bu tarz durumlar için biz bir değişkenin hangi tipde bir değer olduğunu bilmeyi isteyebileceğiz. İşte bunu is operatoru yapıyor.
 *
 * bu örnekte şunu diyoruz: x String mi?
 * x String e ait bir değişken ise o halde içerde ki işlemi yap diyoruz.
 *
 * val x:Any = "Mert"
 *
 * if(x is String){
 *     println(x.length)
 * }
 *
 * önemli özelliğinde biri toString() dememize gerek kalmıyor smart casting yani "is" otomatik olarak bunu anlıyor.
 * ide arka planda dönüşümü kendisi yapıyor.
 *
 * */

private fun mainSmartCasting() {

    val x:Any = "Mert"

    if(x is String){
        println(x.length)
        //println(x.toString().length) is smart casting ile toString() yapmamıza gerek kalmıyor.
    }



    val y:Number = 123

    if(y is Int){
        println("Sonuç: $y ")
    }


    val result = Byte.MAX_VALUE + Byte.MAX_VALUE  //Int olurken
    val result2 = Int.MAX_VALUE + Long.MAX_VALUE  // burası long oluyor.
    println(result::class.simpleName)
    println(result2::class.simpleName)
}








/**
 * Characters
 *
 * Tek tırnakların arasında harf, sayı, escape char ya da unicode yazarak kullanılır.
 * Çift tınak içerisinde yazılırsa String olur, Char olmaz.
 *
 *
 *
 *
 * */


fun main() {

    val firstCharOfName: Char = 'G'
    //val firstCharOfName2: Char = "G"        hata verir
    //val firstCharOfName3: Char = 'Gö'       hata verir
    val charNumber1: Char = '6'
    //val charNumber2: Char = '53'      hata verir


    val asciiChar = charNumber1.toInt() //deprecated kodun üzerine tıkla ne ile değiştiğini gösterir
    val asciiChar2 = charNumber1.code
    println("toInt() ile $asciiChar     code ile $asciiChar2")  //ASCII karakter tablosunda ki karşılığını verir

    val digitToInt = charNumber1.digitToInt() //ASCII tablosunda ki karşılığını değil de hangi değer verildiyse onla işlem yapmak istiyorsak digitToInt() kullanırız.
    println(digitToInt)







    /**
     * Escape karakterlerini de tanimlamak icin kullanilir.
     */
    val exampleString = "Kotlin escape karakterleri ornekleri\n" +
            "\t \\t ile bir tab bosluk ekleyebilirsiniz\n" +
            "\t \\n ile yeni bir satira gecebilirsiniz\n" +
            "\t \\b ile bir backspace(geri al) islemi yapabilirsiniz\n" +
            "\t \\r ile satir basina donebilirsiniz.\n" +
            "\t \\' ile tek tirnak(') karakterini kullanabilirsiniz.\n" +
            "\t \\\" ile cift tirnak(\") karakterini kullanabilirsiniz.\n" +
            "\t \\\\ ile ters slash(\\) karakterini kullanabilirsiniz.\n" +
            "\t \\\$ ile dolar isaretini ($) kullanabilirsiniz."

    println(exampleString)




    print('\t') // makes a tab
    print('a')  // prints 'a'
    print('\n') // goes to a new line
    print('c')  // prints 'c'




    val ch = '\u0040' // it represents '@'
    println(ch) // @



    val ch1 = 'b'
    val ch2 = ch1 + 1 // 'c'
    val ch3 = ch2 - 2 // 'a'
}