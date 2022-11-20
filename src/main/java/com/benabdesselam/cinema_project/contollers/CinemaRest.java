package com.benabdesselam.cinema_project.contollers;


import com.benabdesselam.cinema_project.entities.Cinema;
import com.benabdesselam.cinema_project.entities.Status;
import com.benabdesselam.cinema_project.entities.Type;
import com.benabdesselam.cinema_project.repositories.CinemaRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(produces = "application/json",path = "/Cinapi")
public class CinemaRest {
  private CinemaRepository cinemaRepository;

  @GetMapping("/searchById/{id}")
  public Cinema SearchById(@PathVariable Long id){
       Cinema savedCinema=cinemaRepository.findById(id).get();
      return savedCinema;
    }

    @GetMapping("/searchByNom/{name}")
    public Cinema SearchByNom(@PathVariable String name){
        Cinema savedCinema=cinemaRepository.findByNom(name);
        return savedCinema;
    }
    @GetMapping("/searchByStatus/{status}")
    public List<Cinema> SearchByStatus(@PathVariable Status status){
        List<Cinema> savedCinema=cinemaRepository.findAllByStatus(status);
        return savedCinema;
    }
    @GetMapping("/searchByType/{type}")
    public List<Cinema> SearchByStatus(@PathVariable Type type){
        List<Cinema> savedCinema=cinemaRepository.findAllByType(type);
        return savedCinema;
    }
    @GetMapping("allCinemas/")
    public List<Cinema> getCinemas(){
      return cinemaRepository.findAll();
    }
    @PostMapping("addCinema/")
    public Cinema ajouter(Cinema cinema){
      return cinemaRepository.save(cinema);
    }

    @PutMapping("update/{id}")
    public Cinema updateCinema(Long id,@RequestBody Cinema cinema){
        Cinema Ncinema=cinemaRepository.findById(id).get();
       if(Ncinema!=null){
        Ncinema.setNom(cinema.getNom());
        Ncinema.setAdresse(cinema.getAdresse());
        Ncinema.setDate_Creation(new Date());
        Ncinema.setStatus(cinema.getStatus());
        Ncinema.setType(cinema.getType());
        cinemaRepository.save(Ncinema);}
       return null;
    }

    @DeleteMapping("delete/")
    public void deleteCinema(Cinema cinema){
      cinemaRepository.delete(cinema);
   }


}
