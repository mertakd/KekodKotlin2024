package Basics.Numbers

/**
 * Big decimal kripto için
 * Tip çıkarımı(Type Inference) sırasında eğer sayı Int ifadeden büyük değilse tipi default olarak Int e set edilir, yani ide int olarak görür o değeri.
 * Tip çıkarımı(type inferance) sırasında eğer sayı Int ifadeden büyükse tipi default olarak Long a set edilir.
 *
 * Octal gösterimi kotlin desteklemiyor
 * */


fun mainBox() {

    val longNumber = 1586L //Sayısının sonuna L koyularak long olduğu belirtilir. küçük l olmaz 1 sayısı gibi duruyor çünkü.
    val floatNumber1 = 19.90F // F konularak float olduğunu belirtebiliriz.
    val floatNumber2 = 19F
    val doubleNumber = 3.14e10 // bu şekilde double gösterimi yapılabilir.
    val hexadecimalNumber = 0x759
    val binaryNumber = 0b01000011
    //val octalNumber = 0197 çalışmaz



    //Number değişken tanımı yapılırken underscore _ kullanılabilir.
    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val bytes = 0b01000011_011101111_01110001000_01110001101_01101101_011111101







    /**
     *  Boxed : Değişkenin obje referansı olarak tutulmasıdır.
     *  UnBoxed : Değişkenin primitive olarak tutulması.
     *  === operatoru değişkenlerin referansını karşılaştırırken kullanılır. yani memory de ki referanslarını kontrol ettirir.
     *  == operatoru değişkenlerin değerini karşılaştırırken kullanılır.
     *
     *  Mülakat sorusu
     *  Kotlin primitive tipler class larla temsil ediliyorlar. val name: String = "mert" . buradaki String bir class. Bu primitive tip değil normal de içine bir sürü şey eklenebilir.
        Bu yüzden primitive tiplere göre memory de kapladığı alan daha büyüktür. Buna erişicek erişim hızı da primitive tiplere göre daha düşüktür, yavaştır. Yani primitive tiplere göre daha hantal.
        Ama özel optimizasyonlarla bu sınıflar byte koda çevrilirken primitive hallerini kullanıyoruz kotlin de.
        Ama bunun bir istisnası var. Eğer biz primitive bir değişkeni nullable yapıyorsak, yani bu artık null değer de alacak diyorsak, bu değişkenin temsili artık primitive tip olarak değil, Javada da bildiğimiz büyük class tiplerine dönüşüyor.
     * Bu neyi değiştiriyor? Bu değişkenin kapladığı alanı, erişim hızını değiştirir. Referans kontrolünde farklı sonuçlar almamıza neden olur. Bu yüzden gereksiz soru işareti kullanmamalıyız.
     *
     * byte aralığı:  -128  127
     * Integer sayısal değerlerin nullable olması durumunda eğer byte aralığı içerisindeyseniz(-128 ve 127) bu durumda özel optimizasyonlarla aynı referans alanına işaret ettiğimizi gösteriyor.
       Yani farklı değişkenler gibi gözükseler bile aynı değişkenler oluyor. o zaman true veriyor.
       Ama 127 yi geçiyorsak bunlar farklı memory alanlarına işaret ediyor demektir, yani false verir.
     *
     *  Mülakat sorusu
     * üç eşitlikle neyi kontrol edersin? referansları kontrol ederiz. bu basit olan soru.
     * Zor olan soru: Kotlin de primitive tipde ki değişken nullable yapılır ve üç eşittir ile kontrol edilirse nasıl bir sonuç alırsınız? Bunun nedeni nedir?
       Eğer primtive bir değişken nullable olup, üç eşittir ile referans kontrolü yapılırsa ve 127 / -128 olan  byte aralığının dışında bir değer veriliyorsa yani daha büyük veya daha küçük bir değer veriliyorsa
       bu durumda farklı memory alanlarına işaret ettiğini gösterir ve bunun sonucunda false çıktı verir.
       Ama byte aralığının içerisindeysek aynı memory alanına işaret etmiş oluruz iki farklı değişken olsa bile. o zaman true verir.
     *
     * Burada aldıkları değerin aralığı önemli, tipinin Int, Long, Short vs ne olduğunun bir önemi yok.
     *
     * Referans olarak Byte aralığında olan farklı değişkenler, aynı adresi gösteriyor. Bu zaten performans farkı yaratn konu. Aynı adresi gösterdikleri için yeni bir memory adresi atanmıyor bu değişkenlere. o yüzden performans olarak daha hızlı daha iyi oluyorlar.
     *
     * */

    val number: Int = 127
    val boxedNumber: Int?  = number
    val anotherBoxedNumber: Int? = number
    println(boxedNumber === anotherBoxedNumber) // true


    val number2: Int = 128
    val boxedNumber2: Int?  = number2
    val anotherBoxedNumber2: Int? = number2
    println(boxedNumber2 === anotherBoxedNumber2) // false





}






/**
 * TYPE CONVERSION
 *
 *  Implicit Type Conversion : Örtülü -belirgin olmayan şekilde tip donüşümü
 *  Explicit Type Conversion : Açık - belirgin tip dönüşümü
 *
 * Kotlinde Implicit yani kapalı/örtülü tip dönüşümü yoktur.
 * java da yapılabilir sadece. val number : Int = (Int) 3L  bu çalışmaz kotlinde, java da çılışır
 *
 * Tip dönüşümleri için kullanabileceğimiz fonksiyonlar;
 * toByte(), toShort(), toInt(), toLong(), toFloat(), toString() vs.
 *
 *
 * */
fun getValue(doubleNumber: Double){}
fun getValueNumber(doubleNumber: Number){}
fun main() {
    val longNumber = 1586L
    val floatNumber1 = 19.90F
    val floatNumber2 = 19F
    val doubleNumber = 3.14e10
    val hexadecimalNumber = 0x759
    val binaryNumber = 0b01000011


    //getValue(floatNumber1) burda yapılmaya çalışan şey implicit dönüşüm bu java da yapılabilirken kotlin de yapılamıyor
    getValue(floatNumber1.toDouble()) //kotlin de izin verilen Explicit dönüşüm budur.

    getValueNumber(floatNumber1)
    //burada hata vermez. çünkü Number sayısal tiplerin en üst class ı oluyor. Burda karışıklı olmasın bu tip dönüşümü değil bu miras almayla ilgili bir konu.




    // ilk değişken default olarak Int olmasına rağmen, toByte() ile byte değere dönüştürüyoruz.
    val schoolNumber = 126.toByte()
    val convertedValue: Short = schoolNumber.toShort()



    // yüksek değerler düşük değerlere cast yapışıyorsa sorun çıkma ihitmali var. Yani düzgün casting yapamıyoruz.
    //aşağıdan yukarı doğru cast yaparken sorun yok
    val schoolNumber2 = 126234523423423423.toByte()
    println(schoolNumber2) // çıktı  -65




    // long + byte  = long olur
    val tc = 15_860_826_657
    val schoolNumber3 = 113

    val totalValue: Long = tc + schoolNumber3 //long + byte  = long olur

}

