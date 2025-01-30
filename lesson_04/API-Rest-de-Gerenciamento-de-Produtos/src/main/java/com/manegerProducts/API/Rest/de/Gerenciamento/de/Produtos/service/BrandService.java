package com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.service;

import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.entity.Brand;
import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.repository.BrandRepository;
import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.service.exception.BrandNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
  private final BrandRepository brandRepository;

  @Autowired
  public BrandService(BrandRepository brandRepository) {
    this.brandRepository = brandRepository;
  }

  public Brand findById(Long id) throws BrandNotFoundException {
    return brandRepository.findById(id)
        .orElseThrow(BrandNotFoundException::new);
  }

  public List<Brand> findAll() {
    return brandRepository.findAll();
  }

  public Brand create(Brand brand) {
    return brandRepository.save(brand);
  }

  public Brand update(Long id, Brand brand) throws BrandNotFoundException {
    Brand brandInDb = findById(id);

    brandInDb.setName(brand.getName());

    return brandRepository.save(brandInDb);
  }

  public Brand delete(Long id) throws BrandNotFoundException {
    Brand brandInDb = findById(id);

    brandRepository.deleteById(id);

    return brandInDb;
  }
}
