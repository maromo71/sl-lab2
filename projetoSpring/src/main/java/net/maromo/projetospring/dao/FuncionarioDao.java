package net.maromo.projetospring.dao;

import net.maromo.projetospring.domain.Funcionario;

import java.util.List;

public interface FuncionarioDao {
    void save(Funcionario funcionario);

    void update(Funcionario funcionario);

    void delete(Long id);

    Funcionario findById(Long id);

    List<Funcionario> findAll();

}
