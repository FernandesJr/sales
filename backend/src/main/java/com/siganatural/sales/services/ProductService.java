package com.siganatural.sales.services;

import com.siganatural.sales.dto.ProductDTO;
import com.siganatural.sales.entities.Product;
import com.siganatural.sales.repositories.ProductRepository;
import com.siganatural.sales.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findProducts(){
        return repository.findAll().stream().map(p -> new ProductDTO(p)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> findProductsActives(){
        return repository.findByActive(true).stream().map(p -> new ProductDTO(p)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProductDTO findProduct(Long id){
        Product entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new ProductDTO(entity);
    }

    @Transactional
    public ProductDTO insertProduct(ProductDTO dto){
        Product entity = new Product();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setActive(true);
        repository.save(entity);
        return new ProductDTO(entity);
    }

    @Transactional
    public ProductDTO updateProduct(ProductDTO dto, Long id) {
        Product entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setActive(dto.isActive());
        return new ProductDTO(entity);
    }
}
