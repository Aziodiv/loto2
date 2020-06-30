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
    private String lastNmae;


    public UserAccount(String username, String password, String email,
                       Long taxNumber, String firstName, String lastNmae) {
        this(null, username, password, email, taxNumber, firstName, lastNmae);
    }

    public UserAccount(Long id, String username, String password, String email, Long taxNumber,
                       String firstName, String lastNmae) {
        super(id);
        this.username = username;
        this.password = password;
        this.email = email;
        this.taxNumber = taxNumber;
        this.firstName = firstName;
        this.lastNmae = lastNmae;
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

    public String getLastNmae() {
        return lastNmae;
    }

    public void setLastNmae(String lastNmae) {
        this.lastNmae = lastNmae;
    }


}
