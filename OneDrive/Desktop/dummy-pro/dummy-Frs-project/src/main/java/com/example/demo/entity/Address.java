//package com.example.demo.entity;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class Address 
//{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "address_id", nullable = false)
//    private short address_id;
//    
//    @Column(name = "address", length = 50)
//    private String address;
//   
//    private String address2;
//    @Column(name = "district", nullable = false, length = 20)
//    private String district;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "city_id", nullable = false, foreignKey =@jakarta.persistence.ForeignKey (name = "fk_address_city"))
//    private City city;
//    
//    @Column(name = "postal_code", length = 10)
//    private String postal_code;
//    
//    @Column(name = "phone", nullable = false, length = 20)
//    private String phone;
//    
//    @Column(name = "last_update", nullable = false, insertable = false, updatable = false,
//            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
//    private LocalDateTime last_update;
//
//    @OneToMany(mappedBy = "address")
//    private List<Customer> customers;
//
//    @OneToMany(mappedBy = "address")
//    private List<Store> stores;
//	
//}



package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", nullable = false)
    private short address_id;

    @Column(name = "address", length = 50)
    private String address;

    private String address2;
    @Column(name = "district", nullable = false, length = 20)
    private String district;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false, foreignKey = @ForeignKey(name = "fk_address_city"))
    private City city;

    @Column(name = "postal_code", length = 10)
    private String postal_code;

    @Column(name = "phone", nullable = false, length = 20)
    private String phone;

    @Column(name = "last_update", nullable = false, insertable = false, updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime last_update;

    @OneToMany(mappedBy = "address")
    private List<Customer> customers;

    @OneToMany(mappedBy = "address")
    private List<Store> stores;
}

