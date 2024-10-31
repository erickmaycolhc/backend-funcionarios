package com.funcionarios.gobierno.controller;

import com.funcionarios.gobierno.entity.FuncionarioEntity;
import com.funcionarios.gobierno.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<FuncionarioEntity>> findAllFuncionarios(){
        List<FuncionarioEntity> funcionarios = funcionarioService.findAllFuncionarios();
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioEntity> findByIdFuncionario(@PathVariable Long id){
        FuncionarioEntity funcionario = funcionarioService.findByIdFuncionario(id);
        return  ResponseEntity.ok(funcionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioEntity> updateFuncionario(@PathVariable Long id, @RequestBody FuncionarioEntity funcionario){
        FuncionarioEntity updatedFuncionario = funcionarioService.updateFuncionario(id, funcionario);
        return ResponseEntity.ok(updatedFuncionario);
    }

    @PostMapping
    public ResponseEntity<FuncionarioEntity> saveFuncionario(@RequestBody  FuncionarioEntity funcionario){
        FuncionarioEntity savedFuncioario =funcionarioService.saveFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFuncioario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable  Long id){
        funcionarioService.deleteFuncionario(id);
        return ResponseEntity.noContent().build(); //204 no content
    }
}
