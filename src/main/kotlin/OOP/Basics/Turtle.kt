package OOP.Basics

/**
 * Java ve kotlin de class larda değişen ilk şey, bir class ın nesnesini oluştururken yaşıyacağız.
 * Turtle ın nesnesini oluşturucaz, çünkü kullanılacak özellikleri ve davranışları yazdık artık seri üretime geçmemiz lazım. bu sahişp olma işlemine de nesne oluşturma diyeceğiz.
 * Turtle() constructer parametre parantezleri
 *
 * CONSTROCTOR
 * Constructer: Turtle nesnesini oluşturmak isterken bu değişkenleri her zaman ön tanımlı olrak vermek zorunda değiliz.ön tanımlı versek bile sonradan değiştirmek isteyebiliriz. ya da oluşturulması sırasında sıfırdan verebiliriz.
 * turtleOne. ile tüm özellikleri görebiliyoruz.
 * java da constructer kullanmak için bir fonksiyon yazarız sınıf içine
 * java da aynı isimde constructor fonksiyonunda farklı parametreli bir fonksiyonda daha yazarsak buna constructoor overloading deniliyor.
 * jave ve kotlin de hiç constructer vermezsek bile default olarak constructer bulunuyor.
 * default değerler vererek constructor overloading i engelliyoruz.
 * Kotlin de iki farklı türde constructor var. Primary constructor ve overload edebileceğimiz diğer tüm cosntructorlar ise secondery constructor denir.
 * java da class tanımının yanına parantez koymuyoruz sadece kotlinde constructor parantezi konulur.
 * java da tüm cosnstuructor ları harici olarak yazmamız gerekiyor, ama kotlin de böyle bir durum söz konusu değil.
 * Mülakat Sourusu:  init bloğu primary constrctor çağırıldığı zaman çalışan kısım. Yani init bloğu primary constructor ın body si oluyor. java da bu body yazılan fonksiyon body leri oluyor bizde init bloğu oluyor.
   nesne oluşturulurken çalışan ilk blok init bloğu

 * secondery constroctor: birinci constructor da yaptığımız iş ile ikinci constructor da yaptığımız iş farklı olacaksa bunu kullanırız.
 * this ile primary constructor ı işaret etmemiz gerekiyor. bu şekilde constructor ı overload etmiş olduk.
 * secondery cons çağırsak bile her zaman primary önce çalışır.
 * secondery cons primary cons ın default değer içerimeyen tüm değişkenlerini içermek zorunda.
 * yazılımcılar genelde secondey kullanmaz. primary tarafına default değerler verir ve init bloğunda işlemini yapar.
 *
 *
 * Val ve Var tanımı
 * Primary constructor a bir değişken yazarsan, o değişkeni üye bir fonksiyonun içinde kullanacaksak veya sınıfın dışında kullanacaksak bu durumda değişkenin var yada val olması gerekiyor.
   var ya da val yapmazsak dışarıdan erişime ya da class içerisinde ki init dışındaki üye fonksiyonlarda erişime kapalı olur.

 * constroctor özel ifade alacaksa yazılır. visibilty modifiear alabilir(public,private), annotation verilirse hilt vs.
 *
 *
 * Visibility Modifiers ve Property/field
 * Kotlin de 4 farklı modifiar var:  private, public, protected, internal. kotlinde default public dir, java da tam tersi java da default u private dır.
 * Encapculation: elindeki üye olan şeyleri sakla, bu üye olan şeyleri kullanıma ihtiyaç duyulduğunda ona erişicek fonksiyonlar yaz. java encapsulation ları çok net bir şekilde gösterir.
   Java get-set fonksiyonları yazar ama kotlin tarafında böyle bir kullanım yoktur. Ama kotlinde bunlar arka planda yapılır yani kotlinde encapculation yapılır.
 *Kotlin de arka tarafta yani decompile edince get ve set fonksiyonlarının yazılı olduğunu görürüz.
  mesela feetColor   private yazmasak bile arka tarafta private zaten.buna erişen get fonksiyonu public. buna erişen set fonksiyonu public.
  private var feetColor yaptık diyelim: arka planda feetColor hala private ama get ve set fonksiyonları yok artık.
  Yani çıkarılacak sonuç şu: kotlinde bir değişkenin önüne herhangi bir visibilty modifier verdiğimizde, bu değişkenin get ve set fonksiyonlarının içeriğini, görünürlüğünü  değiştirmiş oluyoruz.
  Kotlinde bir değişkenin gerçek olarak memory de yer kapladığı yere backing field diyoruz.bu backing field kotlin de değiştirilemeyecek şekilde private zaten. yani kotlinde arka planda ki değişkenini istesek de public yapamıyoruz.
  Java da public yapıp encapsulation u delebiliyoruz.
  O yüzden kotlin değişkenlere variable diyoruz normal de ama kotlin de buna property denilir.property özellik, fonksiyon demek.
  Kotlin de değişkenler oluşturmuyoruz aslında o değişkenlerin get ve set fonksiyonlarını oluşturmuş oluyoruz.
  val yapınca sadece değişkenin kendisi yani field,final keywordu alıyor var kullanımında ise almıyor
  property set ve get fonksiyonlarını ifade eder.
 biz en temel de kod yazaren backing field a erişmiyoruz, backing field a erişen fonksiyonlara erişiyoruz.
 Clasın bir üyesi ise bunlar proporty ler ama bir fonksiyoun içerisinde bunları kullanıyorsak o zaman direk backing field üzerinden çalışıyoruz demektir.
 özet: biz bir class ın üye değişkenini aslında private ya da public vererek onun backing field ına değil get ve set fonksiyonlarına erişiyoruz. fonksiyonunu erişimin olarak açık ya da kapalı olmasını değiştirebiliyoruz sadece.

 mulakat da ki cevap: değişkeni private yaptığımız da, buna erişen get-set fonksiyonlarını private yapmış oluyoruz. bunun backing field ı public olsa da private

 internal: modul ile bir yapı oluşturduğumuz zaman.
   */


class Turtle constructor(val mName: String = "Tosbik", val mFeetCount:Int = 4) {


    var feetColor:String = "Brown"
        set(value) {
            field = value
        }
        get():String {
            return field
        }

    val headCount: Int = 1
    val headColor: String = "Brown"
    val shelterColor:String = "Brown"
    val tailCount: Int = 1
    val tailColor:String = "Brown"
    val age: Int = 1
    val sex: String = "Female"

    var feetCount: Int = 4
    var name:String = "Tosbik"


    init {
        //genelde init içinde böyle tanımlanmaz.
        //name = mName
        //feetCount = mFeetCount
        println("Primary Constructor created")
    }

    constructor(mName: String = "Tosbik", mFeetCount:Int = 4, isMarried:Boolean = true): this(mName,mFeetCount){
        println("Secondary Constructor created")
    }

    fun makeASound():String{
        return "hkjhjkk"
    }

    fun eatMeal(){

    }

    fun walk(){

    }

    fun swim(){

    }
}


fun main() {
    val turtleOne: Turtle = Turtle()
    val turtleOneTwo: Turtle = Turtle("Murtle")
    val turtleOneThree: Turtle = Turtle(mFeetCount = 4)
    val turtleOneFour: Turtle = Turtle("Mortle", 4)
    val turtleOneFive: Turtle = Turtle("Mortle", 4, true)

    turtleOne.walk()
    turtleOne.name = "Murtle"
}