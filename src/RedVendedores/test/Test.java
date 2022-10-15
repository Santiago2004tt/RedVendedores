package RedVendedores.test;

import RedVendedores.model.RedVendedores;
import RedVendedores.model.Vendedor;
import junit.framework.TestCase;

/**
 * Pruebas con Junit
 */
public class Test extends TestCase {

    static RedVendedores redVendedores = new RedVendedores("prueba");

    public static void main(String[] args) {

        //System.out.println("miguel <3");
    }

    public static void testCrearVendedor(){
        Vendedor vendedor = new Vendedor("jere", "Gamer", "11", "casa",null);
        String mensajeResultado = redVendedores.crearVendedor(vendedor);
        assertEquals("el vendedor fue creado",mensajeResultado );
    }


    public static void testCrearVendedorRepetido(){
        Vendedor vendedor = new Vendedor("jere", "Gamer", "11", "casa",null);
        Vendedor vendedor2 = new Vendedor("jere", "Gamer", "11", "casa",null);
        String mensajeResultado = redVendedores.crearVendedor(vendedor);
        String mensajeResultado2 = redVendedores.crearVendedor(vendedor2);
        assertEquals("El vendedor ya existe",mensajeResultado2 );
    }

    public static void testVendedorExiste(){
        Vendedor vendedor = new Vendedor("jere", "Gamer", "11", "casa",null);
        String mensajeResultado = redVendedores.crearVendedor(vendedor);
        Vendedor vendedorEncontrado = redVendedores.buscarVendedor("11");
        assertEquals(vendedor,vendedorEncontrado );
    }





}
