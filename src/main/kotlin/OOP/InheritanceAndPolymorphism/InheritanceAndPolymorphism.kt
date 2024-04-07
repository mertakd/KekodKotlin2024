package OOP.InheritanceAndPolymorphism


/**
 * Inheritance, ortak alınabilecek tüm child(alt sınıflar) sınıflar tarafından kullanılabilecek değişken ve fonksiyonları alıp bir üst class a koyma işlemi. Üst class Animal(), alt classlara örenek ise Cat(), Dog()
 * Access Modifiers : final, open bunlar class ın önüne getiriliyor. visibility modifier(Private,Protected,Internal,Public) ile karıştırılmamalı.
 *
 * Java da extends ile inherit ediliyor
 * extend edilen sınıf Animal() constructor u vermemiz lazım
 * üst class miras alınacaksa open keyword u koymamız gerekir. kotlin de default olarak bu final dır. Java da default olarak public kullanır.
 * Bir sınıf içinde ki değişkenlere veya fonksiyonlara open keyword u vermezsek bunuları child class larda çağırabiliyoruz ama dinamik polimorfizm yapamıyoruz. dinamik polimorfizm yapmak için değişkenlere ve fonksiyonlara open keyword unu koymamız gerekir.
 *
 * Alt sınıfların constroctor unda parametre ye val/var vermeyince o değer üst sınıfın değeri oluyor. val/var verirsek alt sınıfın bir değeri olarak olarak görüyor ide.
   Çünkü dog classı içerisinde name değişkenine erişemiyoruz val veya var ile tanımlamadığımız için class içerisinde de erişemeyiz.
   Önceki derste işlemiştik val/var vermez isek class ın init fonksiyonun içerisi hariç başka yerden erişemiyoruz.
   Bu durumda val/var verirsek dog un kendi içerisinde bir name değişkeni, Animal ın da kendi içerisinde name değişkeni olur.
 *
 * Aynı değişken veya fonksiyonun child class lar tarafından kullanılırken farklı sonuçlar üretmesine çok biçimlilik yani Polimorfizm denir.
 * Fonksiyon overloading ile statik polimorphizm yapılabilir. Yani aynı fonksiyonların ayrı sonuç içermesine statik polimorphism denir.
   Üst class dan gelen bir fonksiyonu override etmesine dinamik polimorphism deniliyor.
   Statik denmesinin nedeni fonksiyonların üreteceği değerin belli olması. Dinamik de ise fonksiyonu farklı bir sınıfa göre implement ediyor. üst sınıfta değeri uygulanmış bir fonksiyon değil alt sınıflara göre implement ediliyor.
   Kısaca dinamik de değişimi göremiyorken, statik de değişimi görebiliyoruz.
 *
 *
 *
 *
 *
 *
 *
 * */
open class Animal(open val name: String = "", var feetCount: Int = 4) {



    var origin: String = "Sivas Knagalı"
    var tailShape: String = "oval"


    open fun makeASound():String{
        return "hav hav"
    }

    fun attackToTheWolf(){

    }

    fun eat(){

    }

    fun walk(){

    }

    fun dance(){

    }



}



class Dog(name: String, feetCount: Int): Animal(name, feetCount){


    // Dinamik Polymorphism
    override fun makeASound(): String {
        return "hav hav "
    }





    // Statik Polymorphism
    fun call(gokhan: Gokhan){
        gokhan.foo()
    }

    fun call(baris: Baris){
        baris.boo()
    }


}



class Gokhan {
    fun foo() {
        TODO("Not yet implemented")
    }

}

class Baris{
    fun boo() {
        TODO("Not yet implemented")
    }

}


class Cat(override val name: String, feetCount: Int): Animal(name, feetCount){


    override fun makeASound(): String {
        return "miyavvv"
    }




}


fun main() {
    val animal = Animal()
    val dog = Dog("fino",4)
    val cat = Cat("çapkın",4)


    dog.name
    cat.name

    dog.attackToTheWolf()
    cat.attackToTheWolf()
}