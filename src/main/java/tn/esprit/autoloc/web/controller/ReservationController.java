package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.IreservationService;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {
    private final IreservationService reserService;
    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody Reservation p){
        return reserService.addReservation(p);
    }
    @GetMapping("/getReservations")
    public List<Reservation> getAllReservations(){
        return reserService.retrieveAllReservations();
    }
    @GetMapping("/getReservationId/{idp}")
    public Reservation getReservationById(@PathVariable long idp){
        return reserService.retrieveReservation(idp);
    }
    @DeleteMapping("/deleteReservation/{idp}")
    public void deleteReservation(@PathVariable long idp){
        reserService.removeReservation(idp);
    }

    @PutMapping("/updateReservation")
    public Reservation updateReservation(@RequestBody Reservation p){
        return reserService.updateReservation(p);
    }

    @GetMapping("/debutApres")
    public List<Reservation> getDebutApres(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        return reserService.getDebutApres(date);
    }
}
