
package modelo;

public class CabeceraVenta {
    private int idCabeceraVenta;
    private int idCliente;
    private double valorPagar;
    private String fechaVenta;
    private int estado;
    
    public CabeceraVenta (){
        idCabeceraVenta = 0;
        idCliente = 0;
        valorPagar = 0.0;
        fechaVenta = "";
        estado = 0;
        
    }

    public CabeceraVenta(int idCabeceraVenta, int idCliente, double valorPagar, String fechaVenta, int estado) {
        this.idCabeceraVenta = idCabeceraVenta;
        this.idCliente = idCliente;
        this.valorPagar = valorPagar;
        this.fechaVenta = fechaVenta;
        this.estado = estado;
    }

    public int getIdCabeceraVenta() {
        return idCabeceraVenta;
    }

    public void setIdCabeceraVenta(int idCabeceraVenta) {
        this.idCabeceraVenta = idCabeceraVenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
}
