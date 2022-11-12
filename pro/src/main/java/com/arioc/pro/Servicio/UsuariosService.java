package com.arioc.pro.Servicio;

import com.arioc.pro.Modelo.Usuarios;
import com.arioc.pro.Repo.Dao.UsuariosDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosService {

    private final UsuariosDao usuariosDao;

    @Autowired
    public UsuariosService(UsuariosDao usuariosDao) {
        this.usuariosDao = usuariosDao;
    }

    public List<Usuarios> Obtenertodos() {
        return usuariosDao.Obtenertodos();
    }

    public Usuarios Obtenerporid(Integer id) {
        return usuariosDao.Obtenerporid(id);
    }

    public void guardar(Usuarios usuarios) {
         usuariosDao.guardar(usuarios);
    }
}
