package com.bancario.clientes;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@ToString (callSuper = true)
public class ClienteIndividual extends Cliente{
    private String nombre;
    private String apellido;
    private int dni;

    public ClienteIndividual(int numeroCliente, String nombre, String apellido, int dni) {
        super(numeroCliente);
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }
}
