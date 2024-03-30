package Functions

import kotlin.math.log


/**
 * INLINE FUNCTION
 * arka planda runAndPrint bir nesne oluşturuyor. arka planda bir yer oluşturuyorsa memory de yer işgal ediyor oluşturduğumuz nesneler.
 * repeat 10 kere çağırdığımız için fonksiyonun sürekli nesnesini oluşturuyor main içinde..
 *
 * inline yapınca main içinde nesne oluşturma işleminin olmadığını görüyoruz arka planda
 * kapa tabirle inline bir yapının,  yani inline fonksiyonun main de işlem yapmak yerine o işlemi fonksiyonun içinde yapıyor.
 * inline fonksiyonların içinde bir çok işlem yapılıyorsa, built time süresi uzuyor. çok fazla işlem yoksa inline yapmak daha doğrudur. bu şekilde inline yapının performansını tam anlamıyla saşlamış oluruz.
 * Mülakatta soru gelme şekli: Higher order fonksiyonların interface lere göre bir performans artışı vardır.Bu performans artışını nasıl sağlarız?
   Cevap: inline keyword u. inline keyword unu kullandığımızda higherorder function da, parametresine geçen fonksiyonun yaptığı işi olduğu gibi alır. Bizim higher order fonksiyonumuzun içine yapıştırır. Arka planda kod bu şekil de generate edilir.
   Bu yüzden de bu fonksiyonun nesnesi arka planda yaratılmadığı için de bir performans artışı sağlarız.
 *
 * Hangi durumda Inline kullanmamalıyız? Inline ı her higher order fonksiyon gördüğümüz yerde kullanmalı mıyız?
   inline higherorder ın parametresi kullanıyorsak ve body sinde yapılan işlemler çok uzunsa, bu built time da arka planda, generate file ın büyümesine neden olacağı için built time süresine etki edecek.
   diyelim bir çok fonksiyonu inline yaptık ve içinde birçok işlem yaptık diyelim ki built time süresi bir dk ydı ama 2 dk ya çıktı. inline ile küçük bir performans artışı için, built süresini uzatıyoruz bu da verimli olmuyor.
   Inline yapmak için iki soru:  bu inline higher order fonksiyon kaçkere çağırılıyor? 2- Bu higher order fonksiyonun body si ne kadar büyük?. Çok büyükse bir kere çağırılıyorsa inline yapmayın. Küçük, bir kere çağırılıyorsa inline yapabiliriz.
   Yani Inline yapmak çok büyük performans artışı sağlamaz, derin anlamlar yüklemeyin.
   Büyük projeler built süresi uzun olabliyor 10-20 dk vs.

 * Inline performans artışı sağlar nesne oluşturmayarak,  diğer özelliği de nono-local return yapmamızı da sağlıyor. inline yapmazsak HOF nu non local return e izin vermez.
 * */



fun mainInline() {
    repeat(10){
        runAndPrint { message ->
            println(message)
        }


        runAndPrint2 { message ->
            println(message)
        }
    }
}




fun runAndPrint(run: (String) -> Unit){
    run("message")
}

inline fun runAndPrint2(run: (String) -> Unit){
    //println(message) mainde nesnesini oluşturmadan burada yazabilmiş oluyoruz.
    run("message")
}








/**
 * NO INLINE
 *
 * Inline keyword unu fnksiyonun başına koymazsak, parametreyi noinline vey a cross inline yapmamız bir işe yaramıyor.
 * bir higher order fonksiyonun parametresine birden fazla fonksiyon kullanılıyorsa noInline ı kullanabiliriz.
 *
 * Ancak birden fazl parametre kullanırken, bir paramerenin arka planda nesnesi oluşacaksa, yani başka bir fonksiyonu inline higherorder fonksiyonun içinde kullanabilmek için noInline yapmamız gerekiyor.
   Yani iki parametre var diyelim biri inline biri noinline olması lazım bu durumda.
 * Neden böyle yapıyoruz, çünkü log a bir değer gitmesi lazım bir nesne nin üretilip paramere olaraka verilmesi lazım. eğer no inline yapmazsak elimizde nesne olmayacak bir değer veremeyeceğiz.
 *
 * tek parametre olarak fonksiyon varsa no ınline kullanmak saçma oluyor. normal bir fonksiyon yapısı kullanmak durumda aynı şey.
 *
 * en çok kullanıldığı yer, recyclerview da adapter ya da viwholder içinde onclick listener lar hof olarak kullanılırken bu onclick i inline yapabiliriz.
 *
 * */
fun mainNoInline() {

    // Düz Inline fonksiyon
    runAndPrintInline({message ->
        println(message)
    },{logger ->
        println(logger)
    })
}


inline fun runAndPrintInline( run: (String) -> Unit, logger:(String) -> Unit){
    logger("start")
    run("message")
    logger("end")
}








inline fun runAndPrintNoInline( run: (String) -> Unit, noinline logger:(String) -> Unit){
    log(logger)
    run("message")
    logger("end")
}


fun log(logger: (String) -> Unit){
    logger("Start")
}









/**
 * NON LOCAL RETURN
 * Yapılan işlem de return tetiklendikden sonra ki kodlar çalışmaz.
 * non local de ki return sadece for each in dışına değil main fonksiyonunun dışına da çıkartıyor.
   normalde higher order fonksiyon bir return keyword beklemez, string ise string bir değer yazarız return yazmamıza gerek yoktur. ama bu örnek te HOF olmasına rağmen return değeri varsa bu NON LOCAL RETURN deniliyor.
   Ek bilgi continue içinde bulunduğu bloğu atlatıyordu, break içinde bulunduğu ne kadar blok varsa bu blokları atlıyordu. amam Non local return ün farkı bir üstünde ki fonksiyondan bile çıkıyor.

 * Örnekte return ettiğimiz yer bu higher orderın(for eacch bloğu) dışı değil, bunun da kullanıldığı fonksiyonun dışı yani main in dışına çıkıyor.
 * Eğer non local return de label etiketini kullanırsak, continue gibi davrandırmış oluyoruz yani 5 i atlayıp 6 ve 7 yi de yazdırıyor.
 *
 * */

fun mainnnnnnnnn() {

    println("Start")
    val list = listOf(1,2,3,4,5,6,7)
    list.forEach {
        if (it == 5){
            return
        }
        println(it)
    }

    println("End")
}










/**
 * CROSS INLINE
 * non local return ü engelliyor ama hala inline özelliğini koruyor: inline özelliğinden kasıt crossinline kullanılsa bile nesne oluşturulmuyor inline gibi.
 * Nom local return olmasın diye kullanılıyor. adater örneğinde, viewholder da.
 * inline + crossinline kullanımda nesnesi gelmeyecek.
 * parametre olarak geçiyorsa no inline yapmak gerekiyor, başka bir higher order içinde call ediliyorsa  bu durumda da cross inline kullanmak gerekiyor.
   çünkü sadece inline olursa non local returnolma durumu var.
 *
 * Normal inline olmayan HOF lar non-local return u kullanamıyorlar. Yani non local olarak kullanmak istiyorsak HOF nun inline olması lazım.
 * Cross Inline kısaca: HOF içersinde inline artı crossinline kullanırsak, non local kullanmaya izin vermiyor artık. 2:54:00
 * Cross Inline da inline özelliği devam ediyor, yani nesne oluşturulmuyor. Body yine kopyalanıyor. Sadece ide diyor ki kopyaladığın yer, eğer inline olmayan bir fonksiyon olursa o zaman non local return yapmana izin vermem diyor.
   Çünkü non local return sadece inline fonksiyonlar da var. Cross inline bu non local return yapmana izin vermiyor.

 *Non local return ü iptal eden başka bir kullanım ise contract {}*/









//KONU ÖZETİ

/**
 * calculate higher order fonksiyonunun parametresi olan lambda nın arka planda nesnesi yaratılıyor bu şekilde.*/
fun mainNormal() {

    calculate(2,54) { numberOne, numberTwo ->
        numberOne + numberTwo
    }
}



fun calculate(
    numberOne: Int,
    numberTwo: Int,
    operation: (Int, Int) -> Int
) {
    val result = operation(numberOne,numberTwo)
    println("Sonuç: $result")

}






//INLINE FONKSİYON
/**
 * inline keyword u nu koyarsak artık bir nesne oluşturma işlemi yok main de. (arka planda java kodunda)
 * inline ile numberOne + numberTwo işlemi, inline fun body sine yapıştırılıyor aslında. Bu sayede performans artışı gerçekleşiyordu.
 * main de çağırım yapılan yer de ki yapılan işlemler çok büyükse built time süresi uzayacak.
 * { numberOne, numberTwo ->
 *         numberOne + numberTwo
 *     }
 *
 *
 *
 * */
fun mainINLINE() {

    calculate2(2,54) { numberOne, numberTwo ->
        numberOne + numberTwo
    }
}



inline fun calculate2(
    numberOne: Int,
    numberTwo: Int,
    operation: (Int, Int) -> Int
) {
    val result = operation(numberOne,numberTwo)
    println("Sonuç: $result")

}








// NO INLINE

/**
 * Burda ki örnek te fun logger, inline olmadığı için bizden nesne bekliyor bu yüzden de ide hata veriyor.
   Burada aslında calculate3 ün gövdesini vermiş oluyoruz, bu da hataya sebep oluyor. çünkü logger nesne bekliyor fonksiyon body si değil.
  { numberOne, numberTwo ->
     numberOne + numberTwo
  } hatalı durumda bunu vermiş oluyoruz. bu yüzden hata veriyor ide.


 */
fun mainx() {

    calculate3(2,54) { numberOne, numberTwo ->
        numberOne + numberTwo
    }
}



inline fun calculate3(
    numberOne: Int,
    numberTwo: Int,
    operation: (Int, Int) -> Int
) {
    // logger(numberOne, numberTwo, operation)     -> yorumu kaldır, hata durumu
}


fun logger(
    numberOne: Int,
    numberTwo: Int,
    operation: (Int, Int) -> Int
){
    val result = operation(numberOne,numberTwo)
    println("Sonuç: $result")
}



// no inline yanlış kullanımı
/**
 * Tek bir higher order içinde tek bir fonksiyon kullanırsak, yani birden fazl fonksiyon yoksa, bu şekilde no inline yaparsak inline özelliğini götürür.
   Çünkü  başka inline olabilecek fonksiyon kalmadığı için */
inline fun calculate4(
    numberOne: Int,
    numberTwo: Int,
    noinline operation: (Int, Int) -> Int
) {
    logger2(numberOne, numberTwo, operation)
}


fun logger2(
    numberOne: Int,
    numberTwo: Int,
    operation: (Int, Int) -> Int,
){
    val result = operation(numberOne,numberTwo)
    println("Sonuç: $result")
}









// NON-LOCAL RETURN
/**
 * Elimizde kullandığımız call ettiğimiz operation un body sinde bir şartlı durum varsa(bu örnekte if), o şartlı durumda geri kalan kısmı çalışmasın istiyorsak, yani return etsin istiyorsak bu duruma non local denir.
   Non local return un gerçekleşmesini istiyorsak, fonksiyonu inline yapmamız gerekiyor.
 * inline keyword unu kaldırırsanız hata verecektir.
 * Yani inline temelde iki işlevi var: birincisi nesne oluşturulması engelleniyor, ikncisi non local return e izin veriyor.
 * */


fun mainNonLocal() {
    calculate5(2,54) { numberOne, numberTwo ->
        if (numberTwo == 0){
            return
        }
        numberOne + numberTwo
    }
}
inline fun calculate5(
    numberOne: Int,
    numberTwo: Int,
    operation: (Int, Int) -> Int
) {
    val result = operation(numberOne, numberTwo)
    println("RESULT: $result")
}








// CROSS INLINE
/**
 * Cross Inline, Eğer Inline fonksiyonumuz inline olmayan bir fonksiyonun içinde call ediliyorsa, non local özelliğini kaybetsin, ama inline olma
   özelliğini kaybetmesin istiyorsak bu durumda Cross Inline ı kullanırız.

  * Yazdığımız kodda non local durumu olmasa bile ide ayırt edemiyor non local var mı yok mu diye oyüzden de cross inline kullanmalıyız.
 *
 * Cross Inline, inline özelliğini kaybettirmez. Sadece non local özelliğini kaybettirir.
 *
 *
 * */


fun main() {

    calculate6(2,54) { numberOne, numberTwo ->
        /*
        if (numberTwo == 0){
            return
        }
        non local durumu, cross inline olduğu için, yorumu açarsak hata verecektir.
        */
        numberOne + numberTwo
    }
}



inline fun calculate6(
    numberOne: Int,
    numberTwo: Int,
    crossinline operation: (Int, Int) -> Int
) {
    logger2(numberOne, numberTwo) {_numberOne, _numberTwo ->
        operation(numberOne, numberTwo)
    }
}


fun logger3(
    numberOne: Int,
    numberTwo: Int,
    operation: (Int, Int) -> Int,
){
    val result = operation(numberOne,numberTwo)
    println("Sonuç: $result")
}
