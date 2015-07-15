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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Brand generated by hbm2java
 */
@Entity
@Table(name = "brand", schema = "dbo", catalog = "czpj")
public class Brand implements java.io.Serializable {

    private Integer brandId;
    private String brandName;
    private String barndImg;
    private Date creDt;
    private Integer delFlg;
    private Set<Model> models = new HashSet<Model>(0);

    public Brand() {
    }

    public Brand(Integer brandId, String brandName, String barndImg, Date creDt) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.barndImg = barndImg;
        this.creDt = creDt;
    }

    public Brand(Integer brandId, String brandName, String barndImg, Date creDt, Integer delFlg, Set<Model> models) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.barndImg = barndImg;
        this.creDt = creDt;
        this.delFlg = delFlg;
        this.models = models;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id", unique = true, nullable = false)
    public Integer getBrandId() {
        return this.brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    @Column(name = "brand_name", nullable = false, length = 256)
    public String getBrandName() {
        return this.brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Column(name = "barnd_img", nullable = false, length = 256)
    public String getBarndImg() {
        return this.barndImg;
    }

    public void setBarndImg(String barndImg) {
        this.barndImg = barndImg;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cre_dt", nullable = false, length = 23)
    public Date getCreDt() {
        return this.creDt;
    }

    public void setCreDt(Date creDt) {
        this.creDt = creDt;
    }

    @Column(name = "del_flg")
    public Integer getDelFlg() {
        return this.delFlg;
    }

    public void setDelFlg(Integer delFlg) {
        this.delFlg = delFlg;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "brand")
    public Set<Model> getModels() {
        return this.models;
    }

    public void setModels(Set<Model> models) {
        this.models = models;
    }

}
