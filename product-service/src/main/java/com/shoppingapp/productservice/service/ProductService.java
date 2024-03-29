package com.shoppingapp.productservice.service;

import com.shoppingapp.productservice.dto.ProductRequest;
import com.shoppingapp.productservice.dto.ProductResponse;
import com.shoppingapp.productservice.model.Product;
import com.shoppingapp.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
// at compile time it will create constructor with all contructor arguments
@RequiredArgsConstructor
// for adding logs
@Slf4j
public class ProductService {
   /* //@Autowired
    //private ProductRepository productRepo;

    //constructor dependency injection
    private final ProductRepository productRepo;
    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }*/
    private  final Logger log = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepository productRepo;
    public void createProduct(ProductRequest productRequest) {
        //map productRequest to product model
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepo.save(product);
        log.info("Product {} is saved", product.getId());

    }

    public List<ProductResponse> viewAllProducts() {
        List<Product> products = productRepo.findAll();
       List<ProductResponse> productResponses =  products.parallelStream().map(p->
             ProductResponse.builder()
                    .id(p.getId())
                    .name(p.getName())
                    .description(p.getDescription())
                    .price(p.getPrice())
                    .build()
        ).collect(Collectors.toList());

        return productResponses;

    }
}
