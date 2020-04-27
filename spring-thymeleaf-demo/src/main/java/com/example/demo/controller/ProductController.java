package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/products")
    public String listProducts(Model model){

        model.addAttribute("products", productService.getAllProduct());

        return "products";
    }
    
    @GetMapping("/products/{id}")
    public String getProductById(@PathVariable int id, Model model)
    {
    	model.addAttribute("product", productService.findById(id));
    	return "product";
    }
    
    @RequestMapping("/product/new")
    public String newProduct(Model model)
    {
    	model.addAttribute("product", new Product());
    	return "productform";
    }
    
    @PostMapping("/product")
    public String saveOrUpdateProduct(Product product)
    {
    	productService.saveOrUpdateProduct(product);
    	return "redirect:/products/";
    }
    
    @RequestMapping("/product/update")
    public String updateProduct(Model model)
    {
    	model.addAttribute("product", new Product());
    	return "productupdateform";
    }
}
