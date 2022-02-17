package com.onlineshopping.models;

public class Usuario {

    private String usuario;
    private String correo;
    private String clave;
    private String confirmClave;
    private String nombre;
    private String apellido;
    private String celular;
    private String pais;
    private String ciudad;
    private String direccion;
    private String departamento;
    private String codigoPostal;

    public Usuario(){

    }

    public String getUsuario() {
        return usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public String getClave() {
        return clave;
    }

    public String getConfirmClave() {
        return confirmClave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCelular() {
        return celular;
    }

    public String getPais() {
        return pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }
}
