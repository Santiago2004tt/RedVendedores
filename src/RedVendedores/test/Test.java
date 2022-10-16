/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package RedVendedores.test;
import RedVendedores.model.RedVendedores;
import RedVendedores.model.Vendedor;
import junit.framework.TestCase;
public class Test extends TestCase {

    public static void testCrearVendedor(){
        RedVendedores redVendedores = new RedVendedores("prueba");
        Vendedor vendedor = new Vendedor("jere", "Gamer", "11", "casa",null);
        String mensajeResultado = redVendedores.crearVendedor(vendedor);
        assertEquals("el vendedor fue creado",mensajeResultado );
    }


    public static void testCrearVendedorRepetido(){
        RedVendedores redVendedores = new RedVendedores("prueba");
        Vendedor vendedor = new Vendedor("jere", "Gamer", "11", "casa",null);
        Vendedor vendedor2 = new Vendedor("jere", "Gamer", "11", "casa",null);
        String mensajeResultado = redVendedores.crearVendedor(vendedor);
        String mensajeResultado2 = redVendedores.crearVendedor(vendedor2);
        assertEquals("El vendedor ya existe",mensajeResultado2 );
    }

    public static void testBuscarVendedor(){
        RedVendedores redVendedores = new RedVendedores("prueba");
        Vendedor vendedor = new Vendedor("jere", "Gamer", "11", "casa",null);
        redVendedores.crearVendedor(vendedor);
        Vendedor vendedorEncontrado = redVendedores.buscarVendedor("11");
        assertEquals(vendedor,vendedorEncontrado );
    }

    public static void testBuscarVendedorNoExiste(){
        RedVendedores redVendedores = new RedVendedores("prueba");
        Vendedor vendedorEncontrado = redVendedores.buscarVendedor("11");
        assertEquals("El vendedor no existe",vendedorEncontrado );
    }

    public static void testEliminarVendedor(){
        RedVendedores redVendedores = new RedVendedores("prueba");
        Vendedor vendedor = new Vendedor("jere", "Gamer", "11", "casa",null);
        redVendedores.crearVendedor(vendedor);
        String mensajeObtenido = redVendedores.eliminarVendedor("11");
        assertEquals("El vendedor fue eliminado", mensajeObtenido);
    }
}
