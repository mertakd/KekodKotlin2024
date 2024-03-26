package Functions

/**
 * Bir fonksiyon herhangi bir sınıfın içerisinde değil de bir dosyanın içerisinde boşlukta tanımlanıyorsa  buna top level function denir.
 *
 * Bir fonksiyon oluşturulurken top level tanımlama yapılamıyor,  sadece bir sınıfa ait fonksiyonlar yazılabiliyorsa, bunlara fonksiyon değil, method denir.
 *
 *
 * Fonksiyon içinde fonksiyon tanımı kotlinde yapılabiliyor. Bu fonksiyonlara Local Functions denir. bunda inline fonksiyon da denildiği görülür
   Sebebi ise, yazdığınız fonksiyonun kendi sınıfınızdan dahi çağırılmasını istemiyebilirsiniz.
   Bu fonksiyonun herhangi bir başka fonksiyon ya da sııf için değiştirilmesini istemiyebilirsiniz.
   Reflection ile fonksiyonlarınızı erişilirken gizli kalsın isteyebilirsiniz.
   Bu gibi durumlarda bu çok önemli fonksiyonunuzu başka bir fonksiyon içerisine yazabilirsiniz.
 * Bu kullanım tarzı sdk yazarken yararlıdır. güvenlikle alakalı bir sdk yazarken yararlı olur. login, register, yüklü para transferleri, şüpheli işlemler, dosyanın bütünlüğünü koruyon işlem yapılmasını önleyen işlemler de kullanılıyor.
 * local fonksiyonlara reflection dahi hiçbir şekilde erişilemez.*/


fun main() {

    //bu bir local fonksiyon.
    // dikkat bir fonksiyonun çağırılması yani call edilmesi farklı bir şey yani local fonksiyon denilmez bu duruma. fıtıfıtı()
    //
    fun calculateAtomPhysics2(){

    }
}



//ERİŞİLEMEME DURUMU
class PrivateA(){

    fun commonFunction(){

        fun specialField(){
            //sadasdasd
        }
    }
}


fun foo(){
    val privateA = PrivateA()
    privateA.commonFunction()
    //privateA.specialField() erişilemiyor
}



// BİR SINIFIN İÇERİSİNDE Kİ FONKSİYONLARA, ÜYE FONKSİYONLAR DENİR.
class Car {

    fun setColor(colorCodeId: Int){

    }
}






//Bir fınksiyon Generic tip alıyorsa , Generic Function olarak adlandırılır.
fun <T> setColor(colorCodeId: T){

}