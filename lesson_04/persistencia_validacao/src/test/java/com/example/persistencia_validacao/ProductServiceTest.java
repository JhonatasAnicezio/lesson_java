package com.example.persistencia_validacao;

import com.example.persistencia_validacao.entity.Product;
import com.example.persistencia_validacao.repository.ProductRepository;
import com.example.persistencia_validacao.service.ProductService;
import com.example.persistencia_validacao.service.exception.ProductNotFound;
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
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("Teste camada de serviço Product")
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

    Mockito.verify(productRepository).save(product);
  }

  @Test
  @DisplayName("Teste metodo findAll")
  public void findAll() {
    LocalDate hoje = LocalDate.now();
    Product product = new Product("Alface", hoje, hoje.plusWeeks(2));
    product.setId(1L);

    List<Product> products = List.of(product);

    Mockito.when(productRepository.findAll())
        .thenReturn(products);

    List<Product> listProducts = productService.findAll();

    Assertions.assertEquals(listProducts, products);

    Mockito.verify(productRepository).findAll();
  }

  @Test
  @DisplayName("Test metodo fingById")
  public void findById() throws ProductNotFound {
    LocalDate hoje = LocalDate.now();
    Product product = new Product("Alface", hoje, hoje.plusWeeks(2));
    product.setId(1L);

    Mockito.when(productRepository.findById(1L))
        .thenReturn(Optional.of(product));

    Mockito.when(productRepository.findById(2L))
        .thenReturn(Optional.empty());

    Product findProduct = productService.findById(1L);

    Assertions.assertEquals(findProduct, product);
    Assertions.assertThrows(ProductNotFound.class, () -> productService.findById(2L));
  }

  @Test
  @DisplayName("Test do metodo update")
  public void update() throws ProductNotFound {
    LocalDate hoje = LocalDate.now();
    Product product = new Product("Alface", hoje, hoje.plusWeeks(2));
    product.setId(1L);

    Product newProduct = new Product("Almeirao", hoje, hoje.plusWeeks(2));
    newProduct.setId(1L);

    Mockito.when(productRepository.findById(1L))
        .thenReturn(Optional.of(product));

    Mockito.when(productRepository.findById(2L))
            .thenReturn(Optional.empty());

    Mockito.when(productRepository.save(product))
        .thenReturn(newProduct);

    Product savedProduct = productService.update(newProduct, 1L);

    Assertions.assertNotEquals(product, savedProduct);
    Assertions.assertEquals(product.getId(), savedProduct.getId());
    Assertions.assertThrows(ProductNotFound.class, () ->
        productService.update(newProduct, 2L));
  }

  @Test
  @DisplayName("Test metodo delete")
  public void delete() throws ProductNotFound {
    LocalDate hoje = LocalDate.now();
    Product product = new Product("Alface", hoje, hoje.plusWeeks(2));
    product.setId(1L);

    Mockito.when(productRepository.findById(1L))
        .thenReturn(Optional.of(product));

    Mockito.when(productRepository.findById(2L))
        .thenReturn(Optional.empty());

    Product productDb = productService.delete(1L);

    Assertions.assertEquals(product, productDb);
    Assertions.assertThrows(ProductNotFound.class, () ->
        productService.delete(2L));
  }
}