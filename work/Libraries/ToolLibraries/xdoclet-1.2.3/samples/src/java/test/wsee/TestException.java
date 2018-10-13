/*
 * Created on 24.02.2004
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package test.wsee;

/**
 * @author Jung
 * @wsee.jaxrpc-mapping local-part="TestException"
 */

public class TestException extends Exception {

   /**
    * @wsee.constructor-element name="message"
    * @wsee.constructor-element name="reason"
    * @param message
    * @param reason
    */
   public TestException(String message, String reason) {
      super(message);
   }
}
