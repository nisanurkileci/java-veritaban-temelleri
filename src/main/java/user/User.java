package user;
import  jakarta.persistence.*;

@Entity
@Table(name = "users") // Veritabanında bu sınıfa karşılık gelecek tablo adı
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID otomatik artar
    private int id;

    @Column(name = "name") // Opsiyonel, ama iyi bir pratiktir
    private String name;

    @Column(name = "email")
    private String email;

    // Boş constructor — Hibernate bunu kullanır
    public User() {}


    public User(String name, String email) {

        this.name=name;
        this.email=email;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
