package com.ankhar.usermanager.entities;

import javax.persistence.*;

@Entity
@Table(name = "user_list", schema = "user_manager")
public class User {
    final private String DEFAULT_USER_TITLE = "Newbie";
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name", nullable = false)
    private String name;
    @Column(name = "user_title", nullable = false)
    private String title;
    @Column(name = "user_secure", unique = true, nullable = false)
    private Long secureNumber;

    @PrePersist
    private void prePersist() {
        if (this.title == null) {
            this.title = DEFAULT_USER_TITLE;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getSecureNumber() {
        return secureNumber;
    }

    public void setSecureNumber(Long secureNumber) {
        this.secureNumber = secureNumber;
    }
}
