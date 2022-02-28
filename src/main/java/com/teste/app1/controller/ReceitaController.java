package com.teste.app1.controller;

import com.teste.app1.model.Receita;
import com.teste.app1.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://angular-ivy-g1eexa.stackblitz.io", maxAge = 3600)
@RestController
@RequestMapping("/receita")
public class ReceitaController implements ControllerInterface<Receita>{

    @Autowired
    private ReceitaService service;

    @Override
    @GetMapping
    public ResponseEntity<List<Receita>> getAll(){ return ResponseEntity.ok(service.findAll());}

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id){
        Receita _receita = service.findById(id);
        if(_receita != null)
            return ResponseEntity.ok().body(_receita);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @PostMapping
    public ResponseEntity<Receita> post(@RequestBody Receita receita) {
        service.create(receita);
        return ResponseEntity.ok(receita);
    }

    @PutMapping(path = {"/{id}"})
    public Receita put(@RequestBody Receita receita,@PathVariable("id")long id){
        receita.setId(id);
        return service.update(receita);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(service.delete(id))
            return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
