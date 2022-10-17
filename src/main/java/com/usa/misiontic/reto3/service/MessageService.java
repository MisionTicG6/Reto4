package com.usa.misiontic.reto3.service;

import com.usa.misiontic.reto3.entities.Message;
import com.usa.misiontic.reto3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getCar(int id) {return messageRepository.getMessage(id); }

    public Message save(Message c){
        if(c.getIdMessage()==null){
            return messageRepository.save(c);
        }else{
            Optional<Message> e=messageRepository.getMessage(c.getIdMessage());
            if (e.isPresent()){
                return c;
            }else{
                return messageRepository.save(c);
            }
        }
    }

    public Message update(Message c){
        if(c.getIdMessage()!=null){
            Optional<Message> q=messageRepository.getMessage(c.getIdMessage());
            if (q.isPresent()){
                if(c.getMessageText()!=null){
                    q.get().setMessageText(c.getMessageText());
                }
                if(c.getCar()!=null){
                    q.get().setCar(c.getCar());
                }
                if(c.getClient()!=null){
                    q.get().setClient(c.getClient());
                }
                messageRepository.save(q.get());
                return q.get();
            }else{
                return c;
            }
        }else{
            return c;
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Message> c=messageRepository.getMessage(id);
        if(c.isPresent()){
            messageRepository.delete(c.get());
            flag=true;
        }
        return flag;
    }
}
