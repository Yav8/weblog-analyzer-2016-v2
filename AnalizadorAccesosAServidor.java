import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * La clase AnalizadorAccesosAServidor analiza los accesos
 * producidos al servidor.
 * @author Javier de Cea Dominguez.
 * @version 2018.03.03
 */
public class AnalizadorAccesosAServidor
{
    private ArrayList<Acceso> accesos;
    
    /**
     * Constructor para objetos de la clase AnalizadorAccesosAServidor.
     */
    public AnalizadorAccesosAServidor() 
    {
        accesos = new ArrayList<>();
    }
    
    /**
     * Lee el archivo de log introducido por parametro y guarda sus datos.
     * @param archivo El nombre del archivo de log que va a ser leido.
     */    
    public void analizarArchivoDeLog(String archivo)
    {
        accesos.clear();
        File archivoALeer = new File(archivo);
        try {
            Scanner sc = new Scanner(archivoALeer);
            while (sc.hasNextLine()) {
                String lineaLeida = sc.nextLine();                               
                Acceso accesoActual = new Acceso(lineaLeida);               
                
                accesos.add(accesoActual);
            }
            sc.close();
        }
        catch (Exception e) {
            System.out.println("Ocurrio algun error al leer el archivo.");
        }
    }
    
    /**
     * Devuelve la hora con mas accesos. Si hay empate devuelve la mas alta.
     * @return Devuelve un int que equivale a la hora con mas accesos.
     * Si hay empate, devuelve la hora mas alta, o si no hay datos de 
     * acceso devuelve -1.
     */    
    public int obtenerHoraMasAccesos() 
    {
        int valorADevolver = -1;
        
        if (!accesos.isEmpty()) {
            int[] accesosPorHora = new int[24];
    
            for (Acceso accesoActual : accesos) {
                int horaAccesoActual = accesoActual.getHora();
                accesosPorHora[horaAccesoActual] = accesosPorHora[horaAccesoActual] + 1;
            }
            
            int numeroDeAccesosMasAlto = accesosPorHora[0];
            int horaDeAccesosMasAlto = 0;
            for (int i = 0; i < accesosPorHora.length; i++) {
                if (accesosPorHora[i] >= numeroDeAccesosMasAlto) {
                    numeroDeAccesosMasAlto = accesosPorHora[i];
                    horaDeAccesosMasAlto = i;
                }
            }
            
            valorADevolver = horaDeAccesosMasAlto;                      
        }
        
        return valorADevolver;
    }

    
    
    public String paginaWebMasSolicitada() 
    {
        return "";
    }
    
    public String clienteConMasAccesosExitosos()
    {
        return "";
    }


}
