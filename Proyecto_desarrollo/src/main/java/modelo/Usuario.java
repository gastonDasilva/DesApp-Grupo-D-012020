package modelo;

public abstract class Usuario {

    protected String nombreUsuario;
    protected String email;
    protected String password;
    protected App app;


    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public App getApp() { return app; }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setApp(App app) { this.app = app; }
}
