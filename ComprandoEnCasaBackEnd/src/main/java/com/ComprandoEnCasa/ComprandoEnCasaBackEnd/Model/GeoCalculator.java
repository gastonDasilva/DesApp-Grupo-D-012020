package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Geo;

public class GeoCalculator {
    
    private Double EARTH_RAIUS = 6371.0;

    private Double deg2rad(Double dec) {
        return dec *(Math.PI / 180);
    }

    public Double distance(Geo geo1, Geo geo2){
        Double dLat = deg2rad(geo2.getLatitude() - geo1.getLatitude());
        Double dLon = deg2rad(geo2.getLongitude() - geo1.getLongitude());
        Double temp1 = Math.pow(Math.sin(dLat / 2), 2.0);
        Double temp2 = Math.cos(deg2rad(geo1.getLatitude())) * Math.cos(deg2rad(geo2.getLatitude())) * Math.pow(
                Math.sin(dLon / 2), 2.0);
        Double a = temp1 + temp2;
        Double aTan = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        Double res = aTan * EARTH_RAIUS;
        return Math.floor(res * 100) / 100;
    }
}
