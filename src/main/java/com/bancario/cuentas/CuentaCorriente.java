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
    //Atributos
    private float montoAutorizado;

    //Métodos
    public CuentaCorriente(int numeroCuenta, Cliente cliente, float montoAutorizado) {
        super(numeroCuenta, cliente, 0);
        this.montoAutorizado = montoAutorizado;
    }

    @Override
    public void depositarEfectivo(float cantidad) {
        if(cantidad>0){                                                                                     //Primero verifica que la cantidad sea positiva
            float saldoActual= this.getSaldo();                                                             //Si la verificación sale bien le suma la cantidad al saldo actual
            this.setSaldo(saldoActual+cantidad);
            System.out.println("Se ha depositado correctamente. Su nuevo saldo es de: $"+this.getSaldo());
        }else System.out.println("Error. Deposite una cantidad positiva.");
    }

    @Override
    public void extraerEfectivo(float cantidad) {
        if(cantidad>0){                                                                                             //Primero verifica que la cantidad sea positiva
            float saldoActual= this.getSaldo();                                                                     //Luego que no se vaya del rango del monto autorizado en descubierto
            if(cantidad<=saldoActual+montoAutorizado){                                                              //Si la verificación sale bien le resta la cantidad al saldo actual
                this.setSaldo(saldoActual-cantidad);
                System.out.println("Se ha extraido correctamente. Su nuevo saldo es de: $"+this.getSaldo());
            }else System.out.println("Error. La cuenta no tiene fondos suficientes y excede el monto autorizado.");
        }else System.out.println("Error. Extraiga una cantidad positiva.");
    }

    public void depositarCheque(float monto, String bancoEmisor, LocalDate fecha){
        LocalDate fechaActual= LocalDate.now();                                                                 //Primero verifico que la cantidad sea positiva
        if(monto>0){                                                                                            //Luego que la fecha de retiro sea menor o igual a la fecha actual
            if(fechaActual.compareTo(fecha)>=0){                                                                //Si la verificación sale bien le sumo la cantidad al saldo actual
                float saldoActual= this.getSaldo();
                this.setSaldo(saldoActual+monto);
                System.out.println("Se ha depositado correctamente. Su nuevo saldo es de: $"+this.getSaldo());
            }else System.out.println("Error. Vuelva el día de la fecha para depositar.");
        }else System.out.println("Error. Deposite una cantidad positiva.");
    }
}
