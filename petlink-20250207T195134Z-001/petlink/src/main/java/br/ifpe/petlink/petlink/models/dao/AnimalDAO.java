package br.ifpe.petlink.petlink.models.dao;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import br.ifpe.petlink.petlink.models.Animal;

@Repository
public class AnimalDAO {
    private final JdbcTemplate jdbcTemplate;

    public AnimalDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int create(Animal animal) {
        String sql = "INSERT INTO animal (nome, raca, idade) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, animal.getNome(), animal.getRaca(), animal.getIdade());
    }

    public List<Animal> listAll() {
        String sql = "SELECT * FROM animal";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Animal(
            rs.getLong("id"),
            rs.getString("nome"),
            rs.getString("raca"),
            rs.getInt("idade")
        ));
    }
}

