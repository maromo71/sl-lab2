package net.maromo.projetospring.service;

import net.maromo.projetospring.dao.CargoDao;
import net.maromo.projetospring.domain.Cargo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional(readOnly = false)
public class CargoServiceImpl implements CargoService{

    private final CargoDao dao;

    public CargoServiceImpl(CargoDao dao) {
        this.dao = dao;
    }

    @Override
    public void salvar(Cargo cargo) {
        dao.save(cargo);
    }

    @Override
    public void editar(Cargo cargo) {
        dao.update(cargo);
    }

    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Override @Transactional(readOnly = true)
    public Cargo buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override @Transactional(readOnly = true)
    public List<Cargo> buscarTodos() {
        return dao.findAll();
    }
    @Override
    public boolean cargoTemFuncionarios(Long id) {
        if (buscarPorId(id).getFuncionarios().isEmpty()) {
            return false;
        }
        return true;
    }
}
