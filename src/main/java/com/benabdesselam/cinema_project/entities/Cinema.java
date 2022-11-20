package com.benabdesselam.cinema_project.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "cinema")
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    @Column(length = 10,nullable = true,unique = true)
    private String nom;
    @Column(length =10 ,nullable = true)
    private String adresse;
    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Date date_Creation;
    @Column(nullable = true)
    @XmlTransient
    private int Nb_chaises;
    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Type type;
}
