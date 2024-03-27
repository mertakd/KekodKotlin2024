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

    calculateAndPrintNormal(2, 4, 'x')
    calculateAndPrintNormal(2, 4, '+')
    calculateAndPrintNormal(2, 4, '/')
    calculateAndPrintNormal(2, 4, '-')
}


fun calculateAndPrintNormal(numberOne: Int, numberTwo: Int, operation: Char) {
    val result = when (operation) {
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
fun main10() {

    val numberOneInput = readln().toInt()
    val numberTwoInput = readln().toInt()


    print("işlem türünü giriniz: ")
    val operation: String = readln()


    val sumFunction = { numberOne: Int, numberTwo: Int ->
        numberOne + numberTwo
    }
    sumFunction.invoke(
        36,
        42
    ) // değişken gibi gözükseler de fonksiyon gigibi davaranır sumFunction. bu şekilde invoke fonksiyonunu çağırırız.

    val minusFunction = fun(numberOne: Int, numberTwo: Int): Int {
        return numberOne - numberTwo
    }
    // normal fonksiyonun expression kullanımı
    val multiplyFunction = fun(numberOne: Int, numberTwo: Int): Int = numberOne * numberTwo



    when (operation) {
        "+" -> calculateAndPrint(numberOneInput, numberTwoInput, { numberOne, numberTwo -> numberOne * numberTwo })
        "+" -> calculateAndPrint(numberOneInput, numberTwoInput, sumFunction)

        "-" -> calculateAndPrint(5, 44, { numberOne, numberTwo -> numberOne + numberTwo })
        "-" -> calculateAndPrint(5, 44, minusFunction)

        "x" -> calculateAndPrint(
            55,
            5
        ) { numberOne, numberTwo -> numberOne / numberTwo } //HOF en sondaysa ya da bir tane ise fonksiyon parantezlerinin dışına yazabiliriz.
        "x" -> calculateAndPrint(55, 5, multiplyFunction)


        "/" -> calculateAndPrint(112, 434) { numberOne, numberTwo -> numberOne - numberTwo }
        "/" -> calculateAndPrint(112, 434, ::divFunction)
        "/" -> calculateAndPrint(112, 434, ::divFunction2)
        //::divFunction paramtre açıp değer veremeyiz. öünkü bu HOF oluyor yani HO bir fonksiyon bekliyor, bir return değeri beklemiyor. dk:2.03.46 yani fonksiyonun body sini istiyoruz. body den kasıt fonksiyonda ki süslü parantez ve içindekiler.
        // parametre sayısı, tipi, geri dönüş tipi aynı olacak ::divFunction u kullanabilmemiz için.
    }


}


fun calculateAndPrint(numberOne: Int, numberTwo: Int, operation: (numberOne: Int, numberTwo: Int) -> Int) {
    val result = operation(numberOne, numberTwo)
    //val result2 = operation?.invoke(numberOne, numberTwo) invoke null olup olmadığı durumlarda çağırmak için kullanılır.
    println("Result: $result")

}

fun divFunction(numberOne: Int, numberTwo: Int): Int {
    return numberOne / numberTwo
}

fun divFunction2(numberOne: Int, numberTwo: Int): Int = numberOne / numberTwo









/**
 * HOF parametrelerine isim vermemize gerek yok.*/
fun calculateAndPrint2(numberOne: Int, numberTwo: Int, operation: (Int, Int) -> Int) {  //operation: (Int:numberOne, Int:numberTwo) -> Int    una gerek yok
    val result = operation(numberOne, numberTwo)
    //val result2 = operation?.invoke(numberOne, numberTwo) invoke null olup olmadığı durumlarda çağırmak için kullanılır.
    println("Result: $result")

}


fun main22() {

    println(calculateAndPrint3())



    // it kullanımı
    calculateAndPrint4(4) {
        it.plus(7)
    }



    //Extension kullanımı
    val extensionResult = calculateAndPrint5(2, 5) { numberOne, numberTwo ->
        val sum = numberOne + numberTwo
        println("$this: $numberOne, $numberTwo")
        sum
    }

    println(extensionResult)
}

/**
 * HOF değer vererek opsiyonel hale getirebiliriz.*/
fun calculateAndPrint3(
    numberOne: Int = 3,
    numberTwo: Int = 4,
    //operation: (Int, Int) -> Int = { numberOne, numberTwo -> numberOne + numberTwo } // operation iki şekilde de implement edilebilir.
    operation: (Int, Int) -> Int = ::defaultSum
) {
    val result = operation(numberOne, numberTwo)
    //val result2 = operation?.invoke(numberOne, numberTwo) invoke null olup olmadığı durumlarda çağırmak için kullanılır.
    println("Result: $result")

}


fun defaultSum(numberOne: Int, numberTwo: Int):Int {
    return numberOne + numberTwo
}






//HOF da tek bir parametre olursa it ifadesi kullanmamız yeterli olacaktır.
fun calculateAndPrint4(
    numberOne: Int,
    operation: (Int) -> Int
) {
    val result = operation(numberOne)
    println("Result: $result")

}






//HOF ların extension olarak kullanımı
fun calculateAndPrint5(
    numberOne: Int,
    numberTwo: Int,
    operation: String.(Int, Int) -> Int
) {
    val result = "Sayılar".operation(numberOne,numberTwo)
    println("Sonuç: $result")

}





fun main() {
    qoo(::wooFun, ::rooFun, yoo = ::yooFun2, poo = ::pooFun) //default value

    qoo(::wooFun, ::rooFun, ::tooFun, ::yooFun2, ::pooFun)
}

private fun wooFun() {

}

private fun rooFun(number: Int): String {
    return number.toString()
}

private fun tooFun(number:Int):String{
    return number.toString()
}

private fun String.yooFun(number: Int): String{
    return "$this ${number.toString()}"
}
private fun yooFun2(message:String, number: Int): String{
    return "$message ${number.toString()}"
}

private fun pooFun(soo:()->Unit){
    soo()
}

fun qoo(
    woo: () -> Unit,
    roo: (Int) -> String,
    too: (Int) -> String = ::defaultToo,
    yoo: String.(Int) -> String,
    poo: (soo:()->Unit) -> Unit
) {
    woo()
    val resultRoo: String = roo(5)
    val resultToo: String = too(4)
    val yooResult: String = yoo("Message", 56)

    poo(::localPooFun)
}

private fun localPooFun(){
    println("Soo  fun called, yani çırılan işlemin yapıldığı yer burası")
}

private fun defaultToo(number: Int): String {
    return number.toString()
}



