package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short language_id;
    
    @Column(name = "name", nullable = false, length = 20)
    private String name;
    
    @Column(name = "last_update", nullable = false, updatable = false)
    private LocalDateTime last_update;

    @OneToMany(mappedBy="language")
    List<Film> film;

    @OneToMany(mappedBy="original_language")
    List<Film> film1;

	
	
}
