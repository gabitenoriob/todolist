package br.com.gabrielatenorio.todolist.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Modificadores: pode ser public, private ou protected
 */
@RestController
@RequestMapping("/users")
public class UserController {
    
    //cadastro do cliente
    //requestbody = o que eu to recebdendo vem de dentro do body do userModel
    @PostMapping("/")
    public void create(@RequestBody UserModel userModel)
    {
        //printar no terminal p testar
        //System.out.println(userModel.name);


    }
}
