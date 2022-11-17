package com.arioc.pro.web;

import com.arioc.pro.Modelo.Usuarios;
import com.arioc.pro.Servicio.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosControlador {

    private UsuariosService usuariosService;

    @Autowired
    public UsuariosControlador(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @GetMapping ("/todos")
    public ResponseEntity<List<Usuarios>>  obtenertodos() {
        List<Usuarios> usuarios =  usuariosService.Obtenertodos();
        if ( usuarios != null){
            return  new ResponseEntity<>(usuarios, HttpStatus.OK);
        }else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping ("/porid/{id}")
    public ResponseEntity<Usuarios> obtenerporid(@PathVariable Integer id) {
        Usuarios usuario = usuariosService.Obtenerporid(id);
        if ( usuario != null){
            return  new ResponseEntity<>(usuario, HttpStatus.OK);
        }else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/guardar")
    public void guardar(@RequestBody  Usuarios usuarios) {
        usuariosService.guardar(usuarios);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarPersona(Integer id){
        usuariosService.eliminar(id);
    }

    @PostMapping("/actualizar")
    public void ActualizarPersona(@RequestBody Usuarios usuarios){
        usuariosService.Actualizar(usuarios);
    }
}
