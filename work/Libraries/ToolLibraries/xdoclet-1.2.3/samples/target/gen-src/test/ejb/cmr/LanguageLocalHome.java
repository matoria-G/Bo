/*
 * Generated by XDoclet - Do not edit!
 */
package test.ejb.cmr;

/**
 * Local home interface for Language.
 * @xdoclet-generated at 16-04-05
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version 1.2.3
 */
public interface LanguageLocalHome
   extends javax.ejb.EJBLocalHome
{
   public static final String COMP_NAME="java:comp/env/ejb/LanguageLocal";
   public static final String JNDI_NAME="airline.LanguageLocalHome";

   public test.ejb.cmr.LanguageLocal create(java.lang.Integer languageId , java.lang.String name , test.ejb.cmr.LanguageCodeLocal languageCode)
      throws javax.ejb.CreateException;

   public java.util.Collection findAll()
      throws javax.ejb.FinderException;

   public java.util.Collection findByLanguageCode(test.ejb.cmr.LanguageCodeLocal languageCode)
      throws javax.ejb.FinderException;

   public java.util.Collection findByName(java.lang.String name)
      throws javax.ejb.FinderException;

   public test.ejb.cmr.LanguageLocal findByPrimaryKey(java.lang.Integer pk)
      throws javax.ejb.FinderException;

}
