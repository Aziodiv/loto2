package com.bta.loto.model;

import javax.validation.constraints.*;

public class UserAccount extends BaseEntity {


    @NotNull
    @NotEmpty
    @Size(max = 50)
    private String username;


    @NotNull
    @NotEmpty
    private String password;

    @Email
    private String email;


    @Max(999999)
    private Long taxNumber;
    private String firstName;
    private String lastName;

    public UserAccount() {
    }

    public UserAccount(int number1, long number2, String number3, String number4, long number5, String number6, String dateTime) {
    }

    public UserAccount(String username, String password, String email,
                       Long taxNumber, String firstName, String lastName) {
        this(null, username, password, email, taxNumber, firstName, lastName);
    }

    public UserAccount(Long id, String username, String password, String email, Long taxNumber,
                       String firstName, String lastName) {
        super(id);
        this.username = username;
        this.password = password;
        this.email = email;
        this.taxNumber = taxNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(Long taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
