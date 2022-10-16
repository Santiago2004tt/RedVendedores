package RedVendedores.model;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

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

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Producto producto = (Producto) object;
        return java.lang.Double.compare(producto.precio, precio) == 0 && java.util.Objects.equals(nombre, producto.nombre) && java.util.Objects.equals(codigo, producto.codigo) && java.util.Objects.equals(categoria, producto.categoria);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), nombre, codigo, categoria, precio);
    }
}