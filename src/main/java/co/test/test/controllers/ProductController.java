package co.test.test.controllers;

import co.test.test.entities.Product;
import co.test.test.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;



@Controller
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController (ProductRepository productRepository){
        this.productRepository= productRepository;
    }

    @GetMapping
    public String showProducts(Model model){
       model.addAttribute("products", productRepository.findAll());
       return "index";
    }

    @GetMapping("/newProduct")
    public String newProduct(Product product){
        return "new-product";
    }

    @PostMapping("/addProduct")
    public String addProducts(@Valid Product product, BindingResult result, Model model){
        //Todo return to view if error
        productRepository.save(product);
        return "redirect:/";
    }


    @PostMapping("/updateProduct/{id}")
    public String updateProducts(@Valid Product product, BindingResult result, Model model){
        productRepository.save(product);
        return "redirect:/";
    }


    @GetMapping("/editeProduct/{id}")
    public String editProduct(@PathVariable("id") long id, Model model){
        Product product = productRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Product Id" + id));
        model.addAttribute("product",product);
        return "edit-product";
    }


    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") long id, Model model){
        Product product = productRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Product Id" + id));
        productRepository.delete(product);
        return "redirect:/";
    }



}
