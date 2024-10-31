package com.funcionarios.gobierno.service;

import com.funcionarios.gobierno.entity.FuncionarioEntity;

import java.util.List;

public interface FuncionarioService {
    List<FuncionarioEntity> findAllFuncionarios();
    FuncionarioEntity findByIdFuncionario(Long id);
    FuncionarioEntity saveFuncionario(FuncionarioEntity funcionario);
    FuncionarioEntity updateFuncionario(Long id, FuncionarioEntity funcionario);
    void deleteFuncionario(Long id);
}
