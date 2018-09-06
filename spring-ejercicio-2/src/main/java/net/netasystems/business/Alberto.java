package net.netasystems.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


/**
 * Esta es la clase de Alberto y se generan getter y setter
 * 
 * @author Neta Systems / Jose Alberto Fuentes Loredo
 *
 */
@Component
public class Alberto implements Programmer{

	/**
	 * Se declara la variable privada lenguaje
	 */
	@Autowired
	@Qualifier(value="perlLanguaje")
    private Languaje languaje;

    /**
	 *Obtiene el valor
	 * @return the languaje
	 */
	public Languaje getLanguaje() {
		return languaje;
	}

	/**
	 *Asigna el valor 
	 * @param languaje the languaje to set
	 */
	public void setLanguaje(Languaje languaje) {
		this.languaje = languaje;
	}

	public String hackTheWorld() {
        return "Program in: "+languaje.description();
    }

	/* (non-Javadoc)
	 * @see net.netasystems.business.Programmer#hackTheWorld2()
	 */
	public String hackTheWorld2() {
		
		return "version: " + languaje.version();
	}
}