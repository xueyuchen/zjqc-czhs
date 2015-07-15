package co.bohc.diet.domain.model;

// Generated 2015-7-14 14:40:23 by Hibernate Tools 3.2.2.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ModelStyle generated by hbm2java
 */
@Entity
@Table(name = "model_style", schema = "dbo", catalog = "czpj")
public class ModelStyle implements java.io.Serializable {

    private Integer modelStyleId;
    private Style style;
    private Model model;
    private Integer delFlg;

    public ModelStyle() {
    }

    public ModelStyle(Integer modelStyleId, Style style, Model model) {
        this.modelStyleId = modelStyleId;
        this.style = style;
        this.model = model;
    }

    public ModelStyle(Integer modelStyleId, Style style, Model model, Integer delFlg) {
        this.modelStyleId = modelStyleId;
        this.style = style;
        this.model = model;
        this.delFlg = delFlg;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_style_id", unique = true, nullable = false)
    public Integer getModelStyleId() {
        return this.modelStyleId;
    }

    public void setModelStyleId(Integer modelStyleId) {
        this.modelStyleId = modelStyleId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "style_id", nullable = false)
    public Style getStyle() {
        return this.style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", nullable = false)
    public Model getModel() {
        return this.model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @Column(name = "del_flg")
    public Integer getDelFlg() {
        return this.delFlg;
    }

    public void setDelFlg(Integer delFlg) {
        this.delFlg = delFlg;
    }

}
