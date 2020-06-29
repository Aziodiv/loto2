package com.bta.loto.model;

public class UserAccount {

    private Long id;
    private String username;
    private String password;
    private String email;
    private Long taxNumber;
    private String firstName;
    private String lastNmae;



    public UserAccount(String username, String password, String email,
                       Long taxNumber, String firstName, String lastNmae) {
        this(null, username,password,email,taxNumber,firstName,lastNmae);
        this.username = username;
        this.password = password;
        this.email = email;
        this.taxNumber = taxNumber;
        this.firstName = firstName;
        this.lastNmae = lastNmae;
    }

    public UserAccount(Long id, String username, String password, String email, Long taxNumber,
                       String firstName, String lastNmae){
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.taxNumber = taxNumber;
        this.firstName = firstName;
        this.lastNmae = lastNmae;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", taxNumber=" + taxNumber +
                ", firstName='" + firstName + '\'' +
                ", lastNmae='" + lastNmae + '\'' +
                '}';
    }
}
