package net.netasystems.business;

import org.springframework.stereotype.Component;

/**
 * Esta es la clase de lenguaje perl  para obtener la
 * descripcion del lenguaje y la version y se generan getter y setter
 * 
 * @author Neta Systems / Jose Alberto Fuentes Loredo
 *
 */
@Component
public class PerlLanguaje implements Languaje {

    /**
     * Se declara una variable para la descripcion del lenguaje y la version
     * 
     */
    private String descriptionLanguage = "Valor desde anotacion";
    private String version = "1.8.0";

    /**
	 *Obtiene el valor
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 *Asigna el valor 
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 *Obtiene el valor
	 * @return the descriptionLanguage
	 */
	public String getDescriptionLanguage() {
		return descriptionLanguage;
	}

	/**
	 *Asigna el valor 
	 * @param descriptionLanguage the descriptionLanguage to set
	 */
	public void setDescriptionLanguage(String descriptionLanguage) {
		this.descriptionLanguage = descriptionLanguage;
	}

	public String description() {
        return descriptionLanguage;
    }


	public String version() {
		return version;
	}
}
