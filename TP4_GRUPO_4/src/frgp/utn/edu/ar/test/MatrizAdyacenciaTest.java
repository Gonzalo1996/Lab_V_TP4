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
	
	@Test
	public void eliminarElementoTest() {
		i = 1;
		j = 2;
		matriz.agregarElemento(i, j);
		matriz.eliminarElemento(i, j);		
		assertFalse(matriz.existeElemento(i, j), "No se elimino el elemento 1");
		
		i = 3;
		j = 0;
		matriz.agregarElemento(i, j);
		matriz.eliminarElemento(i, j);		
		assertFalse(matriz.existeElemento(i, j), "No se elimino el elemento 2");
	}
	
	@Test
	public void eliminarElementoSimetricoTest() {
		i = 3;
		j = 2;
		
		matriz.agregarElemento(i, j);
		matriz.eliminarElemento(i, j);		
		assertFalse(matriz.existeElemento(i, j), "No se elimino el elemento 1");
		assertFalse(matriz.existeElemento(j, i), "No se elimino el elemento 1 simétrico");
		
		i = 1;
		j = 2;
		
		matriz.agregarElemento(i, j);
		matriz.eliminarElemento(i, j);		
		assertFalse(matriz.existeElemento(i, j), "No se elimino el elemento 2");
		assertFalse(matriz.existeElemento(j, i), "No se elimino el elemento 2 simétrico");
	}

	@Test
	public void contarRelacionesTest() {
		i = 4;
		j = 3;
		
		assertEquals(0, matriz.getCantidadElementos());	
		matriz.agregarElemento(i, j);
		assertEquals(1, matriz.getCantidadElementos());		
		
		i = 1;
		j = 3;
		matriz.agregarElemento(i, j);
		assertEquals(2, matriz.getCantidadElementos());		
		
		matriz.agregarElemento(i, j);
		assertEquals(2, matriz.getCantidadElementos());	
	}
	
	@Test
	public void existenTodosLosElementoTest() {		
		for(i = 0; i < a; i++) 
		{
			for(j = 0; j < a; j ++) 
			{
				matriz.agregarElemento(i, j);		
				assertTrue(matriz.existeElemento(i, j));
				assertTrue(matriz.existeElemento(j, i));
			}
		}
	}
}
