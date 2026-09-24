public class Producto {

    private String codigo;
    private String nombre;
    private double precioUnitario;
    private int cantidadDisponible;
    private Categoria categoria;

    public Producto(String codigo, String nombre, double precioUnitario, int cantidadDisponible, Categoria categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidadDisponible = cantidadDisponible;
        this.categoria = categoria;
    }

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

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo +
                ", Nombre: " + nombre +
                ", Preci oUnitario: " + precioUnitario +
                ", Cantidad Disponible: " + cantidadDisponible+
                ", Categoria: "+categoria;
    }
}
