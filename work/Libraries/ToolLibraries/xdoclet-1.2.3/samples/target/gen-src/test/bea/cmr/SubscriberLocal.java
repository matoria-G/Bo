/*
 * Generated by XDoclet - Do not edit!
 */
package test.bea.cmr;

/**
 * Local interface for Subscriber.
 * @xdoclet-generated at 16-04-05
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version 1.2.3
 */
public interface SubscriberLocal
   extends javax.ejb.EJBLocalObject
{

   public test.bea.cmr.MagazineLocal getUniOne2OneMagazine(  ) ;

   public test.bea.cmr.MagazineLocal getBiOne2OneMagazine(  ) ;

   public java.util.Collection getUniOne2ManyMagazines(  ) ;

   public java.util.Collection getBiOne2ManyMagazines(  ) ;

   public test.bea.cmr.MagazineLocal getUniMany2OneMagazine(  ) ;

   public java.util.Collection getBiMany2ManyMagazines(  ) ;

   public void setBiMany2ManyMagazines( java.util.Collection biMany2ManyMagArray ) ;

   public void setUniOne2OneMagazine( test.bea.cmr.MagazineLocal uniOne2OneMag ) ;

   public void setBiOne2OneMagazine( test.bea.cmr.MagazineLocal biOne2OneMag ) ;

   public void setUniOne2ManyMagazines( java.util.Collection uniOne2ManyMagArray ) ;

   public void setBiOne2ManyMagazines( java.util.Collection biOne2ManyMagArray ) ;

   public void setUniMany2OneMagazine( test.bea.cmr.MagazineLocal uniMany2OneMag ) ;

   public java.lang.String getBoid(  ) ;

}