package com.example.persistencia_validacao;

import com.example.persistencia_validacao.controller.dto.ProductCreationDto;
import com.example.persistencia_validacao.entity.Product;
import com.example.persistencia_validacao.service.ProductService;
import com.example.persistencia_validacao.service.exception.ProductNotFound;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DisplayName("Teste da camada de controller")
public class ControllerServiceTest {
  @Autowired
  MockMvc mockMvc;

  @MockBean
  ProductService productService;

  @Test
  @DisplayName("Teste requisição GET /products")
  public void findAll() throws Exception {
    LocalDate hoje = LocalDate.now();
    Product product = new Product("Alface", hoje, hoje.plusWeeks(2));
    product.setId(1L);

    Mockito.when(productService.findAll())
        .thenReturn(List.of(product));

    mockMvc.perform(get("/products"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].name").value(product.getName()))
        .andExpect(jsonPath("$[0].expirationDate").value(product.getExpirationDate().toString()))
        .andExpect(jsonPath("$[0].manufactureDate").value(product.getManufactureDate().toString()));
  }

  @Test
  @DisplayName("Teste requisição GET /products/{id}")
  public void findById() throws ProductNotFound, Exception {
    LocalDate hoje = LocalDate.now();
    Product product = new Product("Queijo", hoje, hoje.plusMonths(3));
    product.setId(1L);

    Mockito.when(productService.findById(1L))
        .thenReturn(product);

    Mockito.when(productService.findById(2L))
        .thenThrow(ProductNotFound.class);

    mockMvc.perform(MockMvcRequestBuilders.get("/products/1"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L));

    mockMvc.perform(MockMvcRequestBuilders.get("/products/2"))
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  @Test
  @DisplayName("Testando POST /products")
  public void create() throws Exception {
    LocalDate hoje = LocalDate.of(2024, 2, 7);
    Product product = new Product("Ballantines", hoje, hoje.plusMonths(1));
    product.setId(1L);

    String jsonBody = "{ \"name\": \"Ballantines\", \"manufactureDate\": \"2024-02-07\", \"expirationDate\": \"2024-03-07\" }";

    Mockito.when(productService.create(any()))
        .thenReturn(product);

    mockMvc.perform(post("/products")
            .contentType("application/json")
            .content(jsonBody))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.name").value("Ballantines"));

    Mockito.verify(productService).create(any());
  }

  @Test
  @DisplayName("Teste PUT /products/{id}")
  public void update() throws ProductNotFound, Exception {
    LocalDate hoje = LocalDate.of(2024, 2, 7);
    Product upProduct = new Product("JackDaniels", hoje, hoje.plusMonths(1));
    upProduct.setId(1L);

    Mockito.when(productService.update(Mockito.any(Product.class), Mockito.eq(1L)))
        .thenReturn(upProduct);

    Mockito.when(productService.update(Mockito.any(Product.class), Mockito.eq(2L)))
        .thenThrow(ProductNotFound.class);

    String jsonUpProduct = "{ \"name\": \"JackDaniels\", \"manufactureDate\": \"2024-02-07\", \"expirationDate\": \"2024-03-07\" }";

    mockMvc.perform(put("/products/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content(jsonUpProduct))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1));

    Mockito.verify(productService).update(Mockito.any(Product.class), Mockito.eq(1L));

    mockMvc.perform(put("/products/2")
        .contentType(MediaType.APPLICATION_JSON)
        .content(jsonUpProduct))
        .andExpect(status().isNotFound());

    Mockito.verify(productService).update(Mockito.any(Product.class), Mockito.eq(2L));
  }

  @Test
  @DisplayName("Test DELETE /products/{id}")
  public void deleteMethod() throws ProductNotFound, Exception {
    LocalDate today = LocalDate.now();
    Product product = new Product("JackDaniels", today, today.plusMonths(1000));
    product.setId(1L);

    Mockito.when(productService.delete(1L))
        .thenReturn(product);

    Mockito.when(productService.delete(2L))
        .thenThrow(ProductNotFound.class);

    mockMvc.perform(delete("/products/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1L));

    mockMvc.perform(delete("/products/2"))
        .andExpect(status().isNotFound());

    Mockito.verify(productService).delete(1L);
    Mockito.verify(productService).delete(2L);
  }
}
