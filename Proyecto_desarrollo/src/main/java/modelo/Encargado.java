package modelo;

public class Encargado extends Usuario {

    private String cuil;

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public Encargado(String nombre, String cuil, String email) {
        this.setNombreUsuario(nombre);
        this.setEmail(email);
        this.setCuil(cuil);
    }
}
