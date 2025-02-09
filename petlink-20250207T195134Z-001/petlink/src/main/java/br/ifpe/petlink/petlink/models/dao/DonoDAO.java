package br.ifpe.petlink.petlink.models.dao;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import br.ifpe.petlink.petlink.models.dono;

@Repository
public class donoDAO {
    private final JdbcTemplate jdbcTemplate;

    public donoDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int create(dono dono) {
        String sql = "INSERT INTO dono (nome, cpf, endereco, telefone) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, dono.getNome(), dono.getCpf(), dono.getEndereco(), dono.getTelefone());
    }

    public List<dono> listAll() {
        String sql = "SELECT * FROM dono";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new dono(
            rs.getLong("id"),
            rs.getString("nome"),
            rs.getString("cpf"),
            rs.getString("endereco"),
            rs.getString("telefone")
        ));
    }
}