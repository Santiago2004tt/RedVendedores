package RedVendedores.model;

import RedVendedores.exceptions.VendedorException;

import java.util.ArrayList;

/**
 * @Huendy Caicedo
 * @Santiago Sepulveda
 * @Steven Rendon
 *
 * Proyecto final de programacion dos
 * red de vendedores
 */

public class RedVendedores {

    //Atributs
    private String nombre;
    private ArrayList <Producto> listaProductos;
    private ArrayList <Vendedor> listaVendedores;

    // Builder

    /**
     * constructor de red vendedores
     * @param nombre
     */
    public RedVendedores(String nombre) {
        this.nombre    = nombre;
        listaVendedores  = new ArrayList<Vendedor>();
        listaProductos = new ArrayList<Producto>();
    }

    //get and set

    /**
     * el metodo get de nombre
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * el metodo set de nombre
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * metodo get de la lista de productos
     * @return
     */
    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    /**
     * metodo  set de lista de productos
     * @param listaProductos
     */
    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    /**
     * metodo get de la lista de vendedores
     * @return
     */
    public ArrayList<Vendedor> getListaVendedores() {
        return listaVendedores;
    }

    /**
     * metodo set de la lista de vendedores
     * @param listaVendedores
     */
    public void setListaVendedor(ArrayList<Vendedor> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }

    // to string

    @Override
    public String toString() {
        return "RedVendedores{" +
                "nombre='" + nombre + '\'' +
                ", listaProductos=" + listaProductos +
                ", listaVendedor=" + listaVendedores +
                '}';
    }

    //Crud's

    // crud de vendedor

    /**
     * metodo para crear un vendedor
     * @param nuevoVendedor
     * @return
     */
    public String crearVendedor(Vendedor nuevoVendedor) {
        String mensaje = "";

        try {
            verificarExistenciaVendedor(nuevoVendedor.getCedula()); // esta invocacion es para verificar si no se a creado
            listaVendedores.add(nuevoVendedor);
            mensaje = "el vendedor fue creado";
        } catch (VendedorException e) {
            mensaje  = e.getMessage();
        }
        return mensaje;
    }

    /**
     * metodo para verificar si existe el vendedor o no
     * @param cedula
     * @throws VendedorException
     */
    private void verificarExistenciaVendedor(String cedula) throws VendedorException {
        for (Vendedor vendedor : listaVendedores) {
            if(vendedor.getCedula().equals(cedula)){
                throw new VendedorException ("El vendedor ya existe");
            }
        }
    }

    /**
     * metodo para verificar si existe el vendedor o no
     * @param cedula
     * @throws VendedorException
     */
    public void verificarNoExistenciaVendedor(String cedula) throws VendedorException{
        Vendedor vendedor = null;
        for (Vendedor vendedor1: listaVendedores) {
            if(vendedor1.getCedula().equals(cedula)){
                vendedor = vendedor1;
            }
        }
        if(vendedor == null){
            throw new VendedorException ("El vendedor no existe");
        }
    }

    /**
     * metodo para buscar un vendedor
     * @param cedula
     * @return
     */
    public Vendedor buscarVendedor(String cedula) {
        Vendedor vendedorEncontrado = null;

        try {
            verificarNoExistenciaVendedor(cedula);  //esta invocacion verifica si el vendedor existe o no
            for (Vendedor vendedor : listaVendedores) {
                if(vendedor.getCedula().equals(cedula)){
                    vendedorEncontrado =  vendedor;
                    break; //detiene el funcionamiento
                }
            }
        }catch (VendedorException e) {
            String mensaje  = e.getMessage();
        }
        return vendedorEncontrado;
    }

    public String eliminarVendedor(String cedula){
        String mensaje = "";

        try {
            verificarNoExistenciaVendedor(cedula);
            for (int i = 0; i < listaVendedores.size(); i++) {
                if(listaVendedores.get(i).getCedula().equals(cedula)) {
                    listaVendedores.remove(i);
                    mensaje = "El vendedor fue eliminado";
                    break;
                }
            }
        }catch (VendedorException e){
            mensaje = e.getMessage();
        }
        return mensaje;
    }


}