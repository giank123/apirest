package com.example.apirest.controlador;

import com.example.apirest.modelo.Usuario;
import com.example.apirest.repository.UsuarioRepositorio;
import com.example.apirest.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    /*
    GET   ->  Listar
    POST  ->  Crear
    PUT   ->  Actualizar
    DELETE -> Borrar
     */

    @Autowired
    UsuarioServicio usuarioServicio;

    @PostMapping("/create")
    public Usuario add(@RequestBody Usuario user) {
       return usuarioServicio.add(user);
    }

    @GetMapping("/listar")
    public List<Usuario> list() {
        return usuarioServicio.list();
    }

    @PutMapping("/updateUser/{id}")
    public Usuario updateUser(@PathVariable int id, @RequestBody Usuario userDetails) {
        return usuarioServicio.updateUser(id, userDetails);
    }

    @GetMapping("/obtenerId/{id}")
    public Usuario getNoteById(@PathVariable int id) {
        return usuarioServicio.getNoteById(id);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id) {
        return  usuarioServicio.deleteUser(id);
    }

}
