package com.example.casasbahia

import com.example.casasbahia.models.ProductTest
import com.example.casasbahia.utils.Utils
import org.junit.AfterClass
import org.junit.Assert.*
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ProductUnitTest {

    lateinit var testProduct: ProductTest;

    @Before
    fun initialize() {
        testProduct = ProductTest("TV Samsung FULL HD", 1399.00);
    }

    @Test
    fun priceValid() {
        assert(testProduct.CurrentPrice > 0)
    }

    @Test
    fun isPriceFormatCorrect() {
        assertEquals("R$ 1.399,00", Utils.ConvertPrice(testProduct.CurrentPrice));
    }

    @Test
    fun nameIsNotNull() {
        assertNotNull(testProduct.Name);
    }

    @Test
    fun nameIsNotEmpty() {
        assertFalse(testProduct.Name == "");
    }
}
