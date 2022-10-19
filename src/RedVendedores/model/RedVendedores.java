package RedVendedores.model;

import RedVendedores.exceptions.CafeException;
import RedVendedores.exceptions.GaseosaException;
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

    //---------------------------------------CRUD_VENDEDOR------------------------------------------------//

    /**
     * metodo para crear un vendedor
     *
     * @param nuevoVendedor
     * @return
     */
    public String crearVendedor(Vendedor nuevoVendedor) throws VendedorException {
        String mensaje = "";

        try {
            verificarRepetido(nuevoVendedor.getCedula()); // esta invocacion es para verificar si no se a creado
            listaVendedores.add(nuevoVendedor);
            mensaje = "el vendedor fue creado";
        } catch (VendedorException e) {
            throw new VendedorException("El vendedor no existe");
        }
        return mensaje;
    }

    /**
     * metodo para verificar si existe el vendedor
     *
     * @param cedula
     * @throws VendedorException
     */
    private void verificarRepetido(String cedula) throws VendedorException {
        for (Vendedor vendedor : listaVendedores) {
            if (vendedor.getCedula().equals(cedula)) {
                throw new VendedorException("El vendedor ya existe");
            }
        }
    }

    /**
     * metodo para verificar si el vendedor no existe
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

    //------------------------------------CRUD_HELADO-----------------------------------------------//

    /**
     * Create an ice cream
     * @param nuevoHelado
     * @return
     */
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

    /**
     * Verify existence ice cream
     * @param codigo
     * @throws HeladoException
     */
    private void verificarExistenciaHelado(String codigo) throws HeladoException {
        for (Producto producto : listaProductos) {
            if (producto instanceof Helado) {
                if (producto.getCodigo().equals(codigo))
                    throw new HeladoException("El helado ya existe");
            }
        }
    }

    /***
     *  Check if it not exists an ice cream
     * @param codigo
     * @throws HeladoException
     */
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

    /**
     * Search ice cream
     * @param codigo
     * @return
     */
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

    /**
     * Delete ice cream
     * @param codigo
     * @return
     */
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

    /**
     * uptade ice cream
     * @param categoria
     * @param codigo
     * @param nombre
     * @param precio
     * @param sabor
     * @param tamanio
     * @return
     */
    public String actualizarHelado(String categoria, String codigo, String nombre, double precio, String sabor, String tamanio) {
        String mensaje = "";

        try {
            verificarNoExistenciaHelado(codigo);
            for (int i = 0; i < listaProductos.size(); i++) {
                if (listaProductos.get(i) instanceof Helado) {
                    if (listaProductos.get(i).getCodigo().equals(codigo)) {
                        ((Helado)listaProductos.get(i)).setNombre(nombre);
                        ((Helado)listaProductos.get(i)).setCategoria(categoria);
                        ((Helado)listaProductos.get(i)).setPrecio(precio);
                        ((Helado)listaProductos.get(i)).setSabor(sabor);
                        ((Helado)listaProductos.get(i)).setTamanio(tamanio);
                        mensaje = "El vendedor fue actualizado";
                        break;
                    }
                }
            }
        } catch (HeladoException e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    //---------------------------------------CRUD_GASEOSA------------------------------------------------//

    /**
     * metodo para crear una gaseosa
     * @param nuevaGaseosa
     * @return
     */
    public String crearGaseosa(Gaseosa nuevaGaseosa){
        String mensaje = "";

        try {
            verificarExistenciaGaseosa(nuevaGaseosa.getCodigo());
            listaProductos.add(nuevaGaseosa);
            mensaje = "el gaseosa fue creada";
        } catch (GaseosaException e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    /**
     * metodo para verificar si existe la gaseosa
     * @param codigo
     * @throws GaseosaException
     */
    private void verificarExistenciaGaseosa(String codigo) throws GaseosaException {
        for (Producto producto : listaProductos) {
            if (producto instanceof Gaseosa) {
                if (producto.getCodigo().equals(codigo))
                    throw new GaseosaException("La gaseosa ya existe");
            }
        }
    }

    /**
     * metodo para verificar que no existe la gaseosa
     * @param codigo
     * @throws GaseosaException
     */
    public void verificarNoExistenciaGaseosa(String codigo) throws GaseosaException{
        Producto producto = null;
        for (Producto producto1 : listaProductos) {
            if (producto1 instanceof Gaseosa) {
                if (producto1.getCodigo().equals(codigo)) {
                    producto = producto1;
                    break;
                }
            }
        }
        if (producto == null) {
            throw new GaseosaException("La gaseosa no existe");
        }
    }

    /**
     * metodo para buscar una gaseosa
     * @param codigo
     * @return
     */
    public Producto buscarGaseosa(String codigo){
        Producto productoEncontrado = null;

        try {
            //esta invocacion verifica si el helado existe o no
            verificarNoExistenciaGaseosa(codigo);
            for (Producto producto : listaProductos) {
                if (producto instanceof Gaseosa) {
                    if (producto.getCodigo().equals(codigo)) {
                        productoEncontrado = (Gaseosa) producto;
                        break; //detiene el funcionamiento
                    }
                }
            }
        } catch (GaseosaException e) {
            throw new RuntimeException(e);
        }
        return productoEncontrado;
    }

    /**
     * metodo para eliminar una gaseosa
     * @param codigo
     * @return
     */
    public String eliminarGaseosa(String codigo){
        String mensaje = "";

        try {
            verificarNoExistenciaGaseosa(codigo);
            for (int i = 0; i < listaProductos.size(); i++) {
                if (listaProductos.get(i) instanceof Gaseosa) {
                    if (listaProductos.get(i).getCodigo().equals(codigo)) {
                        listaProductos.remove(i);
                        mensaje = "La gaseosa fue eliminada";
                        break;
                    }
                }
            }
        } catch (GaseosaException e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    /**
     * metodo para actualizar una gaseosa
     * @param categoria
     * @param codigo
     * @param nombre
     * @param precio
     * @param litros
     * @param sabor
     * @return
     */
    public String actualizarGaseosa(String categoria, String codigo, String nombre, double precio, String litros, String sabor) {
        String mensaje = "";

        try {
            verificarNoExistenciaGaseosa(codigo);
            for (int i = 0; i < listaProductos.size(); i++) {
                if (listaProductos.get(i) instanceof Gaseosa) {
                    if (listaProductos.get(i).getCodigo().equals(codigo)) {
                        ((Gaseosa)listaProductos.get(i)).setNombre(nombre);
                        ((Gaseosa)listaProductos.get(i)).setCategoria(categoria);
                        ((Gaseosa)listaProductos.get(i)).setPrecio(precio);
                        ((Gaseosa)listaProductos.get(i)).setSabor(sabor);
                        ((Gaseosa)listaProductos.get(i)).setLitros(litros);
                        mensaje = "El vendedor fue actualizado";
                        break;
                    }
                }
            }
        } catch (GaseosaException e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    //---------------------------------------CRUD_CAFE----------------------------------------------------//

    /**
     * metodo para crear un nuevo cafe
     * @param nuevoCafe
     * @return
     */
    public String crearCafe(Cafe nuevoCafe){
        String mensaje = "";

        try {
            verificarExistenciaCafe(nuevoCafe.getCodigo());
            listaProductos.add(nuevoCafe);
            mensaje = "el cafe fue creado";
        } catch (CafeException e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    /**
     * metodo para verificar si el cafe existe
     * @param codigo
     * @throws CafeException
     */
    private void verificarExistenciaCafe(String codigo) throws CafeException {
        for (Producto producto : listaProductos) {
            if (producto instanceof Cafe) {
                if (producto.getCodigo().equals(codigo))
                    throw new CafeException("El cafe ya existe");
            }
        }
    }

    /**
     * metodo para verificar que no existe el cafe
     * @param codigo
     * @throws CafeException
     */
    public void verificarNoExistenciaCafe(String codigo) throws CafeException{
        Producto producto = null;
        for (Producto producto1 : listaProductos) {
            if (producto1 instanceof Cafe) {
                if (producto1.getCodigo().equals(codigo)) {
                    producto = producto1;
                    break;
                }
            }
        }
        if (producto == null) {
            throw new CafeException("El cafe no existe");
        }
    }

    /**
     *metodo para buscar un cafe
     * @param codigo
     * @return
     */
    public Producto buscarCafe(String codigo){
        Producto productoEncontrado = null;

        try {
            //esta invocacion verifica si el helado existe o no
            verificarNoExistenciaCafe(codigo);
            for (Producto producto : listaProductos) {
                if (producto instanceof Cafe) {
                    if (producto.getCodigo().equals(codigo)) {
                        productoEncontrado = (Cafe) producto;
                        break; //detiene el funcionamiento
                    }
                }
            }
        } catch (CafeException e) {
            throw new RuntimeException(e);
        }
        return productoEncontrado;
    }

    /**
     * metodo para eliminar un cafe
     * @param codigo
     * @return
     */
    public String eliminarCafe(String codigo){
        String mensaje = "";

        try {
            verificarNoExistenciaCafe(codigo);
            for (int i = 0; i < listaProductos.size(); i++) {
                if (listaProductos.get(i) instanceof Cafe) {
                    if (listaProductos.get(i).getCodigo().equals(codigo)) {
                        listaProductos.remove(i);
                        mensaje = "El cafe fue eliminada";
                        break;
                    }
                }
            }
        } catch (CafeException e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    /**
     * metodo para actualizar cafe
     * @param categoria
     * @param codigo
     * @param nombre
     * @param precio
     * @param libras
     * @return
     */
    public String actualizarCafe(String categoria, String codigo, String nombre, double precio, String libras) {
        String mensaje = "";

        try {
            verificarNoExistenciaCafe(codigo);
            for (int i = 0; i < listaProductos.size(); i++) {
                if (listaProductos.get(i) instanceof Cafe) {
                    if (listaProductos.get(i).getCodigo().equals(codigo)) {
                        ((Cafe)listaProductos.get(i)).setNombre(nombre);
                        ((Cafe)listaProductos.get(i)).setCategoria(categoria);
                        ((Cafe)listaProductos.get(i)).setPrecio(precio);
                        ((Cafe)listaProductos.get(i)).setLibras(libras);
                        mensaje = "El vendedor fue actualizado";
                        break;
                    }
                }
            }
        } catch (CafeException e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

}
