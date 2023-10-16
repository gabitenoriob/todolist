package br.com.gabrielatenorio.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;



//mudou de class p interface , nao tem a implemnetação so a representação
public interface InterfaceUserRepository extends JpaRepository<UserModel,UUID>//classe q referencia e tipo
{
    UserModel findByUsername(String username);
}
