package com.betrybe.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
  private ProductService productService;

  @Autowired
  public void setProductService(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public String getMessage() {
    return productService.getMessage();
  }
}
