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
    private String description;
    private Integer creationYear;
    private String createdBy;
    private Boolean isCracked;
    private Date dc;
    private Date dm;
    private String userC;
    private String userM;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(Integer creationYear) {
        this.creationYear = creationYear;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Boolean getIsCracked() {
        return isCracked;
    }

    public void setIsCracked(Boolean isCracked) {
        this.isCracked = isCracked;
    }

    public Date getDc() {
        return dc;
    }

    public void setDc(Date dc) {
        this.dc = dc;
    }

    public Date getDm() {
        return dm;
    }

    public void setDm(Date dm) {
        this.dm = dm;
    }

    public String getUserC() {
        return userC;
    }

    public void setUserC(String userC) {
        this.userC = userC;
    }

    public String getUserM() {
        return userM;
    }

    public void setUserM(String userM) {
        this.userM = userM;
    }
    
    
}
