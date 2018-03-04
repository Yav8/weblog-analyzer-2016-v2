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
     * @param momentoDeAccesoAlServidor El texto que contiene la 
     * fecha y hora exacta en la que el cliente ha accedido al 
     * servidor. Debe tener el siguiente formato para que la clase 
     * AnalizadorAccesosAServidor pueda leer archivos con este contenido: 
     * "aaaa mm hh dd mm".
     */
    public Acceso(String momentoDeAccesoAlServidor)
    {
        ano = Integer.parseInt(momentoDeAccesoAlServidor.substring(0, 4));
        mes = Integer.parseInt(momentoDeAccesoAlServidor.substring(5, 7));
        dia = Integer.parseInt(momentoDeAccesoAlServidor.substring(8, 10));
        hora = Integer.parseInt(momentoDeAccesoAlServidor.substring(11, 13));
        minutos = Integer.parseInt(momentoDeAccesoAlServidor.substring(14, 16));
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