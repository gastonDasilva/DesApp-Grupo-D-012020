package modelo;

public class Cliente extends Usuario {

    private String direccion;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Cliente(){}

    public Cliente(String direccion){
        this.setDireccion(direccion);
    }
}
