package test.jsf;

import javax.faces.context.*;
import javax.faces.component.*;

/**
 * User: maplat
 * Date: 05.07.2004
 * Time: 15:26:16
 *
 * @jsf.converter name="jsfConverter" description="a dummy converter for testing"
 */
public class JsfConverter implements javax.faces.convert.Converter {

	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
