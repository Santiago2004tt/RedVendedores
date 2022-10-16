/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package RedVendedores.model;

public class Helado extends Producto{
    //Atributs
    private String tamanio;
    private String sabor;

    //Builder

    /**
     * metodo constructor
     * @param categoria
     * @param codigo
     * @param nombre
     * @param precio
     */
    public Helado(String categoria, String codigo, String nombre, double precio) {
        super(categoria, codigo, nombre, precio);
    }

    /**
     * get de tamanio
     * @return
     */
    public String getTamanio() {
        return tamanio;
    }

    /**
     * set de tamanio
     * @param tamanio
     */
    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    /**
     * get de sabor
     * @return
     */
    public String getSabor() {
        return sabor;
    }

    /**
     * set de sabor
     * @param sabor
     */
    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    @Override
    public String toString() {
        return "Helado{" +
                "tamanio='" + tamanio + '\'' +
                ", sabor='" + sabor + '\'' +
                '}';
    }
}
