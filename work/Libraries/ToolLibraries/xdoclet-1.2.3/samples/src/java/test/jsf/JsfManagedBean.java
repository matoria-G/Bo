package test.jsf;

/**
 * @author <a href="mailto:markus.plattner at plattners.de">Markus Plattner</a>
 * Date: 28.06.2004
 * Time: 00:30:10
 *
 * @jsf.bean name="jsfBean" scope="session"
 *
 * @jsf.navigation from="from_1" to="to_1" result="result_1"
 * @jsf.navigation from="from_2" to="to_2" result="result_2"
 * @jsf.navigation from="from_1" to="to_1" result="ergebnis_2"
 */
public class JsfManagedBean {

	/**
	 * @jsf.managed-property value-ref="${v.ref}"
	 */
	public void setRef(String r) {

	}
	/**
	 * @jsf.managed-property value="1"
	 */
	public void setSelectedEditor(String tab) {
	}
}
