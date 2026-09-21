package com.iplacex.automatizacion;

/**
 * Clase Calculadora
 * Contiene operaciones matemáticas básicas que serán probadas
 * mediante pruebas unitarias con JUnit 5.
 * 
 * @version 1.0
 */
public class Calculadora {

    /**
     * Suma dos números enteros.
     * 
     * @param a Primer número
     * @param b Segundo número
     * @return La suma de a + b
     */
    public int sumar(int a, int b) {
        return a + b;
    }

    /**
     * Resta dos números enteros.
     * 
     * @param a Minuendo
     * @param b Sustraendo
     * @return La resta de a - b
     */
    public int restar(int a, int b) {
        return a - b;
    }

    /**
     * Multiplica dos números enteros.
     * 
     * @param a Primer factor
     * @param b Segundo factor
     * @return El producto de a * b
     */
    public int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Divide dos números enteros.
     * 
     * @param a Dividendo
     * @param b Divisor (no puede ser cero)
     * @return El cociente de a / b
     * @throws ArithmeticException si b es cero
     */
    public int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return a / b;
    }
}