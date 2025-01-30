package com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.service;

import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.entity.Category;
import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.repository.CategoryRepository;
import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.service.exception.CategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
  private final CategoryRepository categoryRepository;
  
  @Autowired
  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }
  
  public Category findById(Long id) throws CategoryNotFoundException {
    return categoryRepository.findById(id)
        .orElseThrow(CategoryNotFoundException::new);
  }

  public List<Category> findAll() {
    return categoryRepository.findAll();
  }

  public Category create(Category category) {
    return categoryRepository.save(category);
  }

  public Category update(Long id, Category category) throws CategoryNotFoundException {
    Category categoryInDb = findById(id);

    categoryInDb.setName(category.getName());

    return categoryRepository.save(categoryInDb);
  }

  public Category delete(Long id) throws CategoryNotFoundException {
    Category categoryInDb = findById(id);

    categoryRepository.deleteById(id);

    return categoryInDb;
  }
}
