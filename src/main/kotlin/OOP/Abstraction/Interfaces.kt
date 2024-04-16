package OOP.Abstraction

/**
 * Interface in başka bir tanımı arayüz dür.  arrayOf<>()
 *
 * Interface ler tek başına kullanılan yapılar değiller
 * Interfaceler constroctor lara sahip olamıyor. zaten constroctor ı yoksa kesin olarak nesnesi oluşturulamaz demek.
 *
 * object expression kullanımı yapılıyor, bir değişkene eşitlik olarak verilmiş çünkü.
 * object interfaceler tek seferlik kullan at olarak tanımlanır
 * object arka planda bir nesne oluşturuyor bir class gibi davranıyor.
 * open ve final yapmak mantıksız final da hata veriyor zaten
 * body si varsa bir fonksiyonun implement etmek zorunda değiliz.
   neden body li fonksiyon override etme zorunluluğu kalkıyor: arka planda body li fonksiyon aslında statik fonksiyon haline dönüşüyor
   interface body si olan fonksiyon için statik bir class  ve statik class ın içerisinde statik bir fonksiyon oluşturuyor.
 *
 *
 * bir interface başka bir interface i implement edebilir
 * interface bir open class ı ve abstract class extend edemez.
 * final keyword u abstract class larda kullanılabiliyorken, interface ler de kullanamıyoruz.
   daha derin child class larda override edilen değeri final yapmak istiyorsak, interface yerine abstract kullanmak daha mantıklı dır.

 * interface ler state tutamazlar, tutmamalılar. abstract class lar state tutar.
 * interface sınıfında ki değerin backing field ı yokken override edildiği yerde backing field ı var.
 *
 * companion object ile değişkene değer atanabiliyor. yani state tutulabiliyor ama yanlış bu şekilde kullanım.
 * */



interface TextWatcher {

    fun onTextChanged()
    fun beforeTextChanged()
    fun afterTextChanged()

    fun withBody(){

    }
}


fun main() {

    val tetWatcher = object : TextWatcher {

        override fun onTextChanged() {
            TODO("Not yet implemented")
        }

        override fun beforeTextChanged() {
            TODO("Not yet implemented")
        }

        override fun afterTextChanged() {
            TODO("Not yet implemented")
        }


        override fun withBody() {
            super.withBody()
        }

    }
}




class InterfaceSample: TextWatcher {

    override fun onTextChanged() {
        TODO("Not yet implemented")
    }

    override fun beforeTextChanged() {
        TODO("Not yet implemented")
    }

    override fun afterTextChanged() {
        TODO("Not yet implemented")
    }


    override fun withBody() {
        super.withBody()
    }

}



/*
* Bir interface başka bir interface tarafından implement ediliyorsa  override edilmesi zorunlu olan fonksiyonların, override edilme zorunluluğu ortadan kalkyor abstract class lar da olduğu için
* onTextChanged override edildiği için, override edilme zorunluluğunu yitiriyor başka bir sınıfta.
*
*
*
*  */
interface ChildInterface: TextWatcher {

    override fun onTextChanged() {
        TODO("Not yet implemented")
    }
}


class InterfaceSample2: ChildInterface {

    override fun beforeTextChanged() {
        TODO("Not yet implemented")
    }

    override fun afterTextChanged() {
        TODO("Not yet implemented")
    }

}