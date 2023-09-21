package br.com.pizzaria.controllerTest;


import br.com.pizzaria.controller.ModelMapperConfig;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;

 class ModelMapperConfigTest {

    @Test
  void testModelMapperBeanCreation() {

        ModelMapperConfig modelMapperConfig = new ModelMapperConfig();

        ModelMapper modelMapper = modelMapperConfig.modelMapper();

        assertNotNull(modelMapper);

    }
}

