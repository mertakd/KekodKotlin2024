package Functions

import java.util.Locale

/**
 * Tekrar edilen her durum için fonksiyonlar yazılır. Bu sayede her yerde değişiklik yapmak zorunda kalmayacağız, tek bir fonksiyonda değişiklik yapmamız yetecek.
 * fu keyword'u ile fonksiyonlar başlar
 * fonksiyon ismi verilir.
 * parametre parantezleri açılır ve parantezler girilir.
 * : operatoru ve geri dönüş değeri yazılır.
 * fonksiyon body si açılır ve kapatılıt
 * geri dönüş değeri verilmeyen fonksiyonlar Unit tipini geri döndürür.
   Unit: herhangi bir tipte geri dönüş değeri beklemiyorum demiş oluyor.

 * Fonksiyonlarda kod artık düz bir akıştan çıkarak dallanmaya başlar.
 *
 * Fonksiyonlar "First Class Citizin" dır. Kullandığınız yapı bu yapı değişkenler, fonksiyonlar,classlar v.s olabilir. İşte bu yapılar değişkenlere değer olarak atanabiliyorsa,
   başka fonksiyonlara parametre olarak verilebiliyorsa ve başka bir fonksiyonun geri dönüş değeri olabiliyorsa buna First Class Citizin diyoruz.
 * */


fun main1() {

    // Fonksiyon çağırılırken ismi ve parametreleri kullanılabilir.
    // Eğer bir geri dönüşü varsa bir değişkene atabilir.
    takeSquare(5)
    val squareValue = takeSquare(2)


    //Bir class'ın fonksiyonunu çağırırken ise nokta işaretini kullanırız.
    Math.pow(2.0, 3.0)
}



// Fonksiyon bir değişkene çok benzer
val name : String = "Mert"
fun name() : String = "Mert"




/*----------------------------------------------------------------------------------------------------------*/

// dallanma akışı ilk başlayanlar için kafa karıştırıcı olabilir.
// geri dönüş değeri Int olduğu için return kullanıp değeri geri döndürmemiz gerekir.

//fonksiyonlar içerisine değişkenler alabiliyorlar, bunlara parametre diyoruz.val-var koymuyoruz zaten izin verilmiyor.
//bu değişken fonksiyon çağırıldığında verilecek.
fun takeSquare(number: Int): Int {
    //val number: Int = 5  burdaki number parametrede ki number ı ifade etmez. name shadow
    //asddadsas
    //asddadsas
    //asddadsas
    return 2 * number
}

/*----------------------------------------------------------------------------------------------------------*/











fun main2() {
    takeSquare2()
    takeSquare2(number = 25)
    takeSquare2(number2 = 47)
    takeSquare2(25,47)

}


//Default Parametreler
// fonksiyon overloading, name argument, default parameter mulakat sorusu
//bu parametreye eşittir ile bir değer veriyorsak, bu fonksiyonu çağırdığımız zaman bu parametreyi artık opsiyonel yapmış oluyoruz.
// bu fonksiyonu çağırdığımız da argümana bir değer yazadabiliriz yazmayadabiliriz. hiçbir değer vermediğimizde otomatik default olan 4 değerini alacak. Buna ayrıca fonksiyon overload deniliyor.
//java da fonksiyon overload işlemi aynı bu şekil de yapmamız için iki fonksiyon yazmamız gerekiyor.
// aynı isimde ki fonksiyonu birden fazla yazıp kullanma durumuna fonksiyon overloading deniliyor. Kotlinde default value lar bize fonksiyon overload yapmayı sağlatıyor.
// bir fonksiyonun ismi aynı kalarak, birden fazla parametre sayıları değiştirilerek, parametre sayısı aynı olup parametre tipi farklıysa fonksiyon overload dur. name argument yada default vvalue leri kullanarak yapabiliriz bu işlemi. Türkçesi aşırı yüklemek.
// name argument: fonksiyonu çağırırken normalde arguman ilk parametreyi alır. biz ilk baş ikinci parametreye atama yapmak istersek name argument i kullanırız.

fun takeSquare2(number: Int = 4, number2 : Int = 7): Int {



    return 2 * number
}

/*
fun takeSquare2Java(): Int {
    val number = 4


    return takeSquare2Java(number)
}
*/







//FONKSİYON OVERLOAD ÖRNEĞİ
fun main3() {
    //Burada bir fonksiyondan, birden fazla çıktı ürettik. İşte bu olaya fonksiyon overload diyoruz.
    reformatMessage("Message",true,7,"tr")
    reformatMessage(message = "Message", size = 7, lang = "tr") //uppercase çağırılmıyor ama default değeri false, oyüzden çıktı küçük "message" olacak.
    reformatMessage("Message",true,7) // lang verilmemiş ama default değeri tr.
    reformatMessage("Message", size = 7)

    //reformatMessage("hello kotlin", 7)   ->tip hatası veriyor. çünkü arguman olarak ikinci sırada bulunan  isUpperCase i bekliyordu. bu sorunu çözmek için name argument kullanmamız lazım
    reformatMessage("hello kotlin", size = 7, lang = "tr") //lang için de name argument yapmak zorundayız, çünkü normalde dördüncü parametreye denk geliyor.
    reformatMessage("hello kotlin", lang = "tr", size = 7, isUpperCase = true) // argumanlarda, parametreleri yazılış sırasına göre girme zorunluluğumuz yok.
}
fun reformatMessage(message: String, isUpperCase: Boolean = false, size: Int, lang: String = "tr") {

    val locale = if (lang == "tr"){
        Locale("TR", "tr")
    }else{
        Locale.ROOT
    }

    val localMessage = if (isUpperCase){
        message.uppercase(locale)
    }else{
        message.lowercase(locale)
    }

    println("Message: $localMessage")

}






//VARARGS
//Argumentler listesi gibi düşünebiliriz. Parametre sayısı belli olmayan durumlarda kullanmalıyız.
//çok uzun sayıda parametreniz olacaksa vararg tanımlayabiliriz

//vararg tek başına ya da son parametre olarak yazılırsa Jvm'e hazırlanırken, Java'da ki "String..." gibi aynı kod derlenir.
// Ancak vararg param birden fazla tanımlanırken orta da ya da başta yer alırsa , Jvm' e hazırlanırken, Array e dönüştürülür. Bu da küçük bir performans farkı oluşturur demektir. daha az performans sağlar ama çok küçük.
fun main() {
    //vararg kullanımına örnek. key = 3 ' den önceki parametreler vararg parametresine denk gelir. key = 3 yerine sadece 3 yazamayız, çünkü sadece 3 yazarsak vararg girdisi olarak kabul eder ide.
    getUserInfo("Gökhan","ÖZTÜRK", "Istanbul", "Turkiye","","","", key = 3)
    //getUserInfo("Gökhan","ÖZTÜRK", "Istanbul", "Turkiye","","","", 3) hata verir


    //vararg parametresi olarak arrayOf kullanılmak istenirse * operatoru eklenmelidir (spread operatoru)
    //bu operator diğer dillerdeki pointer kullanımı anlamına gelmez. kotlin de pointerlar yoktur.
    getUserInfo(*arrayOf("Gökhan","ÖZTÜRK", "Istanbul", "Turkiye"), key = 4)

    //ilk girdi vararg olmadığı için ide kızmıyor.
    getUserInfo3(3, "Gökhan","ÖZTÜRK", "Istanbul", "Turkiye")

    //Tip olarak Any olduğu için herşeyi kabul ediyor
    getUserInfo4(3,"Gökhan","ÖZTÜRK", "Istanbul", true, 3.14, "")
}
fun getUserInfo(vararg userInfo: String, key: Int) {
    userInfo[3]
    userInfo.get(3)
}




fun getUserInfo2(vararg userInfo: String) {
    userInfo[3]
    userInfo.get(3)
}

fun getUserInfo3(key: Int, vararg userInfo: String) {
    userInfo[3]
    userInfo.get(3)
    println(key)
}

fun getUserInfo4(vararg userInfo: Any) {
    userInfo[3]
    userInfo.get(3)
}