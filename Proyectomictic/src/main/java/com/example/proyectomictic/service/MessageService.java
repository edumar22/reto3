package com.example.proyectomictic.service;

import com.example.proyectomictic.entities.Message;
import com.example.proyectomictic.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    public List<Message> getAll(){

        return (List<Message>) messageRepository.getAll();
    }
    public Optional<Message> getMessage(int id) {

        return messageRepository.getMessage(id);
    }

    public Message save(Message message){
        if (message.getIdMessage() == null){
            return messageRepository.save(message);
        } else {
            Optional<Message> messageEncontrado = messageRepository.getMessage(message.getIdMessage());
            if (messageEncontrado.isEmpty()){
                return messageRepository.save(message);
            }else {
                return message;
            }
        }
    }
    public Message update(Message message){
        if (message.getIdMessage() != null){
            Optional<Message> messageEncontrado = messageRepository.getMessage(message.getIdMessage());
            if (!messageEncontrado.isEmpty()) {
                if (message.getMessageText() != null) {
                    messageEncontrado.get().setMessageText(message.getMessageText());
                }

                return messageRepository.save(messageEncontrado.get());
            }
        }
        return message;
    }
    public boolean deleteMessage(int messageId){
        Boolean resultado = getMessage(messageId).map(messagePorEliminar ->{
            messageRepository.delete(messagePorEliminar);
            return true;
        }).orElse(false);
        return resultado;
    }
    /*public boolean deleteMessage(int id){
        boolean resultado = getMessage(id).map(messageporeliminar ->{
            messageRepository.delete(messageporeliminar);
            return true;
        }).orElse(false);
        return resultado;
    }
    public Optional<Message> getMessageId(int id){
        return messageRepository.getMessage(id);}
    * */
}
