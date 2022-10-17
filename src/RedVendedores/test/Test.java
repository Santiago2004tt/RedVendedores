/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package RedVendedores.test;

import RedVendedores.model.*;
import junit.framework.TestCase;

public class Test extends TestCase {


    /**
     * prueba de crear el vendedor
     */
    public static void testCrearVendedor() {
        RedVendedores redVendedores = new RedVendedores("prueba");
        Vendedor vendedor = new Vendedor("jere", "Gamer", "11", "casa", null);
        String mensajeResultado = redVendedores.crearVendedor(vendedor);
        assertEquals("el vendedor fue creado", mensajeResultado);
    }

    /**
     * prueba de crear el vendedor repetido retorne un error
     */
    public static void testCrearVendedorRepetido() {
        RedVendedores redVendedores = new RedVendedores("prueba");
        Vendedor vendedor = new Vendedor("jere", "Gamer", "11", "casa", null);
        Vendedor vendedor2 = new Vendedor("jere", "Gamer", "11", "casa", null);
        String mensajeResultado = redVendedores.crearVendedor(vendedor);
        String mensajeResultado2 = redVendedores.crearVendedor(vendedor2);
        assertEquals("El vendedor ya existe", mensajeResultado2);
    }

    /**
     * prueba de buscar un vendedor
     */
    public static void testBuscarVendedor() {
        RedVendedores redVendedores = new RedVendedores("prueba");
        Vendedor vendedor = new Vendedor("jere", "Gamer", "11", "casa", null);
        redVendedores.crearVendedor(vendedor);
        Vendedor vendedorEncontrado = null;
        vendedorEncontrado = redVendedores.buscarVendedor("11");

        assertEquals(vendedor, vendedorEncontrado);
    }

    /**
     * prueba de eliminar un vendedor
     */
    public static void testEliminarVendedor() {
        RedVendedores redVendedores = new RedVendedores("prueba");
        Vendedor vendedor = new Vendedor("jere", "Gamer", "11", "casa", null);
        redVendedores.crearVendedor(vendedor);
        String mensajeObtenido = redVendedores.eliminarVendedor("11");
        assertEquals("El vendedor fue eliminado", mensajeObtenido);
    }

    // pruebas de productos

    /**
     * test de crear un helado
     */
    public static void testCrearHelado() {
        RedVendedores redVendedores = new RedVendedores("prueba");
        Helado helado = new Helado("A", "20", "Gran maravilla", 2300, "chocolate", "grande");
        String mensaje = redVendedores.crearHelado(helado);
        assertEquals("el helado fue creado", mensaje);
    }

    /**
     * test de crear un helado repetido donde me verifique que ya existe
     */
    public static void testCrearHeladoRepetido() {
        RedVendedores redVendedores = new RedVendedores("prueba");
        Helado helado = new Helado("A", "20", "Gran maravilla", 2300, "chocolate", "grande");
        Helado helado2 = new Helado("A", "20", "Gran maravilla", 2300, "chocolate", "grande");
        redVendedores.crearHelado(helado);
        String mensaje = redVendedores.crearHelado(helado2);
        assertEquals("El helado ya existe", mensaje);
    }

    /**
     * metodo para buscar uun cafe
     */
    public static void testBuscarCafe() {
        RedVendedores redVendedores = new RedVendedores("prueba");
        Cafe cafe = new Cafe("S", "20", "rosa", 8000.2, "2");
        redVendedores.crearCafe(cafe);
        Producto cafeEncontrado = redVendedores.buscarCafe("20");
        assertEquals(cafe, cafeEncontrado);
    }

    /**
     * test para verificar si elimina una gaseosa
     */
    public static void testEliminarGaseosa() {
        RedVendedores redVendedores = new RedVendedores("prueba");
        Gaseosa gaseosa = new Gaseosa("B", "20", "postobon", 4800.5, "3", "naranja");
        redVendedores.crearGaseosa(gaseosa);
        String mensaje = redVendedores.eliminarGaseosa("20");
        assertEquals("La gaseosa fue eliminada", mensaje);
    }

    /**
     * test para verificar si la exeption funciona correctamente
     */
    public static void testEliminarGaseosaNoExistente() {
        RedVendedores redVendedores = new RedVendedores("prueba");
        Gaseosa gaseosa = new Gaseosa("B", "20", "postobon", 4800.5, "3", "naranja");
        redVendedores.crearGaseosa(gaseosa);
        String mensaje = redVendedores.eliminarGaseosa("21");
        assertEquals("La gaseosa no existe", mensaje);
    }
}

