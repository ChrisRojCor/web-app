package co.edu.unbosque.tiendagenericaback.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Proveedores {

    @Id
    private int nit;
    private String nombre_proveedor;
    private String email_proveedor;
    private String telefono_proveedor;
    private String ciudad_proveedor;

    public int getnit() {
        return nit;
    }

    public void setnit(int nit) {
        this.nit = nit;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getEmail_proveedor() {
        return email_proveedor;
    }

    public void setEmail_proveedor(String email_proveedor) {
        this.email_proveedor = email_proveedor;
    }

    public String getTelefono_proveedor() {
        return telefono_proveedor;
    }

    public void setTelefono_proveedor(String telefono_proveedor) {
        this.telefono_proveedor = telefono_proveedor;
    }

    public String getCiudad_proveedor() {
        return ciudad_proveedor;
    }

    public void setCiudad_proveedor(String ciudad_proveedor) {
        this.ciudad_proveedor = ciudad_proveedor;
    }
}
