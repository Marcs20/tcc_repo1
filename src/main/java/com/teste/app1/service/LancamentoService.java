package com.teste.app1.service;

import com.teste.app1.model.Lancamento;
import com.teste.app1.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LancamentoService implements ServiceInterface<Lancamento> {
    @Autowired
    private LancamentoRepository repository;

    public LancamentoService(){}

    @Override
    public Lancamento create(Lancamento lancamento){
        repository.save(lancamento);
        return lancamento;
    }


    @Override
    public List<Lancamento> findAll() {
        return repository.findAll();
    }


    @Override
    public Lancamento findById(Long id) {
        Optional<Lancamento> _lancamento = repository.findById(id);
        return _lancamento.orElse(null);
    }

    @Override
    public Lancamento update(Lancamento lancamento) {
        return repository.save(lancamento);
    }

    @Override
    public boolean delete(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
