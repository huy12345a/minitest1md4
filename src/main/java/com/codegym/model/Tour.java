package com.codegym.model;
import javax.persistence.*;

@Entity
@Table(name = "Tour")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String destination;
    private String start;
    private String img;
    @ManyToOne
    @JoinColumn(name ="province_id")
    private Province province;

    public Tour(){}

    public Tour(String code, String destination, Long id, String img, Province province, String start) {
        this.code = code;
        this.destination = destination;
        this.id = id;
        this.img = img;
        this.province = province;
        this.start = start;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }
}

