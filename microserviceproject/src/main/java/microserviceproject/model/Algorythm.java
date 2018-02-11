package microserviceproject.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Algorythm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String type;
    private String bloc;
    private String key_length;
    private String structure;
    private String known_attacks;
    private Integer creationyear;
    private String createdby;
    private Date created_date;
    private Date modified_date;
    private String user_creation;
    private String user_modification;

    public Algorythm() {
    }

    public Algorythm(long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBloc() {
        return bloc;
    }

    public void setBloc(String bloc) {
        this.bloc = bloc;
    }

    public String getKey_length() {
        return key_length;
    }

    public void setKey_length(String key_length) {
        this.key_length = key_length;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getKnown_attacks() {
        return known_attacks;
    }

    public void setKnown_attacks(String known_attacks) {
        this.known_attacks = known_attacks;
    }

    public Integer getCreationyear() {
        return creationyear;
    }

    public void setCreationyear(Integer creationyear) {
        this.creationyear = creationyear;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getModified_date() {
        return modified_date;
    }

    public void setModified_date(Date modified_date) {
        this.modified_date = modified_date;
    }

    public String getUser_creation() {
        return user_creation;
    }

    public void setUser_creation(String user_creation) {
        this.user_creation = user_creation;
    }

    public String getUser_modification() {
        return user_modification;
    }

    public void setUser_modification(String user_modification) {
        this.user_modification = user_modification;
    }
    
}
