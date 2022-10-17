package com.usa.misiontic.reto3.controller;

import com.usa.misiontic.reto3.entities.DTOs.CountClient;
import com.usa.misiontic.reto3.entities.DTOs.CountStatus;
import com.usa.misiontic.reto3.entities.Message;
import com.usa.misiontic.reto3.entities.Reservation;
import com.usa.misiontic.reto3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation c){
        return reservationService.save(c);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation c){ return reservationService.update(c); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId){ return reservationService.delete(reservationId); }

    @GetMapping("/report-clients")
    public List<CountClient> getClientesCaletos(){
        return reservationService.getClientesCaletos();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationsBetweenDates(@PathVariable("dateOne") String dateOne,@PathVariable("dateTwo") String dateTwo){
        return reservationService.getReservationsBetweenDates(dateOne, dateTwo);
    }

    @GetMapping("/report-status")
    public CountStatus getReportStatus(){
        return reservationService.getReservationsStatus();
    }
}
