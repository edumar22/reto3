package com.example.proyectomictic.controller;

import com.example.proyectomictic.entities.Message;
import com.example.proyectomictic.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")

@CrossOrigin(origins="*", methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Message")
public class MessageController {

    @Autowired
    private MessageService messageService;
    // /api/Message/all
    @GetMapping("/all")
    public List<Message> getAll(){

        return messageService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") int id){
        return messageService.getMessage(id);
    }
    // /api/Message/save
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public  Message save(@RequestBody Message m){
        return messageService.save(m);
    }
    // /api/Message/update
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public  Message update(@RequestBody Message m){
        return  messageService.update(m);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return messageService.deleteMessage(id);}
}
