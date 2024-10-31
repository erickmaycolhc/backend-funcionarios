package com.funcionarios.gobierno.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.funcionarios.gobierno.entity.FuncionarioEntity;
import com.funcionarios.gobierno.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@Component
public class FuncionarioDataLoader implements ApplicationRunner {
    @Autowired
    FuncionarioRepository funcionarioRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        // Cargar el archivo desde el classpath
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("data/funcionario.json");
        System.out.println("inputStream => " + inputStream.toString());

        if(inputStream != null){
            List<FuncionarioEntity> funcionario = Arrays.asList(objectMapper.readValue(inputStream, FuncionarioEntity[].class));
            funcionarioRepository.saveAll(funcionario);
        } else {
            System.err.println("No se pudo cargar el archivo funcionario.json");
        }
    }
}
