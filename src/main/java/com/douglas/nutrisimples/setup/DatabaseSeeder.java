package com.douglas.nutrisimples.setup;

import com.douglas.nutrisimples.api.category.CategoryRepository;
import com.douglas.nutrisimples.api.products.ProductRepository;
import com.douglas.nutrisimples.api.user.UserRepository;
import com.douglas.nutrisimples.domain.Category;
import com.douglas.nutrisimples.domain.Product;
import com.douglas.nutrisimples.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        Category category1 = new Category(null, "Bebidas", "Bebidas alcoólicas e não alcoólicas");
        Category category2 = new Category(null, "Alimentos", "Alimentos diversos, incluindo vegetais, frutas e carnes");
        Category category3 = new Category(null, "Higiene", "Produtos de higiene pessoal e limpeza");

        List<Category> categories = Arrays.asList(category1, category2, category3);
        List<Category> savedCategories = categoryRepository.saveAll(categories);

        Product product1 = new Product(null, "Coca-Cola", new BigDecimal("5.99"), 100, "Refrigerante de cola", savedCategories.get(0));
        Product product2 = new Product(null, "Suco de Laranja", new BigDecimal("4.49"), 50, "Suco natural de laranja", savedCategories.get(0));
        Product product3 = new Product(null, "Arroz Integral", new BigDecimal("9.99"), 200, "Arroz integral orgânico", savedCategories.get(1));
        Product product4 = new Product(null, "Feijão Preto", new BigDecimal("8.99"), 150, "Feijão preto tradicional", savedCategories.get(1));
        Product product5 = new Product(null, "Sabonete Líquido", new BigDecimal("12.49"), 80, "Sabonete líquido antibacteriano", savedCategories.get(2));
        Product product6 = new Product(null, "Shampoo", new BigDecimal("15.99"), 70, "Shampoo para todos os tipos de cabelo", savedCategories.get(2));
        Product product7 = new Product(null, "Frango Orgânico", new BigDecimal("29.99"), 40, "Frango orgânico resfriado", savedCategories.get(1));
        Product product8 = new Product(null, "Banana", new BigDecimal("3.99"), 120, "Banana prata", savedCategories.get(1));
        Product product9 = new Product(null, "Água Mineral", new BigDecimal("2.99"), 300, "Água mineral sem gás", savedCategories.get(0));
        Product product10 = new Product(null, "Desinfetante", new BigDecimal("8.49"), 60, "Desinfetante para superfícies", savedCategories.get(2));

        List<Product> products = Arrays.asList(product1, product2, product3, product4, product5, product6, product7, product8, product9, product10);
        productRepository.saveAll(products);

        User user = new User(null, "Douglas Nascimento", "douglas.nascimento@mail.com", passwordEncoder.encode("123456"));
        User user1 = new User(null, "Ana Silva", "ana.silva@mail.com", passwordEncoder.encode("123"));
        User user2 = new User(null, "Carlos Pereira", "carlos.pereira@mail.com", passwordEncoder.encode("senha123"));
        User user3 = new User(null, "Mariana Costa", "mariana.costa@mail.com", passwordEncoder.encode("senha123"));
        User user4 = new User(null, "João Souza", "joao.souza@mail.com", passwordEncoder.encode("senha123"));
        User user5 = new User(null, "Fernanda Oliveira", "fernanda.oliveira@mail.com", passwordEncoder.encode("senha123"));
        User user6 = new User(null, "Lucas Fernandes", "lucas.fernandes@mail.com", passwordEncoder.encode("senha123"));
        User user7 = new User(null, "Gabriela Lima", "gabriela.lima@mail.com", passwordEncoder.encode("senha123"));
        User user8 = new User(null, "Rafael Gomes", "rafael.gomes@mail.com", passwordEncoder.encode("senha123"));
        User user9 = new User(null, "Laura Santos", "laura.santos@mail.com", passwordEncoder.encode("senha123"));
        User user10 = new User(null, "Pedro Almeida", "pedro.almeida@mail.com", passwordEncoder.encode("senha123"));

        List<User> users = Arrays.asList(user, user1, user2, user3, user4, user5, user6, user7, user8, user9, user10);
        userRepository.saveAll(users);
    }
}
