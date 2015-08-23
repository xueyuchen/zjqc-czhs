package co.bohc.diet.domain.model;

// Generated 2015-8-17 15:44:16 by Hibernate Tools 3.2.2.GA

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
 * Style generated by hbm2java
 */
@Entity
@Table(name = "style", schema = "dbo")
public class Style implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer styleId;
    private String styleName;
    private Date creDt;
    private Integer delFlg;
    private Set<ModelStyle> modelStyles = new HashSet<ModelStyle>(0);

    public Style() {
    }

    public Style(Integer styleId, String styleName, Date creDt) {
        this.styleId = styleId;
        this.styleName = styleName;
        this.creDt = creDt;
    }

    public Style(Integer styleId, String styleName, Date creDt, Integer delFlg, Set<ModelStyle> modelStyles) {
        this.styleId = styleId;
        this.styleName = styleName;
        this.creDt = creDt;
        this.delFlg = delFlg;
        this.modelStyles = modelStyles;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "style_id", unique = true, nullable = false)
    public Integer getStyleId() {
        return this.styleId;
    }

    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    @Column(name = "style_name", nullable = false, length = 256)
    public String getStyleName() {
        return this.styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "style")
    public Set<ModelStyle> getModelStyles() {
        return this.modelStyles;
    }

    public void setModelStyles(Set<ModelStyle> modelStyles) {
        this.modelStyles = modelStyles;
    }

}
