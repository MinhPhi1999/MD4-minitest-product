package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//Product: id, name, price, category
//        - Category: id, name
//        - Viết các API:
//        1. Hiện danh sách
//        2. Tìm theo tên
//        3. Hiện danh sách sắp xếp tăng dần
//        4. Hiện 4 sản phẩm mới nhất
//        Nâng cao:
//        1. Hiện sản phẩm 1 loại nào đó
//        2. Hiện sản phẩm theo khoảng giá"

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<Iterable<Product>> findAll(){
        Iterable<Product> products = productService.findAll();
        if (products == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Product> viewProduct(@PathVariable String name){
        Optional<Product> productOptional = productService.findAllByNameContaining(name);
        if(!productOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
    }
}
