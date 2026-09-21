package com.bancario.cuentas;

import com.bancario.clientes.Cliente;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@ToString (callSuper = true)

public class CajaAhorro extends Cuenta {
    private float tasaInteres;

    public CajaAhorro(int numeroCuenta, Cliente cliente, float tasaInteres) {
        super(numeroCuenta, cliente, 0);
        this.tasaInteres = tasaInteres;
    }
    @Override
    public void depositarEfectivo(float cantidad){
        if(cantidad>0){
            float saldoActual= this.getSaldo();
            this.setSaldo(saldoActual+cantidad);
            System.out.println("Se ha depositado correctamente. Su nuevo saldo es de: $"+this.getSaldo());
        }else{
            System.out.println("Error, deposite una cantidad positiva.");
        }
    }
    @Override
    public void extraerEfectivo(float cantidad) {
        if(cantidad>0){
            float saldoActual=this.getSaldo();
            if(cantidad<=saldoActual){
                this.setSaldo(saldoActual-cantidad);
                System.out.println("Se ha extraido correctamente. Su nuevo saldo es de: $"+this.getSaldo());
            }else System.out.println("Error, la cuenta no tiene fondos suficientes.");
        }else System.out.println("Error, extraiga una cantidad positiva.");
    }

    public void cobrarInteres(){
        float saldoActual= this.getSaldo();
        saldoActual+=saldoActual*tasaInteres/100;//La tasa de interés la divido por cien para hacerlo un porcentaje
        this.setSaldo(saldoActual);
    };
    
}
