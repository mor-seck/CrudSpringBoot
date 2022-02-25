package co.test.test;


import co.test.test.entities.Product;
import co.test.test.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RunnerProduct  implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run( String... args) throws Exception{

        Product product1 = new Product("Iphone 6S", "Telephone",56000);
        Product product2 = new Product("Oreimo", "Casque",6000);
        Product product3 = new Product("Coque", "Protége",5000);
        Product product4 = new Product("Samsung", "Telephone",56000);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
    }
}
