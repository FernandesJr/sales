package com.siganatural.sales.dto;

import com.siganatural.sales.entities.Product;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductDTO {

    private Long id;

    @Size(min = 3, max = 255)
    @NotBlank(message = "nome é requerido")
    private String name;

    @Size(min = 3, max = 255)
    private String description;

    @NotNull(message = "informe o preço de venda do produto")
    private Double price;

    private MultipartFile image;

    public ProductDTO(){}

    public ProductDTO(Long id, String name, String description, Double price, MultipartFile image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public ProductDTO(Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.price = entity.getPrice();
        //this.image = new MockMultipartFile("photo.png", "photo.png", "image/png", entity.getImage());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
