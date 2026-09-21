package com.bancario.clientes;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@ToString (callSuper = true)
public class ClienteEmpresa extends Cliente {
    //Atributos
    private String nombreEmpresa;
    private int cuit;

    //Métodos
    public ClienteEmpresa(int numeroCliente, String nombreEmpresa, int cuit) {
        super(numeroCliente);
        this.nombreEmpresa = nombreEmpresa;
        this.cuit = cuit;
    }
    
}
