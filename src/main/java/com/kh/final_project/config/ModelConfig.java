package com.kh.final_project.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelConfig {
    // Dto 와 Entitiy간의 전환을 용이하게 해주는 라이브러리 입니다
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
