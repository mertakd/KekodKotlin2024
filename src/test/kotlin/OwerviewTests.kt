import Basics.Overview.createName
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class Test {

    @Test
    fun testCreateNameReturnsString() {
        val result = createName()
        assertTrue(result is String, "Fonksiyon String türünden bir değer döndürmeli")
    }



    @Test
    fun testCreateNameReturnsNonEmptyString() {
        val result = createName()
        assertTrue(result.isNotEmpty(), "Fonksiyon boş olmayan bir String döndürmeli")
    }
}