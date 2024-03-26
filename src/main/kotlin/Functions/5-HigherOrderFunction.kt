package Functions



/*
* ilerde ki bir class ın, fonksiyonun geri ye dönüp haber vermesini sağlayan yapılar oop de interface ler yapıyor. ileriye doğru değil de geriye doğru haberleşme yapmak istiyorsak genelde interface ler ile yapıyoruz.
* recycler view her bir ürünün detayına onClick ile gitmek
*  parametreye main fonksiyonunun içerisinde sahip değiliz de, başka bir fonksiyonun içinde sahibiz parametreye.
*
* HOF larda işlemler esasen oluşturduğumuz higher order fonksiyonun içinde değil  main fonksiyonun içinde yapılır.
* normal olarak yazdığımız fonksiyonda yeni bir logic ekleyeceğimiz zaman hem fonksiyonun içini hem de main de çağırdığımız fonksiyonu güncellememiz gerekiyor. ama HOF da işlemleri sadece main de yaptığımız için sadece main de çağırdığımız kısmı güncellememeiz yeter.
  if-when case i ile kod yazmak çirkin bir kod yazımıdır.

*bir fonksiyon parametre olarak bir fonksiyona verildiyse veya bir fonksiyon bir fonksiyonun geri dönüş tipi ise higher order fonksiyon denir.
 bir fonksiyonun içinde lambda o lambdanın içinde bir lambda daha olursa, mevcut fonksiyonun parametresinde ki lambda higher order func olur.
 *
 * operation lambdasının arka planda nesnesi oluşturuluyor. fonksiyon nesnesi de deniliyor. */



/**
 * Fonksiyonlar kotlin de First Class Citizen dır. Yani kullandığımız herhangi bir teknik yapı değişkenlere değer olarak atanabiliyorsa, bir fonksiyona geri dönüş değeri olarak atanabiliyorsa, bir fonksiyona parametre olarak verilebiliyorsa First Class Citizen.

 * extension higher order
 *
 */
fun main1222() {

    calculateAndPrintNormal(2,4,'x')
    calculateAndPrintNormal(2,4,'+')
    calculateAndPrintNormal(2,4,'/')
    calculateAndPrintNormal(2,4,'-')
}



fun calculateAndPrintNormal(numberOne:Int, numberTwo:Int, operation: Char){
    val result =  when (operation) {
        '+' -> {
            numberOne + numberTwo
        }

        '-' -> {
            numberOne + numberTwo
        }

        'x' -> {
            numberOne + numberTwo
        }

        '/' -> {
            numberOne + numberTwo
        }

        else -> {
            numberOne + numberTwo
        }

    }

    println("Result: $result")
}









//HIGHER ORDER FUNCTION VERSION
fun main() {

    val numberOneInput = readLine()!!.toInt()
    val numberTwoInput = readLine()!!.toInt()


    print("işlem türünü giriniz: ")
    val operation: String = readln()


    val sumFunction = {numberOne:Int, numberTwo:Int ->
        numberOne + numberTwo
    }

    val minusFunction = fun(numberOne:Int, numberTwo:Int):Int {
        return numberOne- numberTwo
    }
    // normal fonksiyonun expression kullanımı
    val multiplyFunction = fun(numberOne:Int, numberTwo:Int):Int = numberOne * numberTwo



    when(operation){
        "+" -> calculateAndPrint(numberOneInput, numberTwoInput, { numberOne, numberTwo -> numberOne * numberTwo })
        "+" -> calculateAndPrint(numberOneInput,numberTwoInput,sumFunction)

        "-" -> calculateAndPrint(5,44,{ numberOne, numberTwo -> numberOne + numberTwo })
        "-" -> calculateAndPrint(5,44, minusFunction)

        "x" -> calculateAndPrint(55,5) { numberOne, numberTwo -> numberOne / numberTwo }
        "x" -> calculateAndPrint(55,5, multiplyFunction)


        "/" -> calculateAndPrint(112,434) { numberOne, numberTwo -> numberOne - numberTwo }
        "/" -> calculateAndPrint(112,434, ::divFunction)
        "/" -> calculateAndPrint(112,434, ::divFunction2)
        //::divFunction paramtre açıp değer veremeyiz. öünkü bu HOF oluyor yani HO bir fonksiyon bekliyor, bir return değeri beklemiyor. dk:2.03.46 yani fonksiyonun body sini istiyoruz. body den kasıt fonksiyonda ki süslü parantez ve içindekiler.
        // parametre sayısı, tipi, geri dönüş tipi aynı olacak ::divFunction u kullanabilmemiz için.
    }




}


fun calculateAndPrint(numberOne: Int, numberTwo: Int, operation:(numberOne:Int, numberTwo:Int)->Int){
    val result = operation(numberOne, numberTwo)
    //val result2 = operation?.invoke(numberOne, numberTwo) invoke null olup olmadığı durumlarda çağırmak için kullanılır.
    println("Result: $result")

}




fun divFunction(numberOne: Int, numberTwo: Int):Int{
    return numberOne/numberTwo
}

fun divFunction2(numberOne: Int, numberTwo: Int):Int = numberOne/numberTwo






/**
 * */