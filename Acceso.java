/**
 * La clase Acceso recoge datos relacionados al momento 
 * que se accede al servidor (año, mes, día, hora, minutos).
 * @author Javier de Cea Dominguez.
 * @version 2018.03.03
 */
public class Acceso
{
    private int ano;
    private int mes;
    private int dia;
    private int hora;
    private int minutos;
    
    /**
     * Constructor para objetos de la clase Acceso.
     * @param datosDeAccesoAlServidor El texto que contiene la 
     * direccion IP del cliente, el momento exacto al que ha accedido 
     * al servidor, la pagina web que solicita y el codigo HTTP con el 
     * que responde el servidor. Debe tener el siguiente formato para 
     * que la clase AnalizadorAccesosAServidor pueda leer archivos con 
     * este contenido: 
     * "direccion_IP [aaaa mm dd hh mm] ruta_de_la_pagina_web codigo".
     * Ejemplo: "91.244.73.61 [2016 01 01 10 56] instituto/normativa.html 403".
     */
    public Acceso(String datosDeAccesoAlServidor)
    {
        String[] datosDeAccesoSeparados = datosDeAccesoAlServidor.split(" ");
        ano = Integer.parseInt(datosDeAccesoSeparados[1].substring(1,5));
        mes = Integer.parseInt(datosDeAccesoSeparados[2]);
        dia = Integer.parseInt(datosDeAccesoSeparados[3]);
        hora = Integer.parseInt(datosDeAccesoSeparados[4]);
        minutos = Integer.parseInt(datosDeAccesoSeparados[5].substring(0,2));
    }
    
    /**
     * Devuelve el año en el que el cliente ha accedido al servidor.
     * @return Devuelve un int que es el año.
     */
    public int getAno() 
    {
        return ano;
    }
    
    /**
     * Devuelve el mes en el que el cliente ha accedido al servidor.
     * @return Devuelve un int que es el mes.
     */    
    public int getMes()
    {
        return mes;
    }
    
    /**
     * Devuelve el dia en el que el cliente ha accedido al servidor.
     * @return Devuelve un int que es el dia.
     */    
    public int getDia()
    {
        return dia;
    }
    
    /**
     * Devuelve la hora en la que el cliente ha accedido al servidor.
     * @return Devuelve un int que es la hora.
     */    
    public int getHora()
    {
        return hora;
    }
    
    /**
     * Devuelve el minuto en el que el cliente ha accedido al servidor.
     * @return Devuelve un int que es el minuto.
     */    
    public int getMinutos()
    {
        return minutos;
    }
}