package com.example.proyectomictic.service;

import com.example.proyectomictic.entities.Admin;
import com.example.proyectomictic.entities.Bike;
import com.example.proyectomictic.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BikeService {
    @Autowired
    private BikeRepository bikeRepository;
    public List<Bike> getAll() {
        return bikeRepository.getAll();
        //return (List<Bike>)bikeRepository.getAll();
    }
    public Optional<Bike> getBike(int id) {
        return bikeRepository.getBike(id);}

    public Bike save(Bike b) {
        if (b.getId() == null) {
            return bikeRepository.save(b);
        } else {
            Optional<Bike> bikeGuardada = getBike(b.getId());
          // Optional<Bike> bikeGuardada = bikeRepository.getBike(b.getId());
            if (bikeGuardada.isEmpty()) {
                return bikeRepository.save(b);
            } else {
                return b;
            }
        }
    }

//Metodo Actualizar
    public Bike update(Bike b) {
        if (b.getId() != null) {
            Optional<Bike> bikeEncontrado = getBike(b.getId());
           // Optional<Bike> bikeEncontrado = bikeRepository.getBike(b.getId());
            if (!bikeEncontrado.isEmpty()) {//Aqui niego este bolean Y se verifica que no este vacio
                if (b.getName() != null) {
                    bikeEncontrado.get().setName(b.getName());
                }
                if (b.getBrand() != null) {
                    bikeEncontrado.get().setBrand(b.getBrand());
                }
                if (b.getYear() != null) {
                    bikeEncontrado.get().setYear(b.getYear());
                }
                if (b.getDescription() != null) {
                    bikeEncontrado.get().setDescription(b.getDescription());
                }
                if (b.getCategory() != null) {
                    bikeEncontrado.get().setCategory(b.getCategory());
                }
                return bikeRepository.save(bikeEncontrado.get());
            }
        }
        return b;
    }
    public boolean deleteBike(int id){
        boolean resultado = getBike(id).map(bikeporeliminar ->{
            bikeRepository.delete(bikeporeliminar);
            return true;
        }).orElse(false);
        return resultado;
    }
    public Optional<Bike> getBikeId(int id){
        return bikeRepository.getBike(id);
    }

/*
    public boolean delete(int bikeId) {
        Boolean resultado = getBike(bikeId).map(bikePorEliminar -> {
            bikeRepository.delete(bikePorEliminar);
            return true;
        }).orElse(false);
        return resultado;
    }

 */
}






/*
//este codigo es con isPresent java 8
     public Bike save(Bike b){
        if(b.getId() == null){
            return bikeRepository.save(b);
        }else {
            Optional<Bike> e  = bikeRepository.getBike(b.getId());
            if (e.isPresent()){
                 return b;
            }else {
                return bikeRepository.save(b);
            }
        }
    }
    public Bike update(Bike b){
        if (b.getId() != null){
            Optional<Bike> bikeEncontrado = bikeRepository.getBike(b.getId());
            if (bikeEncontrado.isPresent()) {
                if (b.getName() != null){
                    bikeEncontrado.get().setName(b.getName());
                }
                if (b.getBrand() != null) {
                    bikeEncontrado.get().setBrand(b.getBrand());
                }
                if (b.getYear() != null){
                    bikeEncontrado.get().setYear(b.getYear());
                }
                if (b.getDescription() != null){
                    bikeEncontrado.get().setDescription(b.getDescription());
                }
                if (b.getCategory() != null){
                    bikeEncontrado.get().setCategory(b.getCategory());
                }
                bikeRepository.save( bikeEncontrado.get());
                return bikeEncontrado.get();
            }else{
            return b;
        }
        }else{

        return b;
    }
    }

    public boolean delete(int id){
        boolean flag = false;
        Optional<Bike> e = bikeRepository.getBike(id);
        if (e.isPresent()){
            bikeRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }
    }
 */





