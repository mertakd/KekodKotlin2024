package Basics.Overview

/**
 * Primitive tip vs Referans tip
 * java da primitive ike kotlin de referans tipdir. kotlin de değişken tipleri sınıftır.
 * kotlinde her şey bir nesnedir, primitive tipler dahil.
 *
 *
 *Primivite tipler normalde, hem kapladıkları alan, hem de erişim hızları
 *bakımından reference tipli değişkenlere göre (yani bir class'ın nesnesine)
 *göre çok daha hızlı çalışan değişken tipleridir.
 *
 *Primitive Types Kotlin'de birer sınıf (class) gibi görünürler. Buna rağmen çalışma zamanında (runtime)
 *primitive hallerine optimize edilirler.
 *
 *
 * Bu değişikliği Show Kotlin Byte Code tool'u ile görebiliriz. (Örnek ile açıkla.)
 *
 * Bu iş görüşmelerinde Kotlin'de her şey bir sınıf olarak belirtildiyse, değişkenler de bir sınıf olarak belirtildiyse
 * biz primitive type olan değişkenleri nasıl tanımlarız.
 *
 *
 *  val değişkene immutable değilde readonly demenk daha mantıklıdır.
 *  readonly demek bir değer atanır ve biz o değeri sadece okuyabiliriz ve set yapamayız.
 *  immutable demek return edilen değerin hiç değişmediği manasına gelir. ama biz val da get fonksiyonunu çağırarak return değerini değiştirebildiğimiz için readonly dememiz daha uygun.
 *
 * var daha performanslıdır ama önerilen değişkene val atanması.
 *
 * */







fun main1() {
    val name: String = "Gokhan"
    val age: Int = 34
    val isMale = true
    val firstLetterOfSurname: Char = 'T'
}






// Immutable vs Readonly
class Box{
    var width: Int = 20
    var height: Int = 40
    var length: Int = 50
    var usedSpace: Int = 0

    val avaliableSpace:Int
        get() {
            return (width * height * length) - usedSpace
        }

}

fun mainReadonly() {
    val box = Box()
    box.avaliableSpace
}





//Bir class ın üye değişkenini var olarak tanımlayıp, bu değişkenin önündeki var kelimesini değiştirmeden nasıl val yapabileceğimizi bizlere sorulur.
// peki neden böyle bir işlem yapma gereksinimi duyuyoruz? Çünkü class içinde bu değişke ilgili işlemler yapmak isteyebiliriz, değeri sınıf içinde mantıksal bir işlemden dolayı değişebilir ama dışarıdan sadece okunsun değiştirilmesin demek için bunu yaparız. 40:10

class User{
    val name: String = "Gokhan"
    var surName: String = "OZTURK"
        private set

    fun asdsda(){
        //surName sınıf iiçinde ğiştirilebilirken, name de ide hata verir. yorumu aç
        surName = "akd"
        //name = "mert"
    }
}

fun main() {
    val user = User()
    //aşağıda ki kodlar çalışmaz
    // user.name = "Barış"
    // user.surName = "Şahin"



}



/*
* val userNameLiveData:LiveData
*   get() = userNameMutableLiveData
* private val userNameMutableLiveData: MutableLiveData
*
*
*
* private val userNameMutableLiveData: MutableLiveData
* bu değiştirilebilen bir yapı set value veya post value diyebiliyoruz
* bunu private yapmazsak viewmodelimizin dışında değiştirilebilir manasına geliyor
* Bu ise değeri değiştirlebilir değişken oluyor. yani readonly değil.
*
*
*
* val userNameLiveData:LiveData
* ama livedata set veya post value değişkenlerine sahip değil.
* live data dışarıdan erişilebilse bile set ve post fonksiyonları olmadığı için istesek de değerini değiştiremiyoruz.
* bu livedata readonly değişkenimiz  oluyor
*
*
* bu encapsulation için yaptığımız, single responsibility prensibi yapıyoruz mvvm kullanırken
* private val userNameMutableLiveData: MutableLiveData view tarafında business logic yapmamak için bunu private yaparız.
* */






/*
* TEST  53:30
*
* unıt, integration, UI  üç farklı test türü vardır.
* Android tarafında biz genel olarak UNIT ve UI testler yazılıyor genelde. Integration da yazılıyor ama mobil tarafında fazla kullanılmıyor.
* Piramit olarak baktığımızda en az yazılandan başlarsak: UI ,Integration,  UNIT test en fazla yazılanı. genelde kaynaklarda böyle gösterilir.
* TR piyasasında en çok UNIT yazılıyor. Integration yazan az, UI yazan çok az var.
* En azından UNIT test tarafını bilmemiz gerekiyor.
*TR de kod yazılır sonra testi yazılır. ama doğru olanı ilk baş test yazılıp sonra kodun yazılmasıdır. Kod yaz, kodun bozulmadığının testini yaz.
* org.junit.Test official olan temel UNIT test kütüphanesi
* orta veya büyük ölçekli projeler de, bize verilen sorumluluk alanıyla ilgili UNIT test yazmazsak, çok büyük bir vakit kaybı yaşıyoruz. sürekli tester ile muhattap olmak zorunda kalıyorsun yani sürekli senin yaptığın hatayı bulmaya çalışıyor
* ama biz kendi alanımız için UNIT test yazmış olsaydık böyle bir sürece girmeyip daha kısa sürede sourunumuzu bulacaktık
* */


//test dosyasına bak
fun createName():String {
    val name: String = "Gokhan"
    return name
}