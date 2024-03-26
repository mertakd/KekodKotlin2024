package Functions

/**
 * Daha okunaklı kodlar yazmak için kullanılır.
 * . (nokta) kısmını kaldırır. yani nesne nokta fonksiyon kullanımına gerek yok.
 * Bir fonksiyonu infiz hale getirebilmek için 5 şart vardır:
 * 1. infix keyword u ile başlar
 * 2. fonksiyon bir üye fonksiyon olmalıdır. (bir sınıfa ait olmalıdır)
 * 3.ya da extension fonksiyon olmalıdır.
 * 4.sadece bir parametre almalıdır. bu parametre vararg olamaz.
 * 5.infix method un parametresi default değer alamaz.
 *
 *
 * Yapısal Olarak
 * infix fun infixMethod(justOneParam: AwesomeParam): Whatever{
 *
 * }
 *
 *
 * Infix fonksiyonun tek bir parametre alması ve opsiyonel olmamasının sebebi okunurluğunu bozması. eğer opsiyonel olursa okunurluğu zorlaşır, kodun anlaşılmasını zorlaştırır.
   Yani infix fonksiyonların tek numarası kolay bir yazımı olması, o yüzden de tek bir parametre alabiliyor.
 * */


val isStudent = false
val isMale = true


fun main() {
   /*
   *  and, or, xor gibi onlarca infix method vardır.*/
   if (!isStudent and isMale){
      println("Öğrenci olmayan erkek")
   }


   isStudent and isMale //infix kullanımı
   isStudent.and(isMale)




   //infix in burada tek esprisi nokta ve parantezleri kullanmamıza gerek kalmıyor.
   val awesomeInstance = AwesomeClass()
   awesomeInstance downloadImage "www.google.com" //infix kullanımı
   awesomeInstance.downloadImage("www.google.com")

   //awesomeInstance downloadImage    bunun default değer olarak kullanılabildiğini varsayalım, kodun okunurluğu çok zorlaşır.







   val number = 5
   //matemaiksel operatorlerin, tip dönüşümlerin(type conversion), range kullanım, infix metodlara karşı işlem önceliği vardır
   /*
   if (number + number - 2 * (awesomeInstance specialPlus 4) ==5){

   }
   */




   //infix metodların da mantık operatorlerine göre önceliği vardır.

   if (number == 3 && number < 5 || awesomeInstance specialPlus 4 == 5){

   }








}

class AwesomeClass {
   infix fun downloadImage(imageUrl: String) {

   }

   infix fun specialPlus(number: Int): Int {
      return 4
   }



   // Generic kullanımı
   /*
   infix fun <T> downloadImage2(vararg imageUrl : T){

   }
   */




   //bir sınıfın içindeyken this kullanımı size bulunduğu sınıfı işaret eder
   //aşağıda ki kullanımda AwesomeClass().downloadImage(imageUrl) kullanımı oluşur aslında. (implicit)
   //bir sınıfın dısındayken infix method çağırımı yapılırsa this kullanılmaz.
   fun logWhenImageDownloaded(imageUrl: String){
      downloadImage(imageUrl)
      //downloadImage imageUrl
      this downloadImage imageUrl
   }







}
