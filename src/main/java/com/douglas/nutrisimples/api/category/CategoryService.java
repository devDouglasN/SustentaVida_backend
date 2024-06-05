package com.douglas.nutrisimples.api.category;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.nutrisimples.domain.Category;
import com.douglas.nutrisimples.exceptions.ObjectNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        log.info("Listando todas as categorias");
        return categoryRepository.findAll();
    }
    
    public Category findById(Long id) {
        log.info("Buscando categoria de ID: " + id);
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada com o ID: " + id));
    }
    
    public Category create(CategoryDTO categoryDTO) {
        log.info("Criando nova categoria: " + categoryDTO.name());
        Category newCategory = new Category();
        newCategory.setName(categoryDTO.name());
        newCategory.setDescription(categoryDTO.description());
        Category savedCategory = categoryRepository.save(newCategory);
        log.info("Categoria criada com sucesso: " + savedCategory);
        return savedCategory;
    }
    
    public Category update(Long id, CategoryDTO categoryDTO) {
        log.info("Atualizando categoria de ID: " + id);
        Category category = findById(id);
        category.setName(categoryDTO.name());
        category.setDescription(categoryDTO.description());
        Category updatedCategory = categoryRepository.save(category);
        log.info("Categoria atualizada com sucesso: " + updatedCategory);
        return updatedCategory;
    }

    public boolean deleteById(Long id) {
        log.info("Deletando categoria de ID: " + id);
        if (categoryRepository.findById(id).isPresent()) {
            categoryRepository.deleteById(id);
            log.info("Categoria deletada com sucesso: ID " + id);
            return true;
        }
        log.warn("Categoria com ID " + id + " não encontrada.");
        return false;
    }
}
