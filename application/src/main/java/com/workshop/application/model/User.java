package com.workshop.application.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Users", uniqueConstraints = @UniqueConstraint(columnNames = "user_email"))
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    @NotEmpty(message = "Did you forget your Name ?")
    private String name;

    @Column(name = "user_email")
    @NotEmpty(message = "Oops ! we need your email to be notified and verified")
    private String email;

    @Column(name = "user_password")
    @NotEmpty(message = "Make a strong password !! that we can't access into it")
    private String password;

    @Column(name = "user_picture")
    private String picture;

    @Column(name = "user_verification_status")
    private Boolean isVerified;

    @Column(name = "Created_At")
    protected Date createdAt;

    @ManyToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
