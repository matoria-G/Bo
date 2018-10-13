package test.jsf;

import javax.faces.context.*;
import javax.faces.component.*;
import javax.faces.validator.*;

/**
 * @author <a href="mailto:markus.plattner at plattners.de">Markus Plattner</a>
 * Date: 05.07.2004
 * Time: 13:29:23
 *
 * @jsf.validator name="jsfValidator"
 */
public class JsfValidator implements javax.faces.validator.Validator {

   public void JsfValidator() {
	}

	public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
	}

	/**
	 * @jsf.validator-attribute
	 * @return
	 */
	public String getValidatorAttribute() {
		return null;
	}
}
