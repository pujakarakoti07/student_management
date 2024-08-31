package com.example.student.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;
@Entity
@Component
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotNull(message = "Contact is required")
    @Min(value = 1000000000L, message = "Contact must be a valid 10-digit number")
    private long contact;

    @NotEmpty(message = "Address is required")
    private String address;

    @NotNull(message = "Pincode is required")
    @Min(value = 100000, message = "Pincode must be a 6-digit number")
    private Integer pincode;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
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

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }
    public Student(){}
    public Student(int id, String name, long contact, String address, Integer pincode) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.pincode = pincode;
    }
}

