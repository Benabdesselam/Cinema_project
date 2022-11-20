package com.benabdesselam.cinema_project.repositories;

import com.benabdesselam.cinema_project.entities.Cinema;
import com.benabdesselam.cinema_project.entities.Status;
import com.benabdesselam.cinema_project.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema,Long> {
    Cinema findByNom(String name);

    //Cinema findByStatus(Status status);

    List<Cinema> findAllByStatus(Status status);

    List<Cinema> findAllByType(Type type);
}
