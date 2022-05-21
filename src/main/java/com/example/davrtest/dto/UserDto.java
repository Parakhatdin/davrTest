package com.example.davrtest.dto;

import com.example.davrtest.model.User;

import java.io.Serializable;
import java.util.Objects;

public class UserDto implements Serializable {
    private final Long id;
    private final String name;
    private final String email;
    private final String status;
    private final String avatar_url;

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.status = user.getStatus();
        this.avatar_url = user.getAvatar_url();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto entity = (UserDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.status, entity.status) &&
                Objects.equals(this.avatar_url, entity.avatar_url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, status, avatar_url);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "email = " + email + ", " +
                "status = " + status + ", " +
                "avatar_url = " + avatar_url + ")";
    }
}
