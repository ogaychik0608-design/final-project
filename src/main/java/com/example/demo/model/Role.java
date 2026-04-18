package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "t_roles")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Role extends BaseModel implements GrantedAuthority {

    @Column(unique = true, nullable = false)
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}