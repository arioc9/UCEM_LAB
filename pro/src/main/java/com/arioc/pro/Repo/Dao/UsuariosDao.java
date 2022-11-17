package com.arioc.pro.Repo.Dao;

import com.arioc.pro.Modelo.Usuarios;

import java.util.List;

public interface UsuariosDao {

    List<Usuarios> Obtenertodos();

    Usuarios Obtenerporid(Integer id);

    void guardar(Usuarios usuarios);

    void eliminar(Integer id);

    void Actualizar(Usuarios usuarios);

}
