package com.douglas.nutrisimples.api.products;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.nutrisimples.domain.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        log.info("Listando todos os produtos");
        return productRepository.findAll();
    }
    
    public Product findById(Long id) {
        log.info("Buscando produto de ID: " + id);
        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow(() -> new RuntimeException("Objeto não encontrado! ID: " + id));
    }
    
    public Product create(ProductDTO objectDTO) {
        log.info("Criando novo produto: " + objectDTO.name());
        Product newObj = new Product();
        newObj.setName(objectDTO.name());
        newObj.setPrice(objectDTO.price());
        newObj.setAmount(objectDTO.amount());
        newObj.setDescription(objectDTO.description());
        Product savedProduct = productRepository.save(newObj);
        log.info("Produto criado com sucesso: " + savedProduct);
        return savedProduct;
    }
    
    public Product update(Long id, ProductDTO objectDTO) {
        log.info("Atualizando produto de ID: " + id);
        Product obj = findById(id);
        obj.setName(objectDTO.name());
        obj.setPrice(objectDTO.price());
        obj.setAmount(objectDTO.amount());
        obj.setDescription(objectDTO.description());
        Product updatedProduct = productRepository.save(obj);
        log.info("Produto atualizado com sucesso: " + updatedProduct);
        return updatedProduct;
    }

    public boolean deleteById(Long id) {
        log.info("Deletando produto de ID: " + id);
        if (productRepository.findById(id).isPresent()) {
            productRepository.deleteById(id);
            log.info("Produto deletado com sucesso: ID " + id);
            return true;
        }
        log.warn("Produto com ID " + id + " não encontrado.");
        return false;
    }
    
}
