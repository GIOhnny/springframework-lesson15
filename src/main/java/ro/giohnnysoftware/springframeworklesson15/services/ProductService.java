package ro.giohnnysoftware.springframeworklesson15.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.giohnnysoftware.springframeworklesson15.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

/*
Annotations
  @Before      ---> @BeforeEach call every test
  @BeforeClass ---> @BeforeAll  call once
  @After
  @AfterClass
 */
    public List<String> getProductNamesWithEvenNoOfChar() {
        List<String> names = productRepository.getProductNames();
//Java 6
/*
        List<String> result = new ArrayList<>();
        for (String n: names) {
            if (n.length()% 2 == 0) {
                result.add(n);
            }
        }
        return result;
*/
//Java 8
        return names.stream()
                .filter(n->n.length() % 2 == 0)
                .collect(Collectors.toList());
    }
}
