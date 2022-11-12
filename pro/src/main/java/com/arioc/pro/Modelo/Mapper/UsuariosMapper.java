package com.arioc.pro.Modelo.Mapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.arioc.pro.Modelo.Usuarios;
import org.springframework.jdbc.core.RowMapper;

public class UsuariosMapper implements RowMapper<Usuarios> {

    public Usuarios mapRow(ResultSet rs, int rowNum) throws SQLException {
        Usuarios usuarios = new Usuarios();
        usuarios.setId(rs.getInt("id"));
        usuarios.setNombre(rs.getString("nombre"));
        usuarios.setCorreo(rs.getString("correo"));
        usuarios.setTelefono(rs.getString("telefono"));
        return usuarios;
    }

}
