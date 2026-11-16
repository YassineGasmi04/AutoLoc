package tn.esprit.autoloc.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    @Column(nullable = false, unique = false, length = 20)
    private Date dateDebut;
    @Column(nullable = false, unique = false, length = 20)
    private Date dateFin;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatutReservation statut;
    @ManyToOne
    Vehicule vehicule;
    @OneToOne
    Contrat contrat;
    @ManyToOne
    Client client;

}
