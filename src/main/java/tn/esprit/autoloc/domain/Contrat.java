package tn.esprit.autoloc.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "contrat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;
    @Column(nullable = false, unique = true, length = 20)
    private Date dateSignature;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal montantTotal;
    @Column(nullable = false, length = 50)
    private boolean valide;
    @OneToOne(mappedBy = "contrat")
    Reservation reservation;
    @OneToMany(mappedBy = "contrat")
    Set<Paiement> paiements;
}
