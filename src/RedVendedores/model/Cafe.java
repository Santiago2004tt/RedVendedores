
package RedVendedores.model;

public class Cafe extends Producto {
    //Atributs
    private String libras;


    //Builder
    public Cafe(String categoria, String codigo, String nombre, double precio, String libras) {
        super(categoria, codigo, nombre, precio);
        this.libras = libras;
    }

    // Gets and sets
    /**
     * get de libras
     * @return
     */
    public String getLibras() {
        return libras;
    }

    /**
     * set de libras
     * @param libras
     */
    public void setLibras(String libras) {
        libras = libras;
    }

    //To string
    @java.lang.Override
    public java.lang.String toString() {
        return "Cafe{" +
                "Libras='" + libras + '\'' +
                '}';
    }
}
