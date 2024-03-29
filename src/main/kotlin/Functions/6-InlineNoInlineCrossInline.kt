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
 **/
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
 * Eğer non local return de label etiketini kullanırsak, continue gibi davrandırmış oluyoruz yani 5 i atlayıp 6 ve 7 yi de yazdırıyor. */

fun main() {

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
 * Nom local return olmasın diye kullanılıyor. adater örneğinde, viewholder da.
 * inline + crossinline kullanımda nesnesi gelmeyecek.
 * parametre olarak geçiyorsa no inline yapmak gerekiyor, başka bir higher order içinde call ediliyorsa  bu durumda da cross inline kullanmak gerekiyor.
   çünkü sadece inline olursa non local returnolma durumu var.
 *
 * Normal inline olmayan HOF lar non-local return u kullanamıyorlar. Yani non local olarak kullanmak istiyorsak HOF nun inline olması lazım.
 * Cross Inline kısaca: HOF içersinde inline artı crossinline kullanırsak, non local kullanmaya izin vermiyor artık. 2:54:00
 * Cross Inline da inline özelliği devam ediyor, yani nesne oluşturulmuyor. Body yine kopyalanıyor. Sadece ide diyor ki kopyaladığın yer, eğer inline olmayan bir fonksiyon olursa o zaman non local return yapmana izin vermem diyor.
   Çünkü non local return sadece inline fonksiyonlar da var. Cross inline bu non local return yapmana izin vermiyor.*/


