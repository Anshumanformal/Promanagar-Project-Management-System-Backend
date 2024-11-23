package com.anshuman.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    private String name;
    private String description;
    private String category;

    private List<String> tags = new ArrayList<>();

    @JsonIgnore
    @OneToOne(mappedBy = "project",cascade = CascadeType.ALL,orphanRemoval = true)
    private Chat chat;

    @ManyToOne
    private User owner;

    @OneToMany(mappedBy = "project",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Issue> issues = new ArrayList<>();

    @ManyToMany
//    // added by me---------------------
//    @JoinTable(
//            name = "project_team",      // Name of the join table
//            joinColumns = @JoinColumn(name = "project_id"),  // Foreign key column for Project
//            inverseJoinColumns = @JoinColumn(name = "user_id") // Foreign key column for User
//    )
//    // added by me---------------------
    private List<User> team = new ArrayList<>();
}
