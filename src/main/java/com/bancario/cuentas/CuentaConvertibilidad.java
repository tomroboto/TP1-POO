package com.bancario.cuentas;

import com.bancario.clientes.ClienteEmpresa;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@ToString (callSuper = true)
public class CuentaConvertibilidad extends CuentaCorriente {
    //Atributos
    private float saldoDolares;

    //Métodos
    public CuentaConvertibilidad(int numeroCuenta, ClienteEmpresa clienteEmpresa, float montoAutorizado) {
        super(numeroCuenta, clienteEmpresa, montoAutorizado);
        this.saldoDolares=0;
    }

    public void depositarDolares(float cantidad){
        if(cantidad>0){
            this.saldoDolares+=cantidad;                                                                                //Primero verifica que la cantidad sea válida
            System.out.println("Se ha depositado correctamente. Su nuevo saldo es de: USD$"+this.getSaldoDolares());    //y luego la suma.
        }else System.out.println("Error. Deposite una cantidad positiva.");
    }
    public void extraerDolares(float cantidad){
        if(cantidad>0){                                                                                                //Primero verifica que la cantidad sea positiva
            if(cantidad<=this.saldoDolares){                                                                           //y luego que sea menor o igual al saldo.
                this.saldoDolares-=cantidad;                                                                           //Si la verificación sale bien le resta la cantidad.
                System.out.println("Se ha extraido correctamente. Su nuevo saldo es de: USD$"+this.getSaldoDolares());
            }else System.out.println("Error. La cuenta no tiene fondos suficientes.");
        }else System.out.println("Error. Extraiga una cantidad positiva.");
    }
    public void convertirPesoDolar(float cantidad, float tasa){
        if(cantidad>0 && tasa>0){
            if(cantidad<=this.getSaldo()+this.getMontoAutorizado()){                                                                                //Primero verifica que la cantidad y la tasa sean positivas
                this.saldoDolares+=cantidad*tasa;                                                                                                   //Luego que haya saldo suficiente en pesos (pudiendo tomar del monto descubierto)
                this.extraerEfectivo(cantidad);                                                                                                     //Si las verificaciones salen bien, le suma la cantidad*tasa al saldo en dolares
                System.out.println("Se ha convertido correctamente. Su nuevo saldo es de: USD$"+this.getSaldoDolares()+" y ARS$"+this.getSaldo());  //y le resta la cantidad al saldo en pesos
            }else System.out.println("Error. La cuenta no tiene fondos suficientes.");
        }else System.out.println("Error. Convierta una cantidad positiva.");
    }
    public void convertirDolarPeso(float cantidad, float tasa){
        if(cantidad>0 && tasa>0){
            if(cantidad<=this.saldoDolares){                                                                                                        //Primero verifica que la cantidad y la tasa sean positivas
                this.saldoDolares-=cantidad;                                                                                                        //Luego que haya saldo suficiente en dolares
                this.depositarEfectivo(cantidad*tasa);                                                                                              //Si las verificaciones salen bien, le suma la cantidad*tasa al saldo en pesos
                System.out.println("Se ha convertido correctamente. Su nuevo saldo es de: USD$"+this.getSaldoDolares()+" y ARS$"+this.getSaldo());  //y le resta la cantidad al saldo en dolares
            }else System.out.println("Error. La cuenta no tiene fondos suficientes.");
        }else System.out.println("Error. Convierta una cantidad positiva.");
    }
}
