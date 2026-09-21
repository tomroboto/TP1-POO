package com.bancario.cuentas;

import java.time.LocalDate;

import com.bancario.clientes.Cliente;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@ToString (callSuper = true)

public class CuentaCorriente extends Cuenta{
    private float montoAutorizado;

    public CuentaCorriente(int numeroCuenta, Cliente cliente, float montoAutorizado) {
        super(numeroCuenta, cliente, 0);
        this.montoAutorizado = montoAutorizado;
    }

    @Override
    public void depositarEfectivo(float cantidad) {
        if(cantidad>0){
            float saldoActual= this.getSaldo();
            this.setSaldo(saldoActual+cantidad);
            System.out.println("Se ha depositado correctamente. Su nuevo saldo es de: $"+this.getSaldo());
        }else System.out.println("Error. Deposite una cantidad positiva.");
    }

    @Override
    public void extraerEfectivo(float cantidad) {
        if(cantidad>0){
            float saldoActual= this.getSaldo();
            if(cantidad<=saldoActual+montoAutorizado){
                this.setSaldo(saldoActual-cantidad);
                System.out.println("Se ha extraido correctamente. Su nuevo saldo es de: $"+this.getSaldo());
            }else System.out.println("Error. La cuenta no tiene fondos suficientes y excede el monto autorizado.");
        }else System.out.println("Error. Extraiga una cantidad positiva.");
    }

    public void depositarCheque(float monto, String bancoEmisor, LocalDate fecha){
        LocalDate fechaActual= LocalDate.now();
        if(monto>0){
            if(fechaActual.compareTo(fecha)>=0){
                float saldoActual= this.getSaldo();
                this.setSaldo(saldoActual+monto);
                System.out.println("Se ha depositado correctamente. Su nuevo saldo es de: $"+this.getSaldo());
            }else System.out.println("Error. Vuelva el día de la fecha para depositar.");
        }else System.out.println("Error. Deposite una cantidad positiva.");
    }
}
