package com.codeWithProjects.ecom.services.jwt.admin.adminproduct;

import com.codeWithProjects.ecom.dto.ProductDto;
import com.codeWithProjects.ecom.entity.Category;
import com.codeWithProjects.ecom.entity.Product;
import com.codeWithProjects.ecom.repository.CategoryRepository;
import com.codeWithProjects.ecom.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminProductServiceImpl implements AdminProductService{

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public ProductDto addProduct(ProductDto productDto) throws IOException {
        Product product = new Product();

        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImg(productDto.getImg().getBytes());

        Category category = categoryRepository.findById(productDto.getCategoryId()).orElseThrow();

        product.setCategory(category);

        return productRepository.save(product).getDto();
    }

    public List<ProductDto> getAllProducts(){
        List<Product> products = productRepository.findAll();

        return products.stream().map(Product :: getDto).collect(Collectors.toList());
    }

}
