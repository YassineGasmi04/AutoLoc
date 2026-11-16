package tn.esprit.autoloc.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = false, length = 20)
    private String nom;
    @Column(nullable = false, length = 50)
    private String ville;
    @Column(nullable = false, length = 50)
    private String adresse;
    @Column(nullable = false, length = 12)
    private String telephone;
    @OneToMany(mappedBy = "agence")
    Set<Employe> employes;
    @OneToMany(mappedBy = "agence")
    Set<Vehicule> vehicules;

}
