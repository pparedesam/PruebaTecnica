package com.exercise.cuentaservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CuentaServiceApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Test
    public void contextLoads() throws Exception {
        assertThat(context).isNotNull();
    }

    @Test
    public void main() {

        CuentaServiceApplication.main(new String[]{});
    }


}
