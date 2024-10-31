package com.funcionarios.gobierno.service;

import com.funcionarios.gobierno.entity.FuncionarioEntity;
import com.funcionarios.gobierno.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Override
    public List<FuncionarioEntity> findAllFuncionarios(){
        return  funcionarioRepository.findAll();
    }

    @Override
    public FuncionarioEntity findByIdFuncionario(Long id){
        return funcionarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Funcionario no encontrado con ID:" + id));
    }

    @Override
    public FuncionarioEntity updateFuncionario(Long id, FuncionarioEntity funcionario){

        //verificar si el usuario existe
        FuncionarioEntity existeFuncionario = findByIdFuncionario(id);

        // Actualiza solo los campos necesarios
        existeFuncionario.setNombre(funcionario.getNombre());
        existeFuncionario.setApellido(funcionario.getApellido());
        existeFuncionario.setEdad(funcionario.getEdad());
        existeFuncionario.setCargo(funcionario.getCargo());
        existeFuncionario.setImagen(funcionario.getImagen());
        return funcionarioRepository.save(existeFuncionario);
    }

    @Override
    public FuncionarioEntity saveFuncionario(FuncionarioEntity funcionario){
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public void deleteFuncionario(Long id){
        funcionarioRepository.deleteById(id);
    }

}
