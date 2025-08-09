package _0.web.pae.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import _0.web.pae.db.CourseDB;
import lombok.extern.slf4j.Slf4j;

// @Component // decommenter pour l'utiliser
@Slf4j
public class courseCommand implements CommandLineRunner {

    @Autowired
    private CourseDB courseDB;

    @Override
    public void run(String... args) {
        log.info(courseDB.findAll().toString());
    }

}
