import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.argumentCaptor
import org.mockito.kotlin.doAnswer
import org.mockito.kotlin.mock

class SampleMockTest {

    @Test
    fun testVararg() {
        val mssgs = argumentCaptor<String>()
        val logger = mock<Logger> {
            on { logg(mssgs.capture()) } doAnswer {}
        }
        val sample = Sample(logger)
        sample.test()
        assertEquals(2, mssgs.allValues.size)
    }
}

class Sample(private val logger: Logger) {

    fun test() {
        logger.logg("test", "test2")
    }
}

open class Logger {

    open fun logg(vararg args: String) {
        val msg = args.joinToString()
        println(msg)
    }
}