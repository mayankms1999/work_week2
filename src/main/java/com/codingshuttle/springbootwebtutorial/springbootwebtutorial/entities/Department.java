package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private Boolean isActive;

    @Column(nullable = false)
    private LocalDate createdAt;

    // New fields added based on DTO
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal budget;

    @Column(nullable = false)
    private Integer size;

    @Column(nullable = false, unique = true, length = 50)
    private String code;

    @Column(nullable = false)
    private String contactEmail;

    private String website;

    private String creditCard;

    @Column(nullable = false)
    private LocalDate nextReviewDate;

    @Column(nullable = false)
    private Boolean isApproved;

    @Column(length = 200)
    private String description;

    @Column(nullable = false)
    private Double rating;

    @ElementCollection
    @CollectionTable(name = "department_managers", joinColumns = @JoinColumn(name = "department_id"))
    @Column(name = "manager")
    private String[] managers;

    @Column(nullable = false)
    private Boolean isUnderReview;
}
