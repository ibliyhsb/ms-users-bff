package cl.duoc.ms_blogs_bff.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {
    @JsonProperty("id")
    private Long id;
    
    @JsonProperty("nombreUsuario")
    private String nombreUsuario;
    
    @JsonProperty("correoUsuario")
    private String correoUsuario;
    
    @JsonProperty("passwordUsuario")
    private String passwordUsuario;

    public UserDto() {}

    public UserDto(Long id, String nombreUsuario, String correoUsuario, String passwordUsuario) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.correoUsuario = correoUsuario;
        this.passwordUsuario = passwordUsuario;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }
    public String getCorreoUsuario() { return correoUsuario; }
    public void setCorreoUsuario(String correoUsuario) { this.correoUsuario = correoUsuario; }
    public String getPasswordUsuario() { return passwordUsuario; }
    public void setPasswordUsuario(String passwordUsuario) { this.passwordUsuario = passwordUsuario; }
}