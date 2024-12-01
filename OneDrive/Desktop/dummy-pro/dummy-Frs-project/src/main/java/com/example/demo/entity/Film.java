package com.example.demo.entity;

import java.io.ObjectInputFilter.Status;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int film_id;
    
    @Column(name = "title", length = 128, nullable = false)
    private String title;
    
    @Lob
    @Column(name = "description")
    private String description;
    
    @Column(name = "release_year")
    private Integer release_year;
    
    @Column(name = "rental_duration", nullable = false)
    private int rentalDuration;
    
    @Column(name = "rental_rate", nullable = false)
    private double rentalRate;
    
    
    private Integer length;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "rating", columnDefinition = "ENUM('G','PG','PG-13','R','NC-17')")
    private Rating rating = Rating.G;
    
    public enum Rating {
        G, PG, PG_13, R, NC_17
    }
    
    
    @ElementCollection
    @CollectionTable(name = "film_special_features", joinColumns = @JoinColumn(name = "film_id"))
    @Column(name = "special_feature")
    @Enumerated(EnumType.STRING)
    private Set<SpecialFeature> specialFeatures;
    
    public enum SpecialFeature {
        TRAILERS, COMMENTARIES, DELETED_SCENES, BEHIND_THE_SCENES
    }

    @Column(name = "replacement_cost", precision = 5, scale = 2, nullable = false)
    private BigDecimal replacementCost = new BigDecimal("19.99");
    
    
    private String special_features;
    
    @Column(name = "last_update", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime last_update;
    
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actor;

    @ManyToMany
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    
    private List<Category> category;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="original_language_id")
    private Language original_language;
    
    @JsonIgnore
    @OneToMany(mappedBy="film")
    List<Inventory>inventory;

}
