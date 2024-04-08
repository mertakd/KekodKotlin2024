package OOP.InheritanceAndPolymorphism.ClassesContinue


class Rectangle3(val width: Int, val height: Int) {
    val area: Int // property type is optional since it can be inferred from the getter's return type
        get() = this.width * this.height
}









// fonksiyon içinde getter ve setter lara erişilemez
//bunu nedeni local fonksiyonların değerlerine dışarıdan erişemiyoruz.
// ama bir class içinde ki üye değişkene dışarıdan erişebiliriz. çünkü class nesnesini bir yerde oluşturup, o class ın içinde üye değişken veya fonksiyonlara erişebiliriz.
/*

fun main() {

    var myProperty: Int = 0
        get() = field * 2
        set(value) {
            field = value + 1
        }
}

*/



//Getter ve setter'lar özelleştirildiğinde, bu durum genellikle değer dönüşümü, doğrulama, başka bir özellikle ilişkilendirme veya diğer özel işlemler için yapılır. Ancak, backing field'ın değeri bu özelleştirmelerden etkilenmez.
class Property {

    var myProperty: Int = 0
        get() = field * 2  // Getter özelleştirildi
        set(value) {
            field = value + 1  // Setter özelleştirildi
        }
}

fun main() {
    val obj = Property()
    obj.myProperty = 5
    println(obj.myProperty)  // Çıktı: 11 (5 * 2 + 1)
}





// return ettiğimiz yani geri döndürdüğümüz şey backing field ın kendisi
// 2:56:00 Ders14: Classes Continue

private var _table: Map<String, Int>? = null
public val table: Map<String, Int>
    get() {
        if (_table == null) {
            _table = HashMap() // Type parameters are inferred
        }
        return _table ?: throw AssertionError("Set to null by another thread")
    }



