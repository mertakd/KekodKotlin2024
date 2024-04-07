package OOP.InheritanceAndPolymorphism.ClassesContinue



class Example: Any(){
    // Implicitly inherits from Any
    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return super.toString()
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}











open class Base22(p: Int)

class Derived22(p: Int) : Base22(p)






//super üst class a işaret ediyor
// bir class ın üst class a sahipse ve primary cons yoksa super kullanıyoruz.

/*

open class View(context: Context){}

class MyView : View {
    constructor(ctx: Context) : super(ctx)

    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
}

*/







/*


//fill fonksiyonunu override edemiyoruz open olmadığı için default olarak final çünkü.
//override fun draw() override yazmak zorunda


open class Shape {
    open fun draw() { */
/*...*//*
 }
    fun fill() { */
/*...*//*
 }
}

class Circle() : Shape() {
    override fun draw() { */
/*...*//*
 }
}


*/






/*
* Override etmek istemiyorsak final keyword unu koyarız.
*
* open class Rectangle() : Shape() {
    final override fun draw() { /*...*/ }
}
*
*
* */







/*
* properties override
*
* open class Shape {
    open val vertexCount: Int = 0
}

class Rectangle : Shape() {
    override val vertexCount = 4
}

*
*
*
* */


/*
* ister constructor dışında ister içinde override edilebilir
*
* interface Shape {
    val vertexCount: Int
}


class Rectangle(override val vertexCount: Int = 4) : Shape // Always has 4 vertices


class Polygon : Shape {
    override var vertexCount: Int = 0  // Can be set to any number later
}
*
*
* */



open class Base(val name: String) {

    init { println("Initializing a base class") }

    open val size: Int =
        name.length.also { println("Initializing size in the base class: $it") }
}

class Derived(
    name: String,
    val lastName: String,
) : Base(name.replaceFirstChar { it.uppercase() }.also { println("Argument for the base class: $it") }) {

    init { println("Initializing a derived class") }

    override val size: Int =
        (super.size + lastName.length).also { println("Initializing size in the derived class: $it") }
}

fun main() {
    val derived = Derived("Hello", "Word")



}


/*


Rectangle sınıfımızda yaptığımız işlemi ilk baş gösterir sonra başka bir iş yapıyorsa onun çıktısını verir.
open class Rectangle {
    open fun draw() { println("Drawing a rectangle") }
    val borderColor: String get() = "black"
}

class FilledRectangle : Rectangle() {
    override fun draw() {
        super.draw()
        println("Filling the rectangle")
    }

    val fillColor: String get() = super.borderColor
}

*/



/*


open class Rectangle {
    open fun draw() { println("Drawing a rectangle") }
    val borderColor: String get() = "black"
}


class FilledRectangle: Rectangle() {
    override fun draw() {
        val filler = Filler()
        filler.drawAndFill()
    }

    inner class Filler {
        fun fill() { println("Filling") }
        fun drawAndFill() {
            super@FilledRectangle.draw() // Calls Rectangle's implementation of draw()
            fill()
            println("Drawn a filled rectangle with color ${super@FilledRectangle.borderColor}") // Uses Rectangle's implementation of borderColor's get()
        }
    }
}


*/


open class Rectangle {
    open fun draw() { /* ... */ }
}

interface Polygon {
    fun draw() { /* ... */ } // interface members are 'open' by default
}

class Square() : Rectangle(), Polygon {
    // The compiler requires draw() to be overridden:
    override fun draw() {
        super<Rectangle>.draw() // call to Rectangle.draw()
        super<Polygon>.draw() // call to Polygon.draw()
    }
}