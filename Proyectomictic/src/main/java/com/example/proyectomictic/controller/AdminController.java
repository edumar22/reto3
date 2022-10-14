package com.example.proyectomictic.controller;

import com.example.proyectomictic.entities.Admin;
import com.example.proyectomictic.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//el siguiente codigo es cuando no se hacen los metodos
@CrossOrigin(origins="*", methods = {RequestMethod.GET,
RequestMethod.POST, RequestMethod.PUT,
RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    // /api/Admin/all
    @GetMapping("/all")
    public List<Admin>getAll(){
        return adminService.getAll();
    }
    @GetMapping("/{id}")
    //cuando adiciono mas variables
   // public Optional<Admin>getAdmin(@PathVariable("id") int id,@PathVariable("var2") String var2){}
    public Optional<Admin>getAdmin(@PathVariable("id") int id){
        return adminService.getAdmin(id);
    }
    // /api/Admin/save
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public  Admin save(@RequestBody Admin a){
        return  adminService.save(a);
    }
    // /api/Admin/update
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public  Admin update(@RequestBody Admin a){
        return  adminService.update(a);
    }
    // /api/Admin/delete
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){

        return adminService.deleteAdmin(id);
    }

    /*
    //el sigiguiente codigo comentado es cuando nos pide mostra datos por id
    @GetMapping(path = "{id}")
    public Admin readById(@PathVariable int id) {
        return adminService.readById(id);

     */

}
 /*@Autowired
    private AdminService adminService;

    @PostMapping(path = "all")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin a) {
        return adminService.create(a);
    }

    @PostMapping(path = "save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin a) {
        return adminService.create(a);
    }

    @GetMapping(path = "all")
    public List<Admin> getAll() {
        return adminService.readAll();
    }


    }*/