/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package RedVendedores.test;

import RedVendedores.model.Cafe;
import RedVendedores.model.Producto;
import RedVendedores.model.RedVendedores;

public class Prueba {
    public static void main(String[] args) {
        RedVendedores redVendedores = new RedVendedores("prueba");
        Cafe cafe = new Cafe("S", "20", "rosa", 8000.2, "2");
        Cafe cafe2 = new Cafe("Sergio", "20", "rosa", 8000.2, "2");
        String mensaje = redVendedores.crearCafe(cafe);
        String mensaje2 = redVendedores.crearCafe(cafe2);
//        Producto cafeEncontrado = redVendedores.buscarCafe("21");
        System.out.println(mensaje2);
    }
}
