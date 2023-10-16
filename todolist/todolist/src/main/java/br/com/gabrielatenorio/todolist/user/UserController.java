package br.com.gabrielatenorio.todolist.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

/**
 * Modificadores: pode ser public, private ou protected
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired //gerencia o ciclo 
    private InterfaceUserRepository userRepository;

    
    //cadastro do cliente
    //requestbody = o que eu to recebdendo vem de dentro do body do userModel
    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel)
    {

        //vendo se ja existe user 
        var user = this.userRepository.findByUsername(userModel.getUsername());
        if(user != null)
        {
            //retorna mensagem de erro e status code
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");
        }


//criptografar senhaa
       var passwordHashred = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());

       userModel.setPassword(passwordHashred);

       //salvando o usuario criado no banco de dados(.save) e o usuario é criado na classe usermodel
        var userCreated = this.userRepository.save(userModel);
        return  ResponseEntity.status(HttpStatus.OK).body(userCreated);


    }
}
