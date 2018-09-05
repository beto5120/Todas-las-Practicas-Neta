/**
 * 
 */
package net.netasystems.spring_hola_mundo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.netasystems.beans.Mundo;

/**
 * Esta clase manda a llamar a un xml
 * 
 * @author Neta Systems / Jose Alberto Fuentes Loredo
 *
 */
public class App {

	/**
	 * Manda a llamar al xml para imprimir en cosola
	 * @param args metodo main
	 */
	public static void main(String[] args) {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("net/netasystems/xml/beans.xml");
		Mundo m = (Mundo) appContext.getBean("mundo");
		
		System.out.println(m.getSaludo());

	}

}
