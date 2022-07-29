package net.maromo.projetospring.service;

import net.maromo.projetospring.dao.FuncionarioDao;
import net.maromo.projetospring.domain.Funcionario;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioDao dao;

    public FuncionarioServiceImpl(FuncionarioDao dao) {
        this.dao = dao;
    }

    @Transactional
    @Override
    public void salvar(Funcionario funcionario) {
        dao.save(funcionario);
    }

    @Transactional
    @Override
    public void editar(Funcionario funcionario) {
        dao.update(funcionario);
    }

    @Transactional
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Funcionario buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Funcionario> buscarTodos() {
        return dao.findAll();
    }
}
