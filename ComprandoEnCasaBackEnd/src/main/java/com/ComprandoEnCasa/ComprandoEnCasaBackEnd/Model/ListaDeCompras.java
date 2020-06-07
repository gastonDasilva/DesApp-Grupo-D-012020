package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Producto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BSListadecompras")
public class ListaDeCompras {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @OneToMany(targetEntity = Producto.class)
    @JoinColumn(name="cp_fk",referencedColumnName = "id")
    private List<Producto> productosAcumulados;
    private int montoAcumulado;

    public ListaDeCompras(){
        this.setProductosAcumulados(new ArrayList<Producto>());
        this.setMontoAcumulado(0);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Producto> getProductosAcumulados() {
        return productosAcumulados;
    }

    public int getMontoAcumulado() {
        return montoAcumulado;
    }

    public void setProductosAcumulados(List<Producto> productosAcumulados) {
        this.productosAcumulados = productosAcumulados;
    }

    public void setMontoAcumulado(int montoAcumulado) {
        this.montoAcumulado = montoAcumulado;
    }



    public void agregarProducto(Producto producto){
        this.productosAcumulados.add(producto);
        this.montoAcumulado += producto.getPrecio();
    }

    public int cantidadDeProductosEnLista(){

        return this.getProductosAcumulados().size();
    }


}