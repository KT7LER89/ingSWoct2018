
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
 
public class calcularEdad {
 
    public static void main(String[] args) {

         try {
         Scanner s;   
         s = new Scanner(System.in);
         System.out.println("Ingrese el dia de nacimiento DD:");
         int d = s.nextInt();
         System.out.println("Ingrese el mes de nacimiento MM:");
         int m = s.nextInt();
         System.out.println("Ingrese el año de nacimiento AAAA:");
         int a = s.nextInt();
         s.close();
             
           System.out.println("Para la fecha de nacimiento "+ d + "/"+m+ "/"+a+" los años calculados son "+calcular(new GregorianCalendar(a,m,d)));
           
           String ruta = "C://Users/tyler/Desktop/deber/filename.txt";
            String contenido = "Para la fecha de nacimiento "+ d + "/"+m+ "/"+a+" los años calculados son "+ Integer.toString(calcular(new GregorianCalendar(a,m,d)));
            File file = new File(ruta);
             // Si el archivo no existe es creado
            if (!file.getParentFile().exists())
                file.getParentFile().mkdirs();
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    public static int calcular(Calendar fechaNac) {
        Calendar fechaActual = Calendar.getInstance();
 
        // Cálculo de las diferencias.
        int years = fechaActual.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
        int months = fechaActual.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
        int days = fechaActual.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);
       
        // Hay que comprobar si el día de su cumpleaños es posterior
        // a la fecha actual, para restar 1 a la diferencia de años,
        // pues aún no ha sido su cumpleaños.
 
        if(months < 0 // Aún no es el mes de su cumpleaños.
           || (months==0 && days < 0)) { // o es el mes pero no ha llegado el día.
            years--;
        }
        return years;
        
         
    }
}

