package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domaine.reservation;
import tn.esprit.autoloc.repository.ReservationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService implements IreservationService {

    private final ReservationRepository rRepo;

    @Override
    public List<reservation> retrieveAllReservations() {
        return (List<reservation>) rRepo.findAll();
    }

    @Override
    public reservation addReservation(reservation r) {
        return rRepo.save(r);
    }

    @Override
    public reservation updateReservation(reservation r) {
        return rRepo.save(r);
    }

    @Override
    public reservation retrieveReservation(Long idReservation) {
        return rRepo.findById(idReservation).orElse(null);
    }

    @Override
    public void removeReservation(Long idReservation) {
        rRepo.deleteById(idReservation);
    }

    @Override
    public List<reservation> addReservations(List<reservation> reservations) {
        return (List<reservation>) rRepo.saveAll(reservations);
    }
}
