package com.example.persistencia_validacao;

import com.example.persistencia_validacao.entity.Product;
import com.example.persistencia_validacao.repository.ProductRepository;
import com.example.persistencia_validacao.service.ProductService;
import org.assertj.core.matcher.AssertionMatcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("Teste cama de serviço Product")
public class ProductServiceTest {
  @Autowired
  ProductService productService;

  @MockBean
  ProductRepository productRepository;

  @Test
  @DisplayName("Test do metodo create")
  public void create() {
    Product product = new Product();
    product.setName("Queijo");
    product.setManufactureDate(LocalDate.now());
    product.setExpirationDate(LocalDate.now().plusMonths(2));

    Mockito.when(productRepository.save(product))
        .thenReturn(product);
    
    Product savedProduct = productRepository.save(product);

    Assertions.assertEquals(product.getName(), savedProduct.getName());
    Assertions.assertEquals(product.getExpirationDate(), savedProduct.getExpirationDate());
    Assertions.assertEquals(product.getManufactureDate(), savedProduct.getManufactureDate());
  }

  @Test
  @DisplayName("Teste metodo find")
  public void findAll() {
  }
}