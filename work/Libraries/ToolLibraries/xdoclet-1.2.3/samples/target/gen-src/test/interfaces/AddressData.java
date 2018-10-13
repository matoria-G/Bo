/*
 * Generated by XDoclet - Do not edit!
 */
package test.interfaces;

/**
 * Data object for Address.
 * @xdoclet-generated at 16-04-05
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version 1.2.3
 */
public class AddressData
   extends java.lang.Object
   implements java.io.Serializable
{
   private java.lang.String id;
   private java.lang.String street;
   private java.lang.String city;
   private int readOnly;
   private java.util.Date creationDate;

  /* begin value object */
   private test.interfaces.AddressValue AddressValue = null;

   public test.interfaces.AddressValue getAddressValue()
   {
	  if( AddressValue == null )
	  {
          AddressValue = new test.interfaces.AddressValue();
	  }
      try
         {
            AddressValue.setId( getId() );
                   }
         catch (Exception e)
         {
            throw new javax.ejb.EJBException(e);
         }

	  return AddressValue;
   }

   public void setAddressValue( test.interfaces.AddressValue valueHolder )
   {

	  try
	  {
	  }
	  catch (Exception e)
	  {
		 throw new javax.ejb.EJBException(e);
	  }
   }

  /* end value object */

   public AddressData()
   {
   }

   public AddressData( java.lang.String id,java.lang.String street,java.lang.String city,int readOnly,java.util.Date creationDate )
   {
      setId(id);
      this.street = street;
      this.city = city;
      this.readOnly = readOnly;
      setCreationDate(creationDate);
   }

   public AddressData( AddressData otherData )
   {
      setId(otherData.getId());
      this.street = otherData.street;
      this.city = otherData.city;
      this.readOnly = otherData.readOnly;
      setCreationDate(otherData.getCreationDate());

   }

   public java.lang.String getPrimaryKey() {
     return  getId();
   }

   public java.lang.String getId()
   {
      return this.id;
   }
   public void setId( java.lang.String id )
   {
      this.id = id;
   }

   public java.lang.String getStreet()
   {
      return this.street;
   }
   public void setStreet( java.lang.String street )
   {
      this.street = street;
   }

   public java.lang.String getCity()
   {
      return this.city;
   }
   public void setCity( java.lang.String city )
   {
      this.city = city;
   }

   public int getReadOnly()
   {
      return this.readOnly;
   }
   public void setReadOnly( int readOnly )
   {
      this.readOnly = readOnly;
   }

   public java.util.Date getCreationDate()
   {
      return this.creationDate;
   }
   public void setCreationDate( java.util.Date creationDate )
   {
      this.creationDate = creationDate;
   }

   public String toString()
   {
      StringBuffer str = new StringBuffer("{");

      str.append("id=" + getId() + " " + "street=" + getStreet() + " " + "city=" + getCity() + " " + "readOnly=" + getReadOnly() + " " + "creationDate=" + getCreationDate());
      str.append('}');

      return(str.toString());
   }

   public boolean equals( Object pOther )
   {
      if( pOther instanceof AddressData )
      {
         AddressData lTest = (AddressData) pOther;
         boolean lEquals = true;

         if( this.id == null )
         {
            lEquals = lEquals && ( lTest.id == null );
         }
         else
         {
            lEquals = lEquals && this.id.equals( lTest.id );
         }
         if( this.street == null )
         {
            lEquals = lEquals && ( lTest.street == null );
         }
         else
         {
            lEquals = lEquals && this.street.equals( lTest.street );
         }
         if( this.city == null )
         {
            lEquals = lEquals && ( lTest.city == null );
         }
         else
         {
            lEquals = lEquals && this.city.equals( lTest.city );
         }
         lEquals = lEquals && this.readOnly == lTest.readOnly;
         if( this.creationDate == null )
         {
            lEquals = lEquals && ( lTest.creationDate == null );
         }
         else
         {
            lEquals = lEquals && this.creationDate.equals( lTest.creationDate );
         }

         return lEquals;
      }
      else
      {
         return false;
      }
   }

   public int hashCode()
   {
      int result = 17;

      result = 37*result + ((this.id != null) ? this.id.hashCode() : 0);

      result = 37*result + ((this.street != null) ? this.street.hashCode() : 0);

      result = 37*result + ((this.city != null) ? this.city.hashCode() : 0);

      result = 37*result + (int) readOnly;

      result = 37*result + ((this.creationDate != null) ? this.creationDate.hashCode() : 0);

      return result;
   }

}