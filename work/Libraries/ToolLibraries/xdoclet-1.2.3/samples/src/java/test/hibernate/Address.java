package test.hibernate;

import java.util.Date;


/**
 * This class is used to test generating Struts Forms
 * using &lt;actionform&gt; as well as one-to-one validation
 * mappings
 *
 * @author Matt Raible
 *
 * @struts.form name="cityForm"
 *  extends="org.apache.struts.validator.ValidatorForm"
 * @struts.form name="stateForm"
 */
public class Address {
    private String city;
    private String state;
    private Boolean usCitizen;
    private Date startDate;

    /**
    * @struts.form-field form-name="cityForm"
     * Returns the city.
     * @return String
     */
    public String getCity() {
        return city;
    }

    /**
     * @return String
    * @struts.form-field form-name="stateForm"
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the city.
     * @param city The city to set
     */
    public void setCity(String first) {
        this.city = first;
    }

    /**
     * Sets the state.
     * @param state The state to set
     */
    public void setState(String last) {
        this.state = last;
    }

    /**
     * @struts.form-field
     * @struts.validator type="required"
     */
    public Boolean getUsCitizen() {
        return usCitizen;
    }

    /**
     * @spring.validator type="required"
     * @return
     */
    public void setUsCitizen(Boolean citizen) {
        this.usCitizen = citizen;
    }
    
    /**
     * @return Returns the startDate.
     */
    public Date getStartDate() {
        return startDate;
    }
    
    /**
     * @param startDate The startDate to set.
     * @spring.validator type="required"
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
