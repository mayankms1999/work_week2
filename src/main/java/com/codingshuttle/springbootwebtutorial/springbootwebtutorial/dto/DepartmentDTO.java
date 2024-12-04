package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.annotations.DepartmentCodeValidation;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.annotations.DepartmentSizeValidation;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {

    @Null // ID should be null when creating a new entity
    private Long id;

    @NotBlank(message = "Title cannot be blank")
    @Size(min = 3, max = 100, message = "Title length must be between 3 and 100 characters")
    private String title;

    @NotNull(message = "Active status is required")
    private Boolean isActive;

    @NotNull(message = "Created date is required")
    @PastOrPresent(message = "Created date must be in the past or present")
    private LocalDate createdAt;

    // New fields with validations
    @Positive(message = "Budget must be positive")
    @Digits(integer = 10, fraction = 2, message = "Budget must be a valid monetary amount")
    private BigDecimal budget;

    //@Range(min = 1, max = 97, message = "Department size should not be prime number")
    @DepartmentSizeValidation
    private String size;

   // @Pattern(regexp = "^[A-Za-z0-9 ]+$", message = "Code can only contain alphanumeric characters and spaces")
    @DepartmentCodeValidation
    @NotBlank(message = "Code cannot be blank")
    private String code;

    @Email(message = "Please provide a valid email")
    private String contactEmail;

    @URL(message = "Website must be a valid URL")
    private String website;

    @CreditCardNumber(message = "Invalid credit card number")
    private String creditCard;

    @Future(message = "Next review date must be in the future")
    private LocalDate nextReviewDate;

    @AssertTrue(message = "Department must be approved")
    private Boolean isApproved;

    @Length(min = 10, max = 200, message = "Description length must be between 10 and 200 characters")
    private String description;

    @DecimalMin(value = "0.0", inclusive = true, message = "Rating must be 0 or higher")
    @DecimalMax(value = "5.0", inclusive = true, message = "Rating must be 5 or lower")
    private Double rating;

    @NotEmpty(message = "Manager list cannot be empty")
    private String[] managers;

    @AssertFalse(message = "Department cannot be under review currently")
    private Boolean isUnderReview;


    
}
