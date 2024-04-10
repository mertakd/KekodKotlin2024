package Basics.Nullables

/**
 *  Bir değişkene null değer ataması yapıbilmek için değişken tipinin sonuna ? işareti konulur.
 *  Eğer bir değişkene tip verilmez ve direk null değer yapılırsa, IDE tip çıkarımı yaparken
 *  bu değişkenin değerini  Nothing? olarak işaretler. Çünlü hangi tipe karşılık geldiğini bilemez.
 *
 *  val name:String? = "gohan" -> bu bir string değer de alabilir almayadabilir.
 *    ""   bu da bir değer oluyor.
 *
 *  ? verilmezse değer ataması yapılamaz. bu null safety yani null güvenliği dediğimiz bir konu.
 *  Java da bu null güvenliği olmadığı için mobil uygulamalarda en sık aldığımız NullPointerException hatası oluyordu.
 *  Java da nullable değişkene bir değerin atanıp atanmadığı kontolü yapılmadan  çağırıldığında bu hata ile karşılaşıyorduk.
 *  Bu hatanın açıklaması şu, sen null olan henüz bir değeri olmayan bir değişken üzerinde bir işlem yapamazsın  */


fun main() {

    val name: String? = null
    name?.lowercase() //? veya !! koymazsak hata verir

    val number = null //tipini belirtmezsek Nothing? tipine dönüştürür kotlin. UNİT YİNE BİR DEĞER DÖNER AMA NOTHİNG HİÇBİR ŞEY DÖNEMZ.



    var result: Int? = 0
    result!!.plus(324)
    result?.plus(324)

    //bu kodun aslında arka planda java karşılığında şuna benzer bir işlem yapılıyor
    if (result != null){
        result.plus(324)
    }

    // ?.  -> bu değer nullable olabilir. Ama buna başka değer atadıysak bu kod çalışsın demek. eğer değeri null ise bu kodu hiç çalıştırmayacak. result?.plus(324)
    // !!  -> işime karışma, ull olmayacağını garanti ediyorum demiş oluyoruz. Yani null olup olmadığı ile ilgilenme her halukarda çalıştır diyoruz ide ye.
    //hangisini ne zaman kullanmalıyız?
    //burdaki plus işlemini yamaması durumunda uygulamamız crash olmasın ama ekranda hatalı bir şeyler belirebilir. Böyle durumlarda ?. kullanılmalı.
    //Ama yazdığımız kodun içerisinde ki işlem de çok kritik  bir görevi varsa o nullable ifadenin gerçekden hatalı çalışması exeprion fırlatması, yanlış sonuç üretmesinden daha doğru olduğunu düşünüyorsak !!: kullanılır.
    // !!. örnek: bir bankacılık uygulamasında kredi hesaplama da backend den null veri gelirse, ya veri gözükmez ya da yanlış hesap yapılır .? kullanırsak. ama bu tarz durumlar da !!. yaparak uygulmayı crash etmek yani çökertmek daha iyidir.


    //bu kekoca bir yöntem
    val number1: Int? = null
    val number2: Int? = null


    if (number1 != null && number2 !=null){
          number1 + number2
    }





}