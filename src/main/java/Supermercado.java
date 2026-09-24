import java.util.ArrayList;
import java.util.List;

public class Supermercado {
    private String nombre;
    private String direccion;
    private int telefono;

    //Creación de listas
    private List<Cliente> listaClientes;
    private List<Compra> listaCompras;
    private List<Producto> listaProductos;

    public Supermercado(String nombre, String direccion, int telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;

        //Iniciar listas
        listaClientes= new ArrayList<>();
        listaCompras= new ArrayList<>();
        listaProductos= new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Compra> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre+
                ", Direccion: " + direccion+
                ", Telefono: " + telefono+
                ", Lista Clientes: "+listaClientes+
                ", Lista Compras: "+listaCompras+
                ", Lista Productos: "+listaProductos;
    }

    //==== Clientes ====
    //Verificar Cliente
    public boolean verificarClientes(int documento){
        boolean existe= false;
        for (Cliente cliente: listaClientes){
            if (cliente.getDocumento()== documento){
                existe= true;
                break;
            }
        }
        return existe;
    }

    //Agregar Cliente
    public  boolean  agregarCliente(Cliente cliente){
        boolean agregado= false;
        boolean existe= verificarClientes(cliente.getDocumento());
        if (existe==false){
            listaClientes.add(cliente);
            agregado= true;
        }
        return  agregado;
    }

    //Actualizar cliente
    public boolean actualizarCliente(int documento, Cliente clienteActualizado){
        boolean estaActualizado= false;
        for (Cliente cliente: listaClientes){
            if (cliente.getDocumento()== documento){
                cliente.setNombre(clienteActualizado.getNombre());
                cliente.setTelefono(clienteActualizado.getTelefono());
                cliente.setCorreo(clienteActualizado.getCorreo());

                estaActualizado= true;
                break;
            }
        }
        return estaActualizado;
    }

    //Historial de compras del Cliente
    public List<Compra> mostrarHistorialCliente(int documento){
        boolean existe= verificarClientes(documento);
        List<Compra> historialCliente= new ArrayList<>();
        if (existe== true){
            for (Cliente cliente: listaClientes){
                if (cliente.getDocumento()== documento){
                    historialCliente= cliente.getListaCompras();
                }
            }
        }
        return historialCliente;
    }

    //Eliminar Cliente
    public boolean eliminarCliente(int documento){
        boolean esEliminado= false;
        for (Cliente cliente: listaClientes){
            if (cliente.getDocumento()== documento){
                listaClientes.remove(cliente);
                esEliminado= true;
                break;
            }
        }
        return esEliminado;
    }

    //==== Productos ====
    //Verificar productos
    public boolean verificarProductos(String codigo){
        boolean existe= false;
        for (Producto produto: listaProductos){
            if (produto.getCodigo().equalsIgnoreCase(codigo)){
                existe= true;
                break;
            }
        }
        return existe;
    }

    //Agregar Producto
    public  boolean  agregarProducto(Producto producto){
        boolean agregado= false;
        boolean existe= verificarProductos(producto.getCodigo());
        if (existe==false){
            listaProductos.add(producto);
            agregado= true;
        }
        return  agregado;
    }

    //Validar disponibilidad de productos
    public boolean validarDisponibilidad(int cantidadRequerida, Producto productoDisponible){
        boolean hayDisponible= false;
            for (Producto producto : listaProductos) {
                if (producto.getCodigo().equalsIgnoreCase(productoDisponible.getCodigo())) {
                    if (producto.getCantidadDisponible() >= cantidadRequerida) {
                        hayDisponible = true;
                    }
                    break;
                }
            }
        return hayDisponible;
    }

    public boolean descontarCantidad(int cantidadVendida, String codigo){
        boolean descontado= false;
        for (Producto producto: listaProductos){
            if (producto.getCodigo().equalsIgnoreCase(codigo)){
                if (producto.getCantidadDisponible() >= cantidadVendida){
                    int nuevaDisponibilidad= producto.getCantidadDisponible() - cantidadVendida;
                    producto.setCantidadDisponible(nuevaDisponibilidad);
                    descontado= true;
                }
                break;
            }
        }
        return descontado;
    }

    //Actualizar Productos
    public boolean actualizarProducto(String codigo, Producto productoActualizado){
        boolean estaActualizado= false;
        for (Producto producto: listaProductos){
            if (producto.getCodigo().equalsIgnoreCase(codigo)){
                producto.setNombre(productoActualizado.getNombre());
                producto.setPrecioUnitario(productoActualizado.getPrecioUnitario());
                producto.setCantidadDisponible(productoActualizado.getCantidadDisponible());

                estaActualizado= true;
                break;
            }
        }
        return estaActualizado;
    }

    //Eliminar producto
    public boolean eliminarProducto(String codigo){
        boolean esEliminado= false;
        for (Producto producto: listaProductos){
            if (producto.getCodigo().equalsIgnoreCase(codigo)){
                listaProductos.remove(producto);
                esEliminado= true;
                break;
            }
        }
        return esEliminado;
    }

    //==== Compras ====
    //Verificar Compra
    public boolean verificarCompra(String codigo){
        boolean existe= false;
        for (Compra compra: listaCompras){
            if (compra.getCodigo().equalsIgnoreCase(codigo)){
                existe= true;
                break;
            }
        }
        return  existe;
    }

    //Realizar Compra
    public boolean realizarCompra(int documento, Compra compra){
        boolean realizada= false;
        boolean existe= verificarCompra(compra.getCodigo());
        if (existe==false) {
            for (Cliente cliente : listaClientes) {
                if (cliente.getDocumento() == documento) {
                    listaCompras.add(compra);
                    cliente.getListaCompras().add(compra);
                    realizada = true;
                    break;
                }
            }
        }
        return realizada;
    }

    //Agregar producto a la compra
    public boolean agregarProductoCompra(String codigoCompra, String codigoProducto, int cantidad){
        boolean productoAgregado= false;
        for (Compra compra: listaCompras){
            if (compra.getCodigo().equalsIgnoreCase(codigoCompra)){
                for (Producto producto: listaProductos){
                    if (producto.getCodigo().equalsIgnoreCase(codigoProducto)){
                        if (validarDisponibilidad(cantidad, producto)){
                            for (int i=0; i < cantidad; i++){
                                compra.getListaProductos().add(producto);
                            }
                            descontarCantidad(cantidad, codigoProducto);
                            productoAgregado= true;
                        }
                        break;
                    }
                }
                break;
            }
        }
        return productoAgregado;
    }

    //Calcular total de la compra
    public double calcularValorTotal(Compra compra){
        double total= 0;
        for (Producto producto: compra.getListaProductos()){
            total+= producto.getPrecioUnitario();
        }
        compra.setValorTotal(total);
        return total;
    }

}
