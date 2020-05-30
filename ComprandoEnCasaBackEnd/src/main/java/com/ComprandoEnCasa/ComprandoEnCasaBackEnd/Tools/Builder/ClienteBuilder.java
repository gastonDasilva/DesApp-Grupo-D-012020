package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Tools.Builder;

public class ClienteBuilder {
    private String nameCLiente = "no cliente";
    private String  email = "no email";
    private String pass = "no pass";
    public static ClienteBuilder aCliente() {

        return new ClienteBuilder();

    }
    public ClienteBuilder withName(final String aName) {

        this.nameCLiente = aName;
        return this;
    }


}
