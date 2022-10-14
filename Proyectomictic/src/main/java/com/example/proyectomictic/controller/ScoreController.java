package com.example.proyectomictic.controller;

import com.example.proyectomictic.entities.Score;
import com.example.proyectomictic.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")

public class ScoreController {
    @Autowired
    private ScoreService scoreService;
    // /api/Score/all
    @GetMapping("/all")
    public List<Score> getAll(){

        return scoreService.getAll();
    }
    @GetMapping("/{id}")

    public Optional<Score> getScore(@PathVariable("id") int id){

        return scoreService.getScore(id);
    }
    // /api/Score/save
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public  Score save(@RequestBody Score s){

        return  scoreService.save(s);
    }
    // /api/Score/update
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public  Score update(@RequestBody Score s){

        return  scoreService.update(s);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){return scoreService.deleteScore(id);}

}
