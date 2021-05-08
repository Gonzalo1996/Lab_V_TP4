package frgp.utn.edu.ar.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import frgp.utn.edu.ar.main.MatrizAdyacencia;

class MatrizAdyacenciaTest {

	private int i;
	private int j;
	private final int a = 5;
	private MatrizAdyacencia matriz = new MatrizAdyacencia(a);

	
	@Test
	public void agregarElementoTest() {
		i = 2;
		j = 2;
		matriz.agregarElemento(i, j);		
		assertTrue(matriz.existeElemento(i, j), "No existe ese elemento");
	}
	
	@Test
	public void agregarElementoSimetriaTest() {
		i = 1;
		j = 2;
		matriz.agregarElemento(i, j);		
		assertTrue(matriz.existeElemento(i, j), "No existe el elemento");
		assertTrue(matriz.existeElemento(j, i), "No existe el elemento simétrico");
	}

}
