import java.time.LocalDate;

public class Compra {

    private String codigo;
    private LocalDate fechaRealizacion;
    private double valorTotal;
    private MetodoPago metodoPago;

    public Compra(String codigo, LocalDate fechaRealizacion, double valorTotal, MetodoPago metodoPago) {
        this.codigo = codigo;
        this.fechaRealizacion = fechaRealizacion;
        this.valorTotal = valorTotal;
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

    @Override
    public String toString() {
        return "Codigo: " + codigo+
                ", Fecha de Realizacion: " + fechaRealizacion +
                ", Valor Total: " + valorTotal+
                ", Metodo de Pago: "+metodoPago;
    }
}
