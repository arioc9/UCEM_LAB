package com.arioc.pro.Repo.DaoImpl;
import com.arioc.pro.Config.Configuracion;
import com.arioc.pro.Modelo.Mapper.UsuariosMapper;
import com.arioc.pro.Repo.Dao.UsuariosDao;
import com.arioc.pro.Modelo.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UsuariosDaoImpl implements UsuariosDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UsuariosDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Usuarios> Obtenertodos() {
        String SQL = "select * from usuariosarioc";
        List <Usuarios> usuarios = jdbcTemplate.query(SQL, new UsuariosMapper());
        return usuarios;
    }

    @Override
    public Usuarios Obtenerporid(Integer id) {
        Usuarios usuarios = jdbcTemplate.queryForObject("select * from usuariosarioc WHERE id = ?",new Object[]{id}, new UsuariosMapper());
        return usuarios;
    }

    @Override
    public void guardar(Usuarios usuarios) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(Configuracion.getDataSource())
                .withTableName("usuariosarioc")
                .usingGeneratedKeyColumns("id");
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("nombre", usuarios.getNombre());
        parameters.put("correo", usuarios.getCorreo());
        parameters.put("telefono", usuarios.getTelefono());
        jdbcInsert.execute(parameters);
    }

    @Override
    public void eliminar(Integer id) {
        jdbcTemplate.update(
                "DELETE FROM usuariosarioc WHERE ID = ?", id);
    }

    @Override
    public void Actualizar(Usuarios usuarios) {
        jdbcTemplate.update(
                "UPDATE usuariosarioc SET nombre = ?,correo = ?,telefono = ? WHERE ID = ?",
                usuarios.getNombre(), usuarios.getCorreo(), usuarios.getTelefono(), usuarios.getId());
    }
}
