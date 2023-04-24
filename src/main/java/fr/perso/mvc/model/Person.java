package fr.perso.mvc.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Person extends BaseEntity {


    @NotBlank(message = "Required")
    @Pattern(regexp = "\\d{10}", message = "Pas au bon format")
    private String phoneNumber;

    @NotBlank(message = "Required")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
