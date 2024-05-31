package douglas.appCashManegement.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_models")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id", unique = true)
    private Long id;

    @Column(name = "name_model")
    private String nameModel;

    public Model() {

    }

    public Model(Long id, String nameModel) {
        this.id = id;
        this.nameModel = nameModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameModel() {
        return nameModel;
    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }
}
