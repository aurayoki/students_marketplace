package com.jm.marketplace.dto;

import com.jm.marketplace.dto.goods.AdvertisementDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private CityDto city;
    private LocalDate date;
    private String phone;
    private String userImg;
    private Set<RoleDto> roles;
    private Set<AdvertisementDto> advertisements;

    public String getRolesString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (RoleDto role : roles) {
            stringBuilder.append(role.getName()).append(" ");
        }
        return stringBuilder.toString();
    }
}
