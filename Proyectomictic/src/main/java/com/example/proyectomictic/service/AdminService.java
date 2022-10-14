package com.example.proyectomictic.service;

import com.example.proyectomictic.entities.Admin;
import com.example.proyectomictic.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    public List<Admin> getAll(){
        return (List<Admin>) adminRepository.getAll();
    }
    public Optional<Admin> getAdmin(int id) {
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin a){
        if (a.getIdAdmin() == null){
            return adminRepository.save(a);
            } else {
                Optional<Admin> adminEncontrado = adminRepository.getAdmin(a.getIdAdmin());
                if (adminEncontrado.isEmpty()){
                    return adminRepository.save(a);
                }else {
                    return a;
                }
            }
    }
    public Admin update(Admin a){
        if (a.getIdAdmin() != null){
            Optional<Admin> adminEncontrado = adminRepository.getAdmin(a.getIdAdmin());
            if (!adminEncontrado.isEmpty()) {//aqui se verifica que no este vacio
                if (a.getPassword() != null) {
                    adminEncontrado.get().setPassword(a.getPassword());
                }
                /*
                if (a.getEmail() != null){
                    adminEncontrado.get().setEmail(a.getEmail());
                }
                 */
                if (a.getName() != null){
                    adminEncontrado.get().setName(a.getName());
                }
                return adminRepository.save(adminEncontrado.get());
            }
        }
        return a;
    }
     public boolean deleteAdmin(int id){
        boolean resultado = getAdmin(id).map(adminPorEliminar ->{
            adminRepository.delete(adminPorEliminar);
            return true;
        }).orElse(false);
        return resultado;
    }
    public Optional<Admin> getAdminId(int id){
        return adminRepository.getAdmin(id);

    }


    /*
    *
    public boolean deleteAdmin(int adminId){
        Boolean resultado = getAdmin(adminId).map(adminPorEliminar ->{
            adminRepository.delete(adminPorEliminar);
            return true;
        }).orElse(false);
        return resultado;
    }

     */
    /*
    //el sigiguiente codigo comentado es cuando nos pide mostra datos por id
    public Admin readById(int id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin does not exists"));
    }

     */


}
