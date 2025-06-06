package com.uam.microservicestarea.ServicioAsignaturasYCarrerasDONE.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
@Entity
@Table(name = "Facultad")
public class Facultad
{
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuencial")
        @SequenceGenerator(name ="secuencial",sequenceName = "secuencial",allocationSize = 1)
        private Integer id;

        @NotBlank(message = "El nombre es obligatorio")
        @Size(max = 100, message = "El nombre no puede exceder 100 caracteres")
        @Column(length = 100, nullable = false, unique = true)
        private String nombre;


        @Size(max = 100, message = "La descripción no puede exceder 100 caracteres")
        @Column(length = 100)
        private String descripcion;

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public @NotBlank(message = "El nombre es obligatorio") @Size(max = 100, message = "El nombre no puede exceder 100 caracteres") String getNombre() {
                return nombre;
        }

        public void setNombre(@NotBlank(message = "El nombre es obligatorio") @Size(max = 100, message = "El nombre no puede exceder 100 caracteres") String nombre) {
                this.nombre = nombre;
        }

        public @Size(max = 100, message = "La descripción no puede exceder 100 caracteres") String getDescripcion() {
                return descripcion;
        }

        public void setDescripcion(@Size(max = 100, message = "La descripción no puede exceder 100 caracteres") String descripcion) {
                this.descripcion = descripcion;
        }
}
