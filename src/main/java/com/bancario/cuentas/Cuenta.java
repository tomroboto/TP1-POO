package com.bancario.cuentas;

import com.bancario.clientes.Cliente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor

public abstract class Cuenta {
    //Atributos
    private int numeroCuenta;
    private Cliente cliente;
    private float saldo;

    //Métodos abstractos
    public abstract void depositarEfectivo(float cantidad);
    public abstract void extraerEfectivo(float cantidad);

}
