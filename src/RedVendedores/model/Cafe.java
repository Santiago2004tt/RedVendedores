
package RedVendedores.model;

public class Cafe extends Producto {
    //Atributs
    private String Libras;
    //Builder
    public Cafe(String categoria, String codigo, String nombre, double precio, String libras) {
        super(categoria, codigo, nombre, precio);
        this.Libras = libras;
    }
    // Gets and sets
    public String getLibras() {
        return Libras;
    }

    public void setLibras(String libras) {
        Libras = libras;
    }
    //To string
    @java.lang.Override
    public java.lang.String toString() {
        return "Cafe{" +
                "Libras='" + Libras + '\'' +
                '}';
    }
}
