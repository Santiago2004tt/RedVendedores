/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package RedVendedores.model;

import RedVendedores.exceptions.HeladoException;
import RedVendedores.exceptions.VendedorException;

import java.util.ArrayList;

public class RedVendedores {
    //Atributs
    private String nombre;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Vendedor> listaVendedores;

    // Builder

    /**
     * constructor de red vendedores
     *
     * @param nombre
     */
    public RedVendedores(String nombre) {
        this.nombre = nombre;
        listaVendedores = new ArrayList<Vendedor>();
        listaProductos = new ArrayList<Producto>();
    }

    //get and set

    /**
     * el metodo get de nombre
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * el metodo set de nombre
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * metodo get de la lista de productos
     *
     * @return
     */
    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    /**
     * metodo  set de lista de productos
     *
     * @param listaProductos
     */
    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    /**
     * metodo get de la lista de vendedores
     *
     * @return
     */
    public ArrayList<Vendedor> getListaVendedores() {
        return listaVendedores;
    }

    /**
     * metodo set de la lista de vendedores
     *
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
     *
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
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    /**
     * metodo para verificar si existe el vendedor
     *
     * @param cedula
     * @throws VendedorException
     */
    private void verificarExistenciaVendedor(String cedula) throws VendedorException {
        for (Vendedor vendedor : listaVendedores) {
            if (vendedor.getCedula().equals(cedula)) {
                throw new VendedorException("El vendedor ya existe");
            }
        }
    }

    /**
     * metodo para verificar si el vendedor no existe
     *
     * @param cedula
     * @throws VendedorException
     */
    public void verificarNoExistenciaVendedor(String cedula) throws VendedorException {
        Vendedor vendedor = null;
        for (Vendedor vendedor1 : listaVendedores) {
            if (vendedor1.getCedula().equals(cedula)) {
                vendedor = vendedor1;
            }
        }
        if (vendedor == null) {
            throw new VendedorException("El vendedor no existe");
        }
    }

    /**
     * metodo para buscar un vendedor
     *
     * @param cedula
     * @return
     */
    public Vendedor buscarVendedor(String cedula) {
        Vendedor vendedorEncontrado = null;

        try {
            verificarNoExistenciaVendedor(cedula);  //esta invocacion verifica si el vendedor existe o no
            for (Vendedor vendedor : listaVendedores) {
                if (vendedor.getCedula().equals(cedula)) {
                    vendedorEncontrado = vendedor;
                    break; //detiene el funcionamiento
                }
            }
        } catch (VendedorException e) {
            throw new RuntimeException(e);//manda una exepcion para no retornar un objeto vacio
        }
        return vendedorEncontrado;
    }

    /**
     * metodo para eliminar un vendedor
     *
     * @param cedula
     * @return
     */
    public String eliminarVendedor(String cedula) {
        String mensaje = "";

        try {
            verificarNoExistenciaVendedor(cedula);
            for (int i = 0; i < listaVendedores.size(); i++) {
                if (listaVendedores.get(i).getCedula().equals(cedula)) {
                    listaVendedores.remove(i);
                    mensaje = "El vendedor fue eliminado";
                    break;
                }
            }
        } catch (VendedorException e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    /**
     * metodo para actualizar un vendedor
     *
     * @param nombre
     * @param apellido
     * @param direccion
     * @param cedula
     * @return
     */
    public String actualizarVendedor(String nombre, String apellido, String direccion, String cedula) {
        String mensaje = "";

        try {
            verificarNoExistenciaVendedor(cedula);
            for (int i = 0; i < listaVendedores.size(); i++) {
                if (listaVendedores.get(i).getCedula().equals(cedula)) {
                    listaVendedores.get(i).setNombre(nombre);
                    listaVendedores.get(i).setApellido(apellido);
                    listaVendedores.get(i).setDireccion(direccion);
                    mensaje = "El vendedor fue actualizado";
                    break;
                }
            }
        } catch (VendedorException e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    // CRUD HELADO

    //crear helado
    public String crearHelado(Helado nuevoHelado) {
        String mensaje = "";

        try {
            verificarExistenciaHelado(nuevoHelado.getCodigo());
            listaProductos.add(nuevoHelado);
            mensaje = "el helado fue creado";
        } catch (HeladoException e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    private void verificarExistenciaHelado(String codigo) throws HeladoException {
        for (Producto producto : listaProductos) {
            if (producto instanceof Helado) {
                if (producto.getCodigo().equals(codigo))
                    throw new HeladoException("El vendedor ya existe");
            }
        }
    }

    public void verificarNoExistenciaHelado(String codigo) throws HeladoException {
        Producto producto = null;
        for (Producto producto1 : listaProductos) {
            if (producto1 instanceof Helado) {
                if (producto1.getCodigo().equals(codigo)) {
                    producto = producto1;
                    break;
                }
            }
        }
        if (producto == null) {
            throw new HeladoException("El helado no existe");
        }
    }

    public Producto buscarHelado(String codigo) {
        Producto productoEncontrado = null;

        try {
            //esta invocacion verifica si el helado existe o no
            verificarNoExistenciaHelado(codigo);
            for (Producto producto : listaProductos) {
                if (producto instanceof Helado) {
                    if (producto.getCodigo().equals(codigo)) {
                        productoEncontrado = (Helado) producto;
                        break; //detiene el funcionamiento
                    }
                }
            }
        } catch (HeladoException e) {
            throw new RuntimeException(e);
        }
        return productoEncontrado;
    }

    public String eliminarHelado(String codigo) {
        String mensaje = "";

        try {
            verificarNoExistenciaHelado(codigo);
            for (int i = 0; i < listaProductos.size(); i++) {
                if (listaProductos.get(i) instanceof Helado) {
                    if (listaProductos.get(i).getCodigo().equals(codigo)) {
                        listaProductos.remove(i);
                        mensaje = "El helado fue eliminado";
                        break;
                    }
                }
            }
        } catch (HeladoException e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }
}
