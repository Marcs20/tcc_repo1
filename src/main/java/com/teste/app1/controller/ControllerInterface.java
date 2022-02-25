package com.teste.app1.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ControllerInterface<T> {
    ResponseEntity<List<T>> getAll();
    ResponseEntity<?> get(Long id);
    ResponseEntity<T> post(T obj);
    ResponseEntity<?> delete(Long id);
}
