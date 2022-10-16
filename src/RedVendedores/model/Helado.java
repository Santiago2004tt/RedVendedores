

package RedVendedores.model;

public class Helado extends Producto {

    //Atributs
    private String tamanio;
    private String sabor;
    //Builder

    /**
     *
     * @param categoria
     * @param codigo
     * @param nombre
     * @param precio
     * @param tamanio
     * @param sabor
     */
    public Helado(String categoria, String codigo, String nombre, double precio, String tamanio, String sabor) {
        super(categoria, codigo, nombre, precio);
        this.tamanio = tamanio;
        this.sabor = sabor;
    }

    public Helado(String categoria, String codigo, String nombre, double precio) {
        super(categoria, codigo, nombre, precio);
    }

    //gets and sets
    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
    // To string
    @java.lang.Override
    public java.lang.String toString() {
        return "Gaseosa{" +
                "tamanio='" + tamanio + '\'' +
                ", sabor='" + sabor + '\'' +
                '}';
    }
}

