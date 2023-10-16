package br.com.gabrielatenorio.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data //é para dar get e set em todos os atributos, proprio do java (lombok)
@Entity(name = "tb_users")
public class UserModel {
    //modelo de usuario para ser instanciado na criação do usuario na classe controller metotodo create

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id; //id unica que sera a chave primaria do bd (@id) e uuid gera uma chavde doida unica

   
    private String name;
    @Column(unique = true)
    private String username; // se n bota nada = public
    private String password;


//private precisa de metodo get e set  para pegar e setar o valor do atributo
   
    @CreationTimestamp
    private LocalDateTime createdAt;
    
   


}
