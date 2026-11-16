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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    @Column(nullable = false, unique = true, length = 20)
    private String nom;
    @Column(nullable = false, length = 30)
    private String prenom;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false, length = 20)
    private String telephone ;
    @Column(nullable = false, length = 20)
    private String numPermis;
    @Column(nullable = false, length = 20)
    private Date datePermis;
    @OneToMany(mappedBy = "client")
    Set<Reservation> reservations;

}
