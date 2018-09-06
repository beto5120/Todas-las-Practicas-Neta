package net.netasystems.main;

import net.netasystems.business.Programmer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Esta es la clase main para ejecutar el programa
 * 
 * @author Neta Systems / Jose Alberto Fuentes Loredo
 *
 */
public class Main {

    /**
     * Se manda a llamr el xml desde la carpeta de documentos de la computadora
     * e imprime el lenguaje y la version
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio #2 de Spring");
        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\NS-388\\Documents\\applicationContext.xml");
        Programmer prgm1 = context.getBean("alberto", Programmer.class);
        Programmer prgm2 = context.getBean("masterProgrammer", Programmer.class);
        System.out.println("El programador #1 lo hace en: "+prgm1.hackTheWorld()+ " "+prgm1.hackTheWorld2());
        System.out.println("El programador #2 lo hace en: "+prgm2.hackTheWorld()+ " "+prgm2.hackTheWorld2());
    }

}
