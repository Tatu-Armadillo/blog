package br.com.web3clubtravel.blog.dto;

import br.com.web3clubtravel.blog.model.Traveler;

public class TravelerDto {

    private String name;
    private String email;
    private String phone;
    private String password;

    public TravelerDto(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public static TravelerDto of(Traveler traveler) {
        final var contact = traveler.getContact();
        return new TravelerDto(contact.getName(), contact.getEmail(), contact.getPhone());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
