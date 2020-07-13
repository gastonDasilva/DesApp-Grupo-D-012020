package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Tools.DaysCTE;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BShorarioYDias")
public class HorarioYDiaClass {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String dia;
    private int horarioInicio;
    private int horarioFin;


    public HorarioYDiaClass(){
    }
    public HorarioYDiaClass(String name, int hinicio, int hfin){
        setDia(name);
        setHorarioFin(hfin);
        setHorarioInicio(hinicio);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getHorarioFin() {
        return horarioFin;
    }

    public void setHorarioFin(int horarioFin) {
        this.horarioFin = horarioFin;
    }

    public int getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(int horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public static List<String> getDiasSemanales(){
        /*hago un get de los dias que tiene la semana, este metodo se usa para generar los horarios y dias de atencion de un comercio.*/
        List<String> diassemanales = new ArrayList<String>();
        diassemanales.add(DaysCTE.lunes);
        diassemanales.add(DaysCTE.martes);
        diassemanales.add(DaysCTE.miercoles);
        diassemanales.add(DaysCTE.Jueves);
        diassemanales.add(DaysCTE.Viernes);
        diassemanales.add(DaysCTE.Sabado);
        diassemanales.add(DaysCTE.Domingo);
        return diassemanales;
    }
}
