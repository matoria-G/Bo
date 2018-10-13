/*
 * Created on 23.02.2004
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package test.wsee;

/**
 * @wsee.jaxrpc-mapping root-type-qname="TestObject" 
 */
public class TestObject {

   /**
    * @wsee.variable-mapping name="TestField"
    */
   public boolean testField;
   
   /**
    * @wsee.variable-mapping name="TestProperty"
    * @return
    */
   public String getTestProperty() {
      return null;
   }
   
   /**
    * @wsee.variable-mapping name=TestProperty"
    */
   public void setTestProperty(String property) {
   }
   
}
