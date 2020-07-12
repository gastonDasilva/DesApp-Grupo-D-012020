package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Dao;

public class CompraDAO {
    private long idUsuario;
    private Integer modoEnvio;


    public CompraDAO (){}


    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getIdUsuario() {
        return idUsuario;
    }
    public Integer getModoEnvio() {
        return modoEnvio;
    }
    public void setModoEnvio(Integer modoEnvio) {
        this.modoEnvio = modoEnvio;
    }

}
