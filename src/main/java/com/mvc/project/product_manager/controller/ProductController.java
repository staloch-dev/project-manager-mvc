package com.mvc.project.product_manager.controller;

import com.mvc.project.product_manager.model.Product;
import com.mvc.project.product_manager.repository.ProductRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String listProducts(Model model, @RequestParam(defaultValue = "0") int page) {

        int pageSize = 5;
        Pageable pageConfig = PageRequest.of(page, pageSize);
        Page<Product> productsPage = productRepository.findAll(pageConfig);

        model.addAttribute("productsPage", productsPage);

        if (!model.containsAttribute("newProduct")) {
            model.addAttribute("newProduct", new Product());
        }
        return "index";
    }

    @PostMapping("/add")
    public String addProduct(@Valid @ModelAttribute("newProduct") Product product, BindingResult result, Model model) {
        
        if (result.hasErrors()) {
            int pageSize = 5;
            Pageable pageConfig = PageRequest.of(0, pageSize);
            Page<Product> productsPage = productRepository.findAll(pageConfig);

            model.addAttribute("productsPage", productsPage);

            return "index";
        }
        productRepository.save(product);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("ID de produto inválido: " + id));

        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") Long id, @Valid @ModelAttribute("product") Product product, BindingResult result) { 
        
        product.setId(id);

        if (result.hasErrors()) {
            return "edit";
        }
        productRepository.save(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("ID de produto inválido: " + id));

        productRepository.delete(product);
        return "redirect:/";
    }
}
