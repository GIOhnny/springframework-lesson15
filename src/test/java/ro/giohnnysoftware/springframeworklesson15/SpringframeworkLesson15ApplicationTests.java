package ro.giohnnysoftware.springframeworklesson15;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ro.giohnnysoftware.springframeworklesson15.repositories.ProductRepository;
import ro.giohnnysoftware.springframeworklesson15.services.ProductService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class SpringframeworkLesson15ApplicationTests {

    //Mock == Fake object
    @MockBean
    private ProductRepository productRepositoryFake;

    @Autowired
    private ProductService productService;

    @Test
    void noProductsReturnedTest() {
        //assumptions
        given(productRepositoryFake.getProductNames()).willReturn(Collections.emptyList());

        //call of the method
        List<String> res = productService.getProductNamesWithEvenNoOfChar();

        //assertions
        assertTrue(res.isEmpty());
    }

    @Test
    void moreProductsAreFoundTest() {
        List<String> input = Arrays.asList("aa","bbbb","ccc");
        //assumptions
        given(productRepositoryFake.getProductNames()).willReturn(input);

        //call of the method
        List<String> res = productService.getProductNamesWithEvenNoOfChar();

        //assertions
        assertEquals(2,res.size());

    }

}
