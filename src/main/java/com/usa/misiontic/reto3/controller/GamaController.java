package com.usa.misiontic.reto3.controller;

import com.usa.misiontic.reto3.entities.Client;
import com.usa.misiontic.reto3.entities.Gama;
import com.usa.misiontic.reto3.service.GamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Gama")
public class GamaController {

    @Autowired
    private GamaService gamaService;

    @GetMapping("/all")
    public List<Gama> getAll(){
        return gamaService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Gama save(@RequestBody Gama c){
        return gamaService.save(c);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gama update(@RequestBody Gama c){ return gamaService.update(c); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int gamaId){ return gamaService.delete(gamaId); }
}
