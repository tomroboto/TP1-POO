package com.bancario.tests;

import java.time.LocalDate;

import com.bancario.clientes.ClienteEmpresa;
import com.bancario.clientes.ClienteIndividual;
import com.bancario.cuentas.CajaAhorro;
import com.bancario.cuentas.CuentaConvertibilidad;
import com.bancario.cuentas.CuentaCorriente;

public class TestBancario {
    public static void main(String[] args) {

        //Test cliente individual + caja de ahorro
        ClienteIndividual clienteIndividual1= new ClienteIndividual(1, "Yuri", "Gagarin", 1);
        CajaAhorro cajaAhorro1= new CajaAhorro(1, clienteIndividual1, 10);
        System.out.println("\n//////////TEST CLIENTE INDIVIDUAL + CAJA DE AHORRO//////////\n");
        System.out.println(clienteIndividual1);
        System.out.println(cajaAhorro1);
        System.out.println("Extraigo 10 de efectivo en una caja de ahorro vacía");
        cajaAhorro1.extraerEfectivo(10);
        System.out.println(cajaAhorro1.getSaldo());
        System.out.println("Deposito 10 de efectivo en una caja de ahorro vacía");
        cajaAhorro1.depositarEfectivo(10);
        System.out.println(cajaAhorro1.getSaldo());
        System.out.println("Extraigo 5 de efectivo de la caja de ahorro con $10.00");
        cajaAhorro1.extraerEfectivo(5);
        System.out.println("Cobro el interés de la caja de ahorro");
        cajaAhorro1.cobrarInteres();
        System.out.println(cajaAhorro1.getSaldo());
        System.out.println("Deposito una cantidad negativa en la caja de ahorro");
        cajaAhorro1.depositarEfectivo(-10);
        System.out.println("Extraigo una cantidad negativa en la caja de ahorro");
        cajaAhorro1.extraerEfectivo(-10);

        //Test cliente empresa + caja de ahorro
        ClienteEmpresa clienteEmpresa1= new ClienteEmpresa(2, "Vulcan", 1);
        CajaAhorro cajaAhorro2= new CajaAhorro(2, clienteEmpresa1, 10);
        System.out.println("\n//////////TEST CLIENTE EMPRESA + CAJA DE AHORRO//////////\n");
        System.out.println(clienteEmpresa1);
        System.out.println(cajaAhorro2);
        System.out.println("Extraigo 10 de efectivo en una caja de ahorro vacía");
        cajaAhorro2.extraerEfectivo(10);
        System.out.println(cajaAhorro2.getSaldo());
        System.out.println("Deposito 10 de efectivo en una caja de ahorro vacía");
        cajaAhorro2.depositarEfectivo(10);
        System.out.println(cajaAhorro2.getSaldo());
        System.out.println("Extraigo 5 de efectivo de la caja de ahorro con $10.00");
        cajaAhorro2.extraerEfectivo(5);
        System.out.println("Cobro el interés de la caja de ahorro");
        cajaAhorro2.cobrarInteres();
        System.out.println(cajaAhorro2.getSaldo());
        System.out.println("Deposito una cantidad negativa en la caja de ahorro");
        cajaAhorro2.depositarEfectivo(-10);
        System.out.println("Extraigo una cantidad negativa en la caja de ahorro");
        cajaAhorro2.extraerEfectivo(-10);

        //Test cliente individual + cuenta corriente
        System.out.println("\n//////////TEST CLIENTE INDIVIDUAL + CUENTA CORRIENTE//////////\n");
        ClienteIndividual clienteIndividual2= new ClienteIndividual(3, "Juan Carlos", "Null", 2);
        CuentaCorriente cuentaCorriente1= new CuentaCorriente(3, clienteIndividual2, 5);
        System.out.println(clienteIndividual2);
        System.out.println(cuentaCorriente1);
        System.out.println("Extraigo 10 de efectivo en una cuenta corriente vacía");
        cuentaCorriente1.extraerEfectivo(10);
        System.out.println(cuentaCorriente1.getSaldo());
        System.out.println("Deposito 10 de efectivo en una cuenta corriente vacía");
        cuentaCorriente1.depositarEfectivo(10);
        System.out.println(cuentaCorriente1.getSaldo());
        System.out.println("Deposito una cantidad negativa en una cuenta corriente");
        cuentaCorriente1.depositarEfectivo(-10);
        System.out.println(cuentaCorriente1.getSaldo());
        System.out.println("Extraigo una cantidad negativa en una cuenta corriente");
        cuentaCorriente1.extraerEfectivo(-10);
        System.out.println(cuentaCorriente1.getSaldo());

        //Tests de cheques
        System.out.println("\nTests de cheques.");
        LocalDate diaAnterior= LocalDate.now().minusDays(1);
        LocalDate diaActual= LocalDate.now();
        LocalDate diaSiguiente= LocalDate.now().plusDays(1);
        System.out.println("Fecha de ayer: "+diaAnterior+"\nFecha de hoy: "+diaActual+"\nFecha de mañana: "+diaSiguiente);
        System.out.println("Depositamos un cheque con día de hoy y monto positivo. Saldo actual: "+cuentaCorriente1.getSaldo());
        cuentaCorriente1.depositarCheque(10, "null", diaActual);
        System.out.println(cuentaCorriente1.getSaldo());
        System.out.println("Depositamos un cheque con día de hoy y monto negativo. Saldo actual: "+cuentaCorriente1.getSaldo());
        cuentaCorriente1.depositarCheque(-10, "null", diaActual);
        System.out.println(cuentaCorriente1.getSaldo());
        System.out.println("Depositamos un cheque con día de ayer y monto positivo. Saldo actual: "+cuentaCorriente1.getSaldo());
        cuentaCorriente1.depositarCheque(10,"null", diaAnterior);
        System.out.println(cuentaCorriente1.getSaldo());
        System.out.println("Depositamos un cheque con día de ayer y monto negativo. Saldo actual: "+cuentaCorriente1.getSaldo());
        cuentaCorriente1.depositarCheque(-10,"null", diaAnterior);
        System.out.println(cuentaCorriente1.getSaldo());
        System.out.println("Depositamos un cheque con día de mañana y monto positivo. Saldo actual: "+cuentaCorriente1.getSaldo());
        cuentaCorriente1.depositarCheque(10,"null", diaSiguiente);
        System.out.println(cuentaCorriente1.getSaldo());
        System.out.println("Depositamos un cheque con día de mañana y monto negativo. Saldo actual: "+cuentaCorriente1.getSaldo());
        cuentaCorriente1.depositarCheque(-10,"null", diaSiguiente);
        System.out.println(cuentaCorriente1.getSaldo());

        //Test cliente empresa + cuenta corriente
        System.out.println("\n//////////TEST CLIENTE EMPRESA + CUENTA CORRIENTE//////////\n");
        ClienteEmpresa clienteEmpresa2= new ClienteEmpresa(3, "Pompeya", 2);
        CuentaCorriente cuentaCorriente2= new CuentaCorriente(4, clienteEmpresa2, 10);
        System.out.println(clienteEmpresa2);
        System.out.println(cuentaCorriente2);
        System.out.println("Extraigo sin fondos pero dentro del monto autorizado");
        cuentaCorriente2.extraerEfectivo(5);
        System.out.println("Extraigo sin fondos por fuera del monto autorizado");
        cuentaCorriente2.extraerEfectivo(10);
        System.out.println("Extraigo una cantidad negativa");
        cuentaCorriente2.extraerEfectivo(-2);
        System.out.println("Deposito una cantidad positiva");
        cuentaCorriente2.depositarEfectivo(15);
        System.out.println("Deposito una cantidad negativa");
        cuentaCorriente2.depositarEfectivo(-100);
        System.out.println("Deposito un cheque con monto negativo y fecha de mañana");
        cuentaCorriente2.depositarCheque(-10, "null", diaSiguiente);
        System.out.println("Deposito un cheque con monto positivo y fecha de mañana");
        cuentaCorriente2.depositarCheque(10, "null", diaSiguiente);
        System.out.println("Deposito un cheque con monto negativo y fecha de hoy");
        cuentaCorriente2.depositarCheque(-10, "null", diaActual);
        System.out.println("Deposito un cheque con monto positivo y fecha de hoy");
        cuentaCorriente2.depositarCheque(10, "null", diaActual);

        //Test cliente empresa + cuenta convertibilidad
        System.out.println("\n//////////TEST CLIENTE EMPRESA + CUENTA CONVERTIBILIDAD//////////\n");
        CuentaConvertibilidad cuentaConvertibilidad1= new CuentaConvertibilidad(5, clienteEmpresa2, 10);
        System.out.println(cuentaConvertibilidad1);
        System.out.println("Deposito una cantidad positiva de dolares");
        cuentaConvertibilidad1.depositarDolares(10);
        System.out.println("Deposito una cantidad negativa de dolares");
        cuentaConvertibilidad1.depositarDolares(-10);
        System.out.println("Extraigo una cantidad positiva de dolares y menor al saldo");
        cuentaConvertibilidad1.extraerDolares(5);
        System.out.println("Extraigo una cantidad positiva de dolares y mayor al saldo");
        cuentaConvertibilidad1.extraerDolares(6);
        System.out.println("Extraigo una cantidad negativa de dolares");
        cuentaConvertibilidad1.extraerDolares(-10);
        System.out.println("Convierto una cantidad positiva de pesos a dolares con tasa positiva");
        cuentaConvertibilidad1.convertirPesoDolar(10, 0.1f);
        System.out.println("Convierto una cantidad positiva de pesos a dolares con tasa negativa");
        cuentaConvertibilidad1.convertirPesoDolar(10, -0.1f);
        System.out.println("Convierto una cantidad negativa de pesos a dolares con tasa positiva");
        cuentaConvertibilidad1.convertirPesoDolar(-10, 0.1f);
        System.out.println("Convierto una cantidad negativa de pesos a dolares con tasa negativa");
        cuentaConvertibilidad1.convertirPesoDolar(-10, -0.1f);
        System.out.println("Convierto más pesos de los que puedo utilizar");
        cuentaConvertibilidad1.convertirPesoDolar(100_000, 0.1f);
        System.out.println("Convierto una cantidad positiva de dolares a pesos con tasa positiva");
        cuentaConvertibilidad1.convertirDolarPeso(1, 1000);
        System.out.println("Convierto una cantidad positiva de dolares a pesos con tasa negativa");
        cuentaConvertibilidad1.convertirDolarPeso(1, -1000);
        System.out.println("Convierto una cantidad negativa de dolares a pesos con tasa positiva");
        cuentaConvertibilidad1.convertirDolarPeso(-1, 1000);
        System.out.println("Convierto una cantidad negativa de dolares a pesos con tasa negativa");
        cuentaConvertibilidad1.convertirDolarPeso(-1, -1000);
        System.out.println("Convierto más dolares de los que puedo utilizar");
        cuentaConvertibilidad1.convertirDolarPeso(10_000, 1000);

    }
}
