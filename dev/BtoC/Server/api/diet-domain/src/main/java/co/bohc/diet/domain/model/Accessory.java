package co.bohc.diet.domain.model;

// Generated 2015-7-14 14:40:23 by Hibernate Tools 3.2.2.GA

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Accessory generated by hbm2java
 */
@Entity
@Table(name = "accessory", schema = "dbo")
public class Accessory implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer accessoryId;
    private Style style;
    private Part part;
    private Model model;
    private String accessoryName;
    private String accessoryImg;
    private String level;
    private String accessoryNum;
    private Date creDt;
    private Date saleDt;
    private Double saleMoney;

    public Accessory() {
    }

    public Accessory(Integer accessoryId, Style style, Part part, Model model, String accessoryName,
            String accessoryImg, String accessoryNum, Date creDt) {
        this.accessoryId = accessoryId;
        this.style = style;
        this.part = part;
        this.model = model;
        this.accessoryName = accessoryName;
        this.accessoryImg = accessoryImg;
        this.accessoryNum = accessoryNum;
        this.creDt = creDt;
    }

    public Accessory(Integer accessoryId, Style style, Part part, Model model, String accessoryName,
            String accessoryImg, String level, String accessoryNum, Date creDt, Date saleDt, Double saleMoney) {
        this.accessoryId = accessoryId;
        this.style = style;
        this.part = part;
        this.model = model;
        this.accessoryName = accessoryName;
        this.accessoryImg = accessoryImg;
        this.level = level;
        this.accessoryNum = accessoryNum;
        this.creDt = creDt;
        this.saleDt = saleDt;
        this.saleMoney = saleMoney;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accessory_id", unique = true, nullable = false)
    public Integer getAccessoryId() {
        return this.accessoryId;
    }

    public void setAccessoryId(Integer accessoryId) {
        this.accessoryId = accessoryId;
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
    @JoinColumn(name = "part_id", nullable = false)
    public Part getPart() {
        return this.part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", nullable = false)
    public Model getModel() {
        return this.model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @Column(name = "accessory_name", nullable = false, length = 256)
    public String getAccessoryName() {
        return this.accessoryName;
    }

    public void setAccessoryName(String accessoryName) {
        this.accessoryName = accessoryName;
    }

    @Column(name = "accessory_img", nullable = false, length = 256)
    public String getAccessoryImg() {
        return this.accessoryImg;
    }

    public void setAccessoryImg(String accessoryImg) {
        this.accessoryImg = accessoryImg;
    }

    @Column(name = "level", length = 256)
    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Column(name = "accessory_num", nullable = false, length = 256)
    public String getAccessoryNum() {
        return this.accessoryNum;
    }

    public void setAccessoryNum(String accessoryNum) {
        this.accessoryNum = accessoryNum;
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
    @Column(name = "sale_dt", length = 23)
    public Date getSaleDt() {
        return this.saleDt;
    }

    public void setSaleDt(Date saleDt) {
        this.saleDt = saleDt;
    }

    @Column(name = "sale_money", precision = 53, scale = 0)
    public Double getSaleMoney() {
        return this.saleMoney;
    }

    public void setSaleMoney(Double saleMoney) {
        this.saleMoney = saleMoney;
    }

}
