package com.springBoot.GestionEmpleados.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Entity
@Table(name = "Empleados")
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("apellido")
    private String apellido;

    @JsonProperty("dni")
    private String dni;

    @JsonProperty("puesto")
    private String puesto;

    public Long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return Objects.equals(id, empleado.id) && Objects.equals(nombre, empleado.nombre) && Objects.equals(apellido, empleado.apellido) && Objects.equals(dni, empleado.dni) && Objects.equals(puesto, empleado.puesto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, dni, puesto);
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", puesto='" + puesto + '\'' +
                '}';
    }
}
