/*
 * Created on 23.02.2004
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package test.wsee;

/**
 * @author Jung
 * @web.servlet name="TestService"
 * @wsee.port-component 
 *    name="Test" 
 *    local-part="Test"  
 *    display-name="Test"
 *    small-icon="test-small.gif"
 *    large-icon="test-large.gif"
 *    description="Java Bean exposed as a webservice"
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

public class TestBean implements test.wsee.TestService {

   /**
    * @web.interface-method
    */
   public void testMethod() {
   }

}
