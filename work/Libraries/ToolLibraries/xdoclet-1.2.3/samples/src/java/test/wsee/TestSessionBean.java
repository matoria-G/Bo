/*
 * Created on 23.02.2004
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package test.wsee;

import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.EJBHome;
import javax.ejb.EJBObject;
import javax.ejb.Handle;
import javax.ejb.RemoveException;
import javax.ejb.SessionContext;

/**
 * @author Jung
 * @ejb.bean name="TestSession" view-type="service-endpoint"
 * @wsee.port-component 
 *    name="TestSession" 
 *    local-part="TestSession"  
 *    display-name="TestSession"
 *    small-icon="testsession-small.gif"
 *    large-icon="testsession-large.gif"
 *    description="Session Bean exposed as a webservice"
 * @wsee.handler 
 *    name="TestHandler" 
 *    handler-class="test.wsee.TestHandler" 
 *    soap-header-namespace-uri="http://xdoclet.sourcefore.net/wsee/test-handler" 
 *    soap-header-local-part="TestHeader" 
 *    soap-role="TestRole" 
 *    display-name="TestHandler" 
 *    small-icon="testhandler-small.ico" 
 *    large-icon="testhandler-large.ico"
 */

public class TestSessionBean implements javax.ejb.SessionBean {

   /**
    * @ejb.interface-method
    */
   public void testMethod() {
   }

   /* (non-Javadoc)
    * @see javax.ejb.SessionBean#ejbActivate()
    */
   public void ejbActivate() throws EJBException, RemoteException {
      // TODO Auto-generated method stub
      
   }

   /* (non-Javadoc)
    * @see javax.ejb.SessionBean#ejbPassivate()
    */
   public void ejbPassivate() throws EJBException, RemoteException {
      // TODO Auto-generated method stub
      
   }

   /* (non-Javadoc)
    * @see javax.ejb.SessionBean#ejbRemove()
    */
   public void ejbRemove() throws EJBException, RemoteException {
      // TODO Auto-generated method stub
      
   }

   /* (non-Javadoc)
    * @see javax.ejb.SessionBean#setSessionContext(javax.ejb.SessionContext)
    */
   public void setSessionContext(SessionContext arg0) throws EJBException, RemoteException {
      // TODO Auto-generated method stub
      
   }

}
