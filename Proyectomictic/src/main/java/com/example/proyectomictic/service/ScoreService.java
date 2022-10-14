package com.example.proyectomictic.service;

import com.example.proyectomictic.entities.Score;
import com.example.proyectomictic.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;
    public List<Score> getAll(){

        return (List<Score>) scoreRepository.getAll();
    }
    public Optional<Score> getScore(int id) {

        return scoreRepository.getScore(id);
    }

    public Score save(Score s){
        if (s.getIdScore() == null){
            return scoreRepository.save(s);
        } else {
            Optional<Score> scoreEncontrado = scoreRepository.getScore(s.getIdScore());
            if (scoreEncontrado.isEmpty()){
                return scoreRepository.save(s);
            }else {
                return s;
            }
        }
    }
    public Score update(Score s){
        if (s.getIdScore() != null){
            Optional<Score> scoreEncontrado = scoreRepository.getScore(s.getIdScore());
            if (! scoreEncontrado.isEmpty()) {//aqui se verifica que no este vacio
                if (s.getMessageText() != null) {
                    scoreEncontrado.get().setMessageText(s.getMessageText());
                }

                if (s.getStars() != null){
                     scoreEncontrado.get().setStars(s.getStars());
                }
                /*

                if (s.getReservation() != null){
                    scoreEncontrado.get().setReservation(s.getReservation());
                }

                 */
                return scoreRepository.save( scoreEncontrado.get());
            }
        }
        return s;
    }
    public boolean deleteScore(int id){
        boolean resultado = getScore(id).map(scoreporeliminar ->{
            scoreRepository.delete(scoreporeliminar);
            return true;
        }).orElse(false);
        return resultado;
    }
    public Optional<Score> getScoreId(int id){
        return scoreRepository.getScore(id);}
    /*
    public boolean deleteAdmin(int scoreId){
        Boolean resultado = getScore(scoreId).map(scorePorEliminar ->{
            scoreRepository.delete(scorePorEliminar);
            return true;
        }).orElse(false);
        return resultado;
    }

     */


}
