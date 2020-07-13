package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Tools;

public  class DaysCTE {
    public static String lunes = "Lunes";
    public static String martes = "Martes";
    public static String miercoles = "Miercoles";
    public static String Jueves = "Jueves";
    public static String Viernes = "Viernes";
    public static String Sabado = "Sabado";
    public static String Domingo = "Domingo";


    public static String getDomingo() {
        return Domingo;
    }

    public static void setDomingo(String domingo) {
        Domingo = domingo;
    }


    public static String getLunes() {
        return lunes;
    }

    public static void setLunes(String lunes) {
        DaysCTE.lunes = lunes;
    }
}
