
package RedVendedores.model;

public class Gaseosa extends Producto {
    private String litros;
    private Strinf sabor;

    public Gaseosa(String categoria, String codigo, String nombre, double precio, String litros, String sabor) {
        super(categoria, codigo, nombre, precio);
        this.litros = litros;
        this.Sabor  = sabor;
    }

    public String getLitros() {
        return litros;
    }

    public void setLitros(String litros) {
        this.litros = litros;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Gaseosa{" +
                "litros='" + litros + '\'' +
                ", sabor='" + sabor + '\'' +
                '}';
    }
}
