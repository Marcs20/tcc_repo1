package com.teste.app1.service;

import com.teste.app1.model.Receita;
import com.teste.app1.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitaService implements ServiceInterface<Receita> {
    @Autowired
    private ReceitaRepository repository;

    public ReceitaService(){}

    @Override
    public Receita create(Receita receita){
        repository.save(receita);
        return receita;
    }


    @Override
    public List<Receita> findAll() {
        return repository.findAll();
    }


    @Override
    public Receita findById(Long id) {
        Optional<Receita> _receita = repository.findById(id);
        return _receita.orElse(null);
    }

    @Override
    public Receita update(Receita receita) {
        return repository.save(receita);
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
