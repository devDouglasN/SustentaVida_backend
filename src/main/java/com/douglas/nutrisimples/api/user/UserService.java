package com.douglas.nutrisimples.api.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.douglas.nutrisimples.domain.User;
import com.douglas.nutrisimples.exceptions.ObjectNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public List<UserDTO> findAll() {
        log.info("Listando todos os usuários");
        return repository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public UserDTO findById(Long id) {
        log.info("Buscando usuário de ID: " + id);
        User user = repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado com o ID: " + id));
        return mapToDTO(user);
    }

    public UserDTO registerUser(UserDTO userDTO) {
        log.info("Registrando novo usuário: " + userDTO.name());
        repository.findByEmail(userDTO.email()).ifPresent(existingUser -> {
            throw new ObjectNotFoundException("Usuário com email " + userDTO.email() + " já existe.");
        });
        User user = new User(null, userDTO.name(), userDTO.email(), encoder.encode(userDTO.password()));
        user = repository.save(user);
        log.info("Usuário registrado com sucesso: " + user);
        return mapToDTO(user);
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        log.info("Atualizando usuário de ID: " + id);
        User user = repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado com o ID: " + id));
        user.setName(userDTO.name());
        user.setEmail(userDTO.email());
        user.setPassword(encoder.encode(userDTO.password()));
        user = repository.save(user);
        log.info("Usuário atualizado com sucesso: " + user);
        return mapToDTO(user);
    }

    public void deleteById(Long id) {
        log.info("Deletando usuário com ID: " + id);
        if (!repository.existsById(id)) {
            throw new ObjectNotFoundException("Usuário não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
        log.info("Usuário deletado com sucesso.");
    }

    private UserDTO mapToDTO(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), null);
    }
}
