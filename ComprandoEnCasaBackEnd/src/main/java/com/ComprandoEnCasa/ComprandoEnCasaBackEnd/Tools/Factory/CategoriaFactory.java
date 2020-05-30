package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Tools.Factory;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Categorias.*;

public class CategoriaFactory {

    public static Categoria getCategoria (String unaCategoria){
        Categoria producto;
        switch (unaCategoria) {
            case "Alimento":
                producto = new Alimento();
                break;
            case "Bebida":
                if (unaCategoria.endsWith("Bebida Alcoholica")) {
                    producto = new BebidaAlcoholica();
                } else {
                    producto = new BebidaSinAlcohol();
                }
                break;
            case "Golosina":
                producto = new Golosina();
                break;
            case "Limplieza":
                producto = new Limpieza();
                break;
            default: //por si no lo encontro
                throw new IllegalStateException("No se encuentra categoria: " + unaCategoria);

        }
        return
    producto;
}
}
