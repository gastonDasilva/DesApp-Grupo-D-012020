package Modelo;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Entitys.Producto;

import java.util.ArrayList;


public class ListaDeCompras {

    private ArrayList<Producto> productosAcumulados;
    private int montoAcumulado;

    public ArrayList<Producto> getProductosAcumulados() {
        return productosAcumulados;
    }

    public int getMontoAcumulado() {
        return montoAcumulado;
    }

    public void setProductosAcumulados(ArrayList<Producto> productosAcumulados) {
        this.productosAcumulados = productosAcumulados;
    }

    public void setMontoAcumulado(int montoAcumulado) {
        this.montoAcumulado = montoAcumulado;
    }

    public ListaDeCompras(){
        this.setProductosAcumulados(new ArrayList<Producto>());
        this.setMontoAcumulado(0);
    }

    public void agregarProducto(Producto producto){
        this.productosAcumulados.add(producto);
        this.montoAcumulado += producto.getPrecio();
    }


    public int cantidadDeProductosEnLista(){

        return this.getProductosAcumulados().size();
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}