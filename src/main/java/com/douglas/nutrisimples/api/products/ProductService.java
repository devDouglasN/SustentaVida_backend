package com.douglas.nutrisimples.api.products;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.nutrisimples.domain.Product;
import com.douglas.nutrisimples.exceptions.ObjectNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> findAll() {
        log.info("Listando todos os produtos");
        return productRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO findById(Long id) {
        log.info("Buscando produto de ID: " + id);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado! ID: " + id));
        return mapToDTO(product);
    }

    public ProductDTO create(ProductDTO productDTO) {
        log.info("Criando novo produto: " + productDTO.name());
        Product product = new Product();
        product.setName(productDTO.name());
        product.setPrice(productDTO.price());
        product.setAmount(productDTO.amount());
        product.setDescription(productDTO.description());
        product = productRepository.save(product);
        log.info("Produto criado com sucesso: " + product);
        return mapToDTO(product);
    }

    public ProductDTO update(Long id, ProductDTO productDTO) {
        log.info("Atualizando produto de ID: " + id);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado com o ID: " + id));
        product.setName(productDTO.name());
        product.setPrice(productDTO.price());
        product.setAmount(productDTO.amount());
        product.setDescription(productDTO.description());
        product = productRepository.save(product);
        log.info("Produto atualizado com sucesso: " + product);
        return mapToDTO(product);
    }

    public void deleteById(Long id) {
        log.info("Deletando produto de ID: " + id);
        if (!productRepository.existsById(id)) {
            log.warn("Produto com ID " + id + " não encontrado.");
            throw new ObjectNotFoundException("Produto não encontrado com o ID: " + id);
        }
        productRepository.deleteById(id);
        log.info("Produto deletado com sucesso.");
    }

    private ProductDTO mapToDTO(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getPrice(), product.getAmount(), product.getDescription());
    }
}
