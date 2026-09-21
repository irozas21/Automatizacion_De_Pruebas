package com.iplacex.automatizacion;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Clase de Pruebas Unitarias para la clase Calculadora.
 * 
 * @version 1.0
 */
public class CalculadoraTest {

    private final Calculadora calculadora = new Calculadora();

    /**
     * Prueba que la suma de 2 + 3 sea igual a 5.
     */
    @Test
    @DisplayName("Prueba de suma: 2 + 3 = 5")
    public void testSumar() {
        int resultado = calculadora.sumar(2, 3);
        assertEquals(5, resultado, "La suma de 2 + 3 debe ser 5");
    }

    /**
     * Prueba que la resta de 5 - 3 sea igual a 2.
     */
    @Test
    @DisplayName("Prueba de resta: 5 - 3 = 2")
    public void testRestar() {
        int resultado = calculadora.restar(5, 3);
        assertEquals(2, resultado, "La resta de 5 - 3 debe ser 2");
    }

    /**
     * Prueba que la multiplicación de 4 * 3 sea igual a 12.
     */
    @Test
    @DisplayName("Prueba de multiplicación: 4 * 3 = 12")
    public void testMultiplicar() {
        int resultado = calculadora.multiplicar(4, 3);
        assertEquals(12, resultado, "La multiplicación de 4 * 3 debe ser 12");
    }

    /**
     * Prueba que la división de 10 / 2 sea igual a 5.
     */
    @Test
    @DisplayName("Prueba de división: 10 / 2 = 5")
    public void testDividir() {
        int resultado = calculadora.dividir(10, 2);
        assertEquals(5, resultado, "La división de 10 / 2 debe ser 5");
    }

    /**
     * Prueba que dividir por cero lance una excepción ArithmeticException.
     */
    @Test
    @DisplayName("Prueba de excepción: división por cero")
    public void testDividirPorCero() {
        assertThrows(ArithmeticException.class, () -> {
            calculadora.dividir(10, 0);
        }, "Dividir por cero debe lanzar ArithmeticException");
    }
}