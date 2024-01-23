package org.example.example;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;

public class Address {
    private String city;
    private String street;
    private int buildingNo;

    public Address(String city, String street, int buildingNo) {
        this.city = city;
        this.street = street;
        this.buildingNo = buildingNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
//        if (!(o instanceof Address address)) return false;
//        return buildingNo == address.buildingNo && Objects.equals(city, address.city) && Objects.equals(street, address.street);
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return new EqualsBuilder().append(buildingNo, address.buildingNo).append(city, address.city).append(street, address.street).isEquals();
    }

    @Override
    public int hashCode() {
//        return Objects.hash(city, street, buildingNo);
        return new HashCodeBuilder(17, 37)
                .append(street).append(buildingNo).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("city", city)
                .append("street", street)
                .append("buildingNo", buildingNo)
                .toString();
                /*"Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", buildingNo=" + buildingNo +
                '}';*/
    }
}
