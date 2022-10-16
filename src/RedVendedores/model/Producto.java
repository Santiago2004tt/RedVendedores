package RedVendedores.model;

import java.util.Objects;

public abstract class Producto {

    //Atributs
    private String nombre;
    private String codigo;
    private String categoria;
    private double precio;

    //Builder
    public Producto(String categoria, String codigo, String nombre, double precio) {
        this.categoria = categoria;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    //get and set

    /**
     * get de codigo
     * @return
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * set de codigo
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * get de nombre
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * set de nombre
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * get de categoria
     * @return
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * set de categoria
     * @param categoria
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * get de precio
     * @return
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * set de precio
     * @param precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //to string
    @java.lang.Override
    public java.lang.String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", categoria='" + categoria + '\'' +
                ", precio=" + precio +
                '}';
    }

    //hash


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(getCodigo(), producto.getCodigo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo());
    }
}