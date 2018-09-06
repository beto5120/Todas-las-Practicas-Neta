package net.netasystems.business;

import org.springframework.stereotype.Component;

/**
 * Esta clase solo retorna java rules y la version
 * 
 * @author Neta Systems / Jose Alberto Fuentes Loredo
 *
 */


@Component
public class JavaLanguage implements Languaje {
    public String description() {
        return "Java rules!!";
    }

	/* (non-Javadoc)
	 * @see net.netasystems.business.Languaje#version()
	 */
	public String version() {
		// TODO Auto-generated method stub
		return " 1.8.0";
	}
}
