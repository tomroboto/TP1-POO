package com.bancario.cuentas;

import com.bancario.clientes.ClienteEmpresa;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@ToString (callSuper = true)
public class CuentaConvertibilidad extends CuentaCorriente {
    private float saldoDolares;

    public CuentaConvertibilidad(int numeroCuenta, ClienteEmpresa clienteEmpresa, float montoAutorizado) {
        super(numeroCuenta, clienteEmpresa, montoAutorizado);
        this.saldoDolares=0;
    }

    public void depositarDolares(float cantidad){
        if(cantidad>0){
            this.saldoDolares+=cantidad;
            System.out.println("Se ha depositado correctamente. Su nuevo saldo es de: USD$"+this.getSaldoDolares());
        }else System.out.println("Error. Deposite una cantidad positiva.");
    }
    public void extraerDolares(float cantidad){
        if(cantidad>0){
            if(cantidad<=this.saldoDolares){
                this.saldoDolares-=cantidad;
                System.out.println("Se ha extraido correctamente. Su nuevo saldo es de: USD$"+this.getSaldoDolares());
            }else System.out.println("Error. La cuenta no tiene fondos suficientes.");
        }else System.out.println("Error. Extraiga una cantidad positiva.");
    }
    public void convertirPesoDolar(float cantidad, float tasa){
        if(cantidad>0 && tasa>0){
            if(cantidad<=this.getSaldo()+this.getMontoAutorizado()){
                this.saldoDolares+=cantidad*tasa;
                this.extraerEfectivo(cantidad);
                System.out.println("Se ha convertido correctamente. Su nuevo saldo es de: USD$"+this.getSaldoDolares()+" y ARS$"+this.getSaldo());
            }else System.out.println("Error. La cuenta no tiene fondos suficientes.");
        }else System.out.println("Error. Convierta una cantidad positiva.");
    }
    public void convertirDolarPeso(float cantidad, float tasa){
        if(cantidad>0 && tasa>0){
            if(cantidad<=this.saldoDolares){
                this.saldoDolares-=cantidad;
                this.depositarEfectivo(cantidad*tasa);
                System.out.println("Se ha convertido correctamente. Su nuevo saldo es de: USD$"+this.getSaldoDolares()+" y ARS$"+this.getSaldo());
            }else System.out.println("Error. La cuenta no tiene fondos suficientes.");
        }else System.out.println("Error. Convierta una cantidad positiva.");
    }
}
