package com.example.apirest.servicio;

import com.example.apirest.modelo.Usuario;
import com.example.apirest.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class UsuarioServicio {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    public Usuario add(@RequestBody Usuario user) {
        return usuarioRepositorio.save(user);
    }

    public List<Usuario> list() {
        return usuarioRepositorio.findAll();
    }

    public Usuario updateUser(@PathVariable int id, @RequestBody Usuario userDetails) {
        Usuario user = usuarioRepositorio.findById(id).orElseThrow();
        user.setNombre(userDetails.getNombre());
        user.setEdad(userDetails.getEdad());
        return usuarioRepositorio.save(user);
    }

    public Usuario getNoteById(@PathVariable int id) {
        return usuarioRepositorio.findById(id).orElse(null);
    }


    public String deleteUser(@PathVariable int id) {
        Usuario usuarioExistente = usuarioRepositorio.findById(id).orElse(null);
        if (usuarioExistente != null){
            usuarioRepositorio.delete(usuarioExistente);
            return "El usuario se ha borrado con exito";
        }
        return "No hay ningun usuario para eliminar";

    }
}
