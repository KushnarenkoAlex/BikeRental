package com.epam.hackathon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "bicycle")
public class Bicycle implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "bicycle_id", unique = true, nullable = false)
    private Long id;

    private String type;

    private String name;

    private String image;

    private Long price;

    private Float x;

    private Float y;

    @OneToMany(mappedBy = "bicycle", fetch = FetchType.EAGER)
    private Set<Agreement> agreements;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Set<Agreement> getAgreements() {
        return agreements;
    }

    public void setAgreements(Set<Agreement> agreements) {
        this.agreements = agreements;
    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Bicycle() {
    }

    public String getType() {
        return type;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Bicycle(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}