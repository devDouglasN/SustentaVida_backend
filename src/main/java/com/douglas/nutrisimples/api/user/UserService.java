package com.douglas.nutrisimples.api.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.douglas.nutrisimples.domain.User;
import com.douglas.nutrisimples.exceptions.ObjectNotFoundException;
import com.douglas.nutrisimples.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

	@Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public List<User> findAll() {
        log.info("Listando todos os usuários");
        return repository.findAll();
    }

    public Optional<User> findById(Long id) {
        log.info("Buscando usuário de ID: " + id);
        return repository.findById(id)
            .map(Optional::of)
            .orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado com o ID: " + id));
    }

    public Optional<User> registerUser(User user) {
        log.info("Tentando registrar usuário com nome: " + user.getName());
        if (repository.findByUsuario(user.getName()).isPresent()) {
            log.warn("Usuário com nome " + user.getName() + " já existe.");
            return Optional.empty();
        }
        user.setPassword(encoder.encode(user.getPassword()));
        User savedUser = repository.save(user);
        log.info("Usuário registrado com sucesso: " + savedUser);
        return Optional.of(savedUser);
    }

    public Optional<User> updateUser(User user) {
        log.info("Tentando atualizar usuário com ID: " + user.getId());
        if (repository.findById(user.getId()).isPresent()) {
            user.setPassword(encoder.encode(user.getPassword()));
            User updatedUser = repository.save(user);
            log.info("Usuário atualizado com sucesso: " + updatedUser);
            return Optional.of(updatedUser);
        }
        log.warn("Usuário com ID " + user.getId() + " não encontrado.");
        return Optional.empty();
    }

    public boolean deleteById(Long id) {
        if (repository.findById(id).isPresent()) {
            log.info("Deletando usuário com ID: " + id);
            repository.deleteById(id);
            return true;
        }
        log.warn("Usuário com ID " + id + " não encontrado.");
        return false;
    }
}
