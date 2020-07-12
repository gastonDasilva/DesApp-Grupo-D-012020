package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model;


import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "BSUsuario")
public  class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String nombreUsuario;
    private String email;
    private String password;
    private String imagenPerfil;
    private Boolean esComercio;

    protected String Calle ;
    protected String localidad ;
    protected String provincia ;
    protected String pais ;
    protected int codigoPostal;

    private int montoGastado;
    private int montoDeCompra;
    private int montoAcumuladoEnAlimentos;
    private int montoAcumuladoEnBebidasAlcoholicas;
    @OneToOne
    private ListaDeCompras listaDeCompras; /*Vendria a hacer la tarea de carrito de compras.*/

    @OneToMany(targetEntity = ListaDeCompras.class)
    @JoinColumn(name="ldc_fk",referencedColumnName = "id")
    private List<ListaDeCompras> historialDeCompras;

    @OneToOne
    private Geo coordenadas;

    /*Atributos del Comercio*/
    private String rubro;

    @OneToMany(targetEntity = HorarioYDiaClass.class)
    @JoinColumn(name="hyd_fk",referencedColumnName = "id")
    private List<HorarioYDiaClass>  diasYHorariosDeAtencion;
    private float distanciaMaximaEnvio;

    @OneToMany(targetEntity = Producto.class)
    @JoinColumn(name="pd_fk",referencedColumnName = "id")
    private List<Producto> productos;


    public Usuario(){};

    public Usuario(String name,String email, String pas){
        setNombreUsuario(name);
        setEmail(email);
        setPassword(pas);
        setEsComercio(false);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Boolean getEsComercio() {
        return esComercio;
    }

    public void setEsComercio(Boolean esComercio) {
        this.esComercio = esComercio;
    }


    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCalle(String calle) {
        Calle = calle;
    }

    public int getMontoAcumuladoEnAlimentos() {
        return montoAcumuladoEnAlimentos;
    }

    public void setMontoAcumuladoEnAlimentos(int montoAcumuladoEnAlimentos) {
        this.montoAcumuladoEnAlimentos = montoAcumuladoEnAlimentos;
    }

    public int getMontoAcumuladoEnBebidasAlcoholicas() {
        return montoAcumuladoEnBebidasAlcoholicas;
    }

    public void setMontoAcumuladoEnBebidasAlcoholicas(int montoAcumuladoEnBebidasAlcoholicas) {
        this.montoAcumuladoEnBebidasAlcoholicas = montoAcumuladoEnBebidasAlcoholicas;
    }

    public int getMontoDeCompra() {
        return montoDeCompra;
    }

    public void setMontoDeCompra(int montoDeCompra) {
        this.montoDeCompra = montoDeCompra;
    }

    public int getMontoGastado() {
        return montoGastado;
    }

    public void setMontoGastado(int montoGastado) {
        this.montoGastado = montoGastado;
    }

    public List<ListaDeCompras> getHistorialDeCompras() {
        return historialDeCompras;
    }

    public void setHistorialDeCompras(List<ListaDeCompras> historialDeCompras) {
        this.historialDeCompras = historialDeCompras;
    }

    public ListaDeCompras getListaDeCompras() {
        return listaDeCompras;
    }

    public void setListaDeCompras(ListaDeCompras listaDeCompras) {
        this.listaDeCompras = listaDeCompras;
    }

    public Geo getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Geo coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(String imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }


    /*Comercio*/


    public List<HorarioYDiaClass> getDiasYHorariosDeAtencion() {
        return diasYHorariosDeAtencion;
    }

    public void setDiasYHorariosDeAtencion(List<HorarioYDiaClass> diasYHorariosDeAtencion) {
        this.diasYHorariosDeAtencion = diasYHorariosDeAtencion;
    }

    public float getDistanciaMaximaEnvio() {
        return distanciaMaximaEnvio;
    }

    public void setDistanciaMaximaEnvio(float distanciaMaximaEnvio) {
        this.distanciaMaximaEnvio = distanciaMaximaEnvio;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }



    public void convertirAComercio(){
        setEsComercio(true);
    }


    public void agregarProductoForComercio(Producto producto ){
        if(esComercio.equals(true)){
            productos.add(producto);
        }
    }

    private void agregarHistorialDeCOmpras(ListaDeCompras listaDeCompras){
        getHistorialDeCompras().add(listaDeCompras);
    }

    public void generarComprar(){
        /*A partir del modo envio(retirar en el local o envio a domicilio) genero la compra*/
        agregarHistorialDeCOmpras(getListaDeCompras());
    }

    public Date getTurnoFechaFromUserComprador(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        String diasemana = diaSemana();
        if(diasemana.equals("S")){
            calendar.add(Calendar.DAY_OF_YEAR, 2);
        }else if (diasemana.equals("D")){
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }
        return calendar.getTime();
    }

    public String diaSemana ()
    {
        String letraD="";
        TimeZone timezone = TimeZone.getDefault();
        Calendar calendar = new GregorianCalendar(timezone);
        int nD=calendar.get(Calendar.DAY_OF_WEEK);
        switch (nD){
            case 1: letraD = "D";
                break;
            case 2: letraD = "L";
                break;
            case 3: letraD = "M";
                break;
            case 4: letraD = "X";
                break;
            case 5: letraD = "J";
                break;
            case 6: letraD = "V";
                break;
            case 7: letraD = "S";
                break;
        }

        return letraD;
    }


}