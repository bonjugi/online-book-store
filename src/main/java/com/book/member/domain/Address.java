package com.book.member.domain;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {

    @NotEmpty
    @Column(name = "city", nullable = false)
    private String city;

    @NotEmpty
    @Column(name = "street" , nullable = false)
    private String street;

    @NotEmpty
    @Column(name = "zip_code", nullable = false)
    private String zipcode;

    @Builder
    public Address(@NotEmpty String city, @NotEmpty String street, @NotEmpty String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
