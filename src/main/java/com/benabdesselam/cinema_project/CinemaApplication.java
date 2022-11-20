package com.benabdesselam.cinema_project;

import com.benabdesselam.cinema_project.entities.Cinema;
import com.benabdesselam.cinema_project.entities.Status;
import com.benabdesselam.cinema_project.entities.Type;
import com.benabdesselam.cinema_project.repositories.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class CinemaApplication implements CommandLineRunner {
    @Autowired
    CinemaRepository cinemaRepository;
    public static void main(String[] args) {
        SpringApplication.run(CinemaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for(int i=1;i<11;i++){
            cinemaRepository.save(
                    new Cinema(
                            null,"cinema"+i,"adress"+i,new Date(),i*5,
                            (i%2==0? Status.Fermee:Status.Ouverte),
                            (i%2==0? Type.Standard:Type.VR))
                    );
        }
    }
}
