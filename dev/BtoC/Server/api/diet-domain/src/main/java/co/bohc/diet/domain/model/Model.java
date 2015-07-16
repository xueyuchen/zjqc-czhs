package co.bohc.diet.domain.model;

// Generated 2015-7-14 14:40:23 by Hibernate Tools 3.2.2.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Model generated by hbm2java
 */
@Entity
@Table(name = "model", schema = "dbo", catalog = "czpj")
public class Model implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer modelId;
    private Brand brand;
    private String modelName;
    private Date creDt;
    private Date delFlg;
    @JsonIgnore
    private Set<ModelStyle> modelStyles = new HashSet<ModelStyle>(0);
    @JsonIgnore
    private Set<Accessory> accessories = new HashSet<Accessory>(0);

    public Model() {
    }

    public Model(Integer modelId, Brand brand, String modelName, Date creDt) {
        this.modelId = modelId;
        this.brand = brand;
        this.modelName = modelName;
        this.creDt = creDt;
    }

    public Model(Integer modelId, Brand brand, String modelName, Date creDt, Date delFlg, Set<ModelStyle> modelStyles,
            Set<Accessory> accessories) {
        this.modelId = modelId;
        this.brand = brand;
        this.modelName = modelName;
        this.creDt = creDt;
        this.delFlg = delFlg;
        this.modelStyles = modelStyles;
        this.accessories = accessories;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id", unique = true, nullable = false)
    public Integer getModelId() {
        return this.modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false)
    public Brand getBrand() {
        return this.brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Column(name = "model_name", nullable = false, length = 256)
    public String getModelName() {
        return this.modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cre_dt", nullable = false, length = 23)
    public Date getCreDt() {
        return this.creDt;
    }

    public void setCreDt(Date creDt) {
        this.creDt = creDt;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "del_flg", length = 23)
    public Date getDelFlg() {
        return this.delFlg;
    }

    public void setDelFlg(Date delFlg) {
        this.delFlg = delFlg;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "model")
    public Set<ModelStyle> getModelStyles() {
        return this.modelStyles;
    }

    public void setModelStyles(Set<ModelStyle> modelStyles) {
        this.modelStyles = modelStyles;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "model")
    public Set<Accessory> getAccessories() {
        return this.accessories;
    }

    public void setAccessories(Set<Accessory> accessories) {
        this.accessories = accessories;
    }

}
