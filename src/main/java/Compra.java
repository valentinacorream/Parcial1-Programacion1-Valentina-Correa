import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Compra {

    private String codigo;
    private LocalDate fechaRealizacion;
    private double valorTotal;
    private MetodoPago metodoPago;

    //Crear lista
    private List<Producto> listaProductos;

    public Compra(String codigo, LocalDate fechaRealizacion, double valorTotal, MetodoPago metodoPago) {
        this.codigo = codigo;
        this.fechaRealizacion = fechaRealizacion;
        this.valorTotal = valorTotal;
        this.metodoPago = metodoPago;

        //iniciar lista
        listaProductos= new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(LocalDate fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo+
                ", Fecha de Realizacion: " + fechaRealizacion +
                ", Valor Total: " + valorTotal+
                ", Metodo de Pago: "+metodoPago+
                ", Lista Productos: "+listaProductos;
    }
}
