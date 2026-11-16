package tn.esprit.autoloc.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Entity
@Table(name = "maintenance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMaintenance;
    @Column(nullable = false, length = 20)
    private Date dateDebut;
    @Column(nullable = false, length = 20)
    private Date dateFin;
    @Column(nullable = false, length = 200)
    private String description;
    @ManyToOne
    Vehicule vehicule;



}
