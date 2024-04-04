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

fun main() {

    val x:Any = "Mert"

    if(x is String){
        println(x.length)
        //println(x.toString().length) is smart casting ile toString() yapmamıza gerek kalmıyor.
    }



    val y:Number = 123

    if(y is Int){
        println("Sonuç: $y ")
    }
}