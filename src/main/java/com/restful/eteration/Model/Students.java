package com.restful.eteration.Model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table
public class Students {

    @ApiModelProperty(notes = "Öğrenci ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ApiModelProperty(notes = "Öğrenci İsmi")
    @Column(name = "name")
    private String name;

    @ApiModelProperty(notes = "Öğrenci Soyadı")
    @Column(name = "surname")
    private String surname;

    @ApiModelProperty(notes = "Öğrenci Email Adresi")
    @Column(name = "email")
    private String email;

    public Students() {
        super();
    }


    public Students(int id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
