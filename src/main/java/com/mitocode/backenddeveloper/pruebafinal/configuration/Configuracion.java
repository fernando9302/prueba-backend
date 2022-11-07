package com.mitocode.backenddeveloper.pruebafinal.configuration;

import com.mitocode.backenddeveloper.pruebafinal.entity.Matricula;
import com.mitocode.backenddeveloper.pruebafinal.request.MatriculaRequest;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuracion {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
