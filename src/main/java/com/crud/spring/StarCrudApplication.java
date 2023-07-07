package com.crud.spring;

import com.crud.spring.service.CategoriaService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.jdbc.core.JdbcTemplate;

@EnableCaching
@SpringBootApplication
public class StarCrudApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CategoriaService categoriaService;

    public static void main(String[] args) {
        SpringApplication.run(StarCrudApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Log log = LogFactory.getLog(getClass());
//        Categoria cat = new Categoria(1, "Hola", "Prueba");
//        try {
//            if (categoriaService.guardar(cat)) {
//                log.info("Insertado correctamente");
//            }
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        }
//        cat = new Categoria(1, "sd", "Hola");
//        try {
//            if (categoriaService.actualizar(cat)) {
//                log.info("Actualizado correctamente");
//            }
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        }
        //System.exit(0);

    }

}
