package com.blu4ck.Programming_Languages.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "specs")
public class Specs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long specs_id;

    @Column(name = "tech")
    private String tech;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id")
    @JsonBackReference
    private Language language;
}
