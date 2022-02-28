package com.teste.app1.controller;

import com.teste.app1.model.Lancamento;
import com.teste.app1.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://angular-ivy-g1eexa.stackblitz.io", maxAge = 3600)
@RestController
@RequestMapping("/lancamento")
public class LancamentoController implements ControllerInterface<Lancamento>{
    @Autowired
    private LancamentoService service;

    @Override
    @GetMapping
    public ResponseEntity<List<Lancamento>> getAll(){ return ResponseEntity.ok(service.findAll());}

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id){
        Lancamento _lancamento = service.findById(id);
        if(_lancamento != null)
            return ResponseEntity.ok().body(_lancamento);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @PostMapping
    public ResponseEntity<Lancamento> post(@RequestBody Lancamento lancamento) {
        service.create(lancamento);
        return ResponseEntity.ok(lancamento);
    }

    @PutMapping(path = {"/{id}"})
    public Lancamento put(@RequestBody Lancamento lancamento,@PathVariable("id")long id){
        lancamento.setId(id);
        return service.update(lancamento);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(service.delete(id))
            return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
