package co.edu.unbosque.tiendagenericaback.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Productos {

    @Id
    private int codigo_producto;
    private String nombre_producto;
    private int nitproveedor;
    private double precio_compra;
    private int ivacompra;
    private double precio_venta;

    public int getIvacompra() {
        return ivacompra;
    }

    public void setIvacompra(int ivacompra) {
        this.ivacompra = ivacompra;
    }

    public int getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(int codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getNitproveedor() {
        return nitproveedor;
    }

    public void setNitproveedor(int nitproveedor) {
        this.nitproveedor = nitproveedor;
    }

    public double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }
}
