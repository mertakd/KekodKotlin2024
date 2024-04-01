package OOP.Encapsulation

/**
 * Encapsulation: bir class ın üye olan herhangi bir şeyini olabildiğince private da tutup, daha sonra da hangi durumlar da bunu dışarıda kullanılmasını istiyorsak, o seviye de mevcut class ın bileşenlerini dışarıya açmak. Buna encapsulation diyoruz.
 *
 * Neden kullanmamız gerekiyor Encapsulation u?: güvenlik için dersek eksik bir cevap olur.
   Tanımladığımız class dışında kullanılması gerekmiyorsa gereksiz karmaşıklık yaratmamak için

   Dışarıya ne kadar bilgi veriyorsak,bu o class hakkında çok fazla bilgiye sahip olduğumuzda hepsini kullanmamız gerekiyormuş gibi bir algıya sebep olur. Ama bazı kullanmamamız gereken değişken veya fonksiyonlar üzerinde hakimiyetimiz olursa, ana fonksiyon setinin çalışmasını bozabiliriz.
   Dolayısıyla bir karmaşıklağa neden olur herşeyi public de tutmak ya da vsisibility modifier ları doğru yerde kullanmamak.

   Yani karmaşayı önlemek en doğru cevap olacaktır.: mimari olarak bir architecture kurabilmemiz için belli classların belli classları hiç görmemesi, belli classların başka class ların belli kısımları görebilmesi, sizin o mimariyi kurabilmenize sebebiyet veren şeyler.
   Ya da en başta o mimariye neden ihtiyacımız vardı? Belli şeyleri belli class lara ayırabilip, sadece onların içerisinde kalmasını, dışarıdan erişilebilir olmasına izin vermeyerek o mimamrinin prensiplerine uygun kod yazabilmemizi sağlatmış oluyoruz.
 * Kod yazarken düşünmemiz gereken mantık bir kodu neden public yaparız?
 *
 * Class ın üyer değişkenleri ve fonksiyonları private olmaz ise, burada encapsulation var mıdır? Evet encapsulation vardır. Çünkü o değer arkap planda field olduğu için private dır. Burda tek istisna local bir değişken oluşturmuyorsak.
   Public olması halinde ve dışarıdan bu değerlere erişmiyorsak,  sadece set get fonksiyonlarına erişebiliyoruz. mesela bu şekilde set fonksiyonuna erişiyoruz. encapsulation.name = "asdasdasds". Private da da tam tersi arka planda get-set fonksiyonları oluşturulmuyor.
   name, surName i private yaparak, arka planda ki set ve get fonksiyonlarını private a çekmiş oluyoruz. getName/setName fonksiyonları arka planda.
   değeri private yapınca arka planda get/set fonksiyonlarının görünmeme sebebi, bu private değeri zaten call edemediğimiz için, arka planda oluşmuyorlar.
   Kısaca private veya public olması arka planda get set fonksiyonlarının oluşturulup oluşturulmamasıyla alakalı. Sınıf içinde ki oluşturulan değerler aslında field ı hep private. bu yüzden encapsulation un babası var kotlin de.
 *
 *
 *
 *
 * */




class Encapsulation {

    var name: String = "Gökhan"
    val surNmae: String = "ÖZTÜRK"

    fun getFullNmae(): String {
        return "$name $surNmae"
    }

    /*fun getName(): String{
        return name
    }

    fun setName(value:String){
        name = value
    }

    kullanmıyoruz bu yapıyı kotlin de
    */
}


fun main() {
    val encapsulation = Encapsulation()
    encapsulation.name = "asdasdasds"
}