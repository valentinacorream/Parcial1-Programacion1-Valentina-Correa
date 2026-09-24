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
}
