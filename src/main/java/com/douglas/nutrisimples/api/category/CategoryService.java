package com.douglas.nutrisimples.api.category;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<CategoryDTO> findAll() {
        log.info("Listando todas as categorias");
        return categoryRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public CategoryDTO findById(Long id) {
        log.info("Buscando categoria de ID: " + id);
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada com o ID: " + id));
        return mapToDTO(category);
    }

    public CategoryDTO create(CategoryDTO categoryDTO) {
        log.info("Criando nova categoria: " + categoryDTO.name());
        Category category = new Category();
        category.setName(categoryDTO.name());
        category.setDescription(categoryDTO.description());
        category = categoryRepository.save(category);
        log.info("Categoria criada com sucesso: " + category);
        return mapToDTO(category);
    }

    public CategoryDTO update(Long id, CategoryDTO categoryDTO) {
        log.info("Atualizando categoria de ID: " + id);
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada com o ID: " + id));
        category.setName(categoryDTO.name());
        category.setDescription(categoryDTO.description());
        category = categoryRepository.save(category);
        log.info("Categoria atualizada com sucesso: " + category);
        return mapToDTO(category);
    }

    public void deleteById(Long id) {
        log.info("Deletando categoria de ID: " + id);
        if (!categoryRepository.existsById(id)) {
            log.warn("Categoria com ID " + id + " não encontrada.");
            throw new ObjectNotFoundException("Categoria não encontrada com o ID: " + id);
        }
        categoryRepository.deleteById(id);
        log.info("Categoria deletada com sucesso.");
    }

    private CategoryDTO mapToDTO(Category category) {
        return new CategoryDTO(category.getId(), category.getName(), category.getDescription(), null);
    }
}
