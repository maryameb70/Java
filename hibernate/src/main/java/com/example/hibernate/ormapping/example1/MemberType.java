package com.example.hibernate.ormapping.example1;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class MemberType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String typeName;
    private String details;
    @OneToMany(mappedBy = "type")
    private List<Member> members;
}
