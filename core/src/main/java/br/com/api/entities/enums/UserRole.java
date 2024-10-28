package br.com.api.entities.enums;

public enum UserRole {
    ROLE_ADMIN("role_admin"),
    ROLE_USER("role_user");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }
}
