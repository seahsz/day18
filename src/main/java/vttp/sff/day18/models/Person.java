package vttp.sff.day18.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Person {

    private Integer id;

    // required
    @NotBlank(message = "name cannot be empty")
    @Size(min = 5, max = 150, message = "name must be between 5 and 150 characters")
    private String fullName;

    @Email(message = "email must be a valid email")
    @NotBlank(message = "email cannot be empty")
    // required and must be email format
    private String email;

    // between 111111 and 888888
    @Pattern(regexp = "^[1-8]{6}$", message = "Postal Code is 6 digits, each between 1 and 8")
    private String postalCode;

    // 7 digit number - use regular expression
    @Pattern(regexp = "^\\d{7}$", message = "Phone Number must contain 7 digits")
    private String phoneNumber;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    
    @Override
    public String toString() {
        return id + "," + fullName + "," + email + "," + postalCode + "," + phoneNumber;
    }

    public Person() {}

    public Person(Integer id,
            @NotBlank(message = "name cannot be empty") @Size(min = 5, max = 150, message = "name must be between 5 and 150 characters") String fullName,
            @Email(message = "email must be a valid email") @NotBlank(message = "email cannot be empty") String email,
            @Pattern(regexp = "^[1-8]{6}$", message = "Postal Code is 6 digits, each between 1 and 8") String postalCode,
            @Pattern(regexp = "^\\d{7}$", message = "Phone Number must contain 7 digits") String phoneNumber) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
    } 


    

    
}
