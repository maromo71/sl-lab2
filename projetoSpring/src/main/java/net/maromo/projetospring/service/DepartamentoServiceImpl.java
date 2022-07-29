package net.maromo.projetospring.service;

import net.maromo.projetospring.dao.DepartamentoDao;
import net.maromo.projetospring.domain.Departamento;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {
    private final DepartamentoDao dao;

    public DepartamentoServiceImpl(DepartamentoDao dao) {
        this.dao = dao;
    }

    @Transactional
    @Override
    public void salvar(Departamento departamento) {
        dao.save(departamento);
    }

    @Transactional
    @Override
    public void editar(Departamento departamento) {
        dao.update(departamento);
    }

    @Transactional
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Departamento buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Departamento> buscarTodos() {
        return dao.findAll();
    }
}
