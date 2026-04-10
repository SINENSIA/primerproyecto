package com.sinensia.primerprograma.ejercicios.abril;

import java.math.BigDecimal;

public class CuentaBancaria {

    private final String titular;
    private BigDecimal saldo;
    private final String numeroCuenta;
    private static int totalCuentasCreadas = 0;

    public CuentaBancaria(String titular, String numeroCuenta) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = new BigDecimal("0.00");
        totalCuentasCreadas++;
        IO.println("Total Cuentas creadas: " + totalCuentasCreadas);
    }

    public void ingresar(BigDecimal cantidad) {
        if (cantidad.compareTo(BigDecimal.ZERO) > 0) {
            saldo = saldo.add(cantidad);
        } else {
            System.out.println("EL valor de cantida noe s válido");
        }
    }

    public void retirar(BigDecimal cantidad) {
        if (cantidad.compareTo(saldo) > 0) {
            System.out.println("Saldo insuficiente. Saldo actual: " + saldo);
        } else {
            saldo = saldo.subtract(cantidad);
        }
    }

    protected void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public static int getTotalCuentasCreadas() {
        return totalCuentasCreadas;
    }
}
