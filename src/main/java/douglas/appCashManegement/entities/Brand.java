package douglas.appCashManegement.entities;

import jakarta.persistence.*;

import java.util.Set;

@Embeddable
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id", unique = true)
    private Long id;

    @Column(name = "name_brand")
    private String nameBrand;

    @Column(name = "nationality_brand")
    private String nationality;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_models",
            joinColumns = @JoinColumn(name = "model_id"),
            inverseJoinColumns = @JoinColumn(name = "brand_id")
    )
    private Set<Model> models;

    public Brand() {

    }
    public Brand(Long id, String nameBrand, String nationality, Set<Model> models) {
        this.id = id;
        this.nameBrand = nameBrand;
        this.nationality = nationality;
        this.models = models;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Set<Model> getModels() {
        return models;
    }

    public void setModels(Set<Model> models) {
        this.models = models;
    }
}
