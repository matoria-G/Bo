/*
 * Generated by XDoclet - Do not edit!
 */
package test.interfaces;

/**
 * Data object for File.
 * @xdoclet-generated at 16-04-05
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version 1.2.3
 */
public class FileData
   extends java.lang.Object
   implements java.io.Serializable
{
   private java.lang.String id;
   private byte[] content;
   private java.lang.String contentType;
   private java.util.Date creationDate;

  /* begin value object */

  /* end value object */

   public FileData()
   {
   }

   public FileData( java.lang.String id,byte[] content,java.lang.String contentType,java.util.Date creationDate )
   {
      setId(id);
      setContent(content);
      setContentType(contentType);
      setCreationDate(creationDate);
   }

   public FileData( FileData otherData )
   {
      setId(otherData.getId());
      setContent(otherData.getContent());
      setContentType(otherData.getContentType());
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

   public byte[] getContent()
   {
      return this.content;
   }
   public void setContent( byte[] content )
   {
      this.content = content;
   }

   public java.lang.String getContentType()
   {
      return this.contentType;
   }
   public void setContentType( java.lang.String contentType )
   {
      this.contentType = contentType;
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

      str.append("id=" + getId() + " " + "content=" + getContent() + " " + "contentType=" + getContentType() + " " + "creationDate=" + getCreationDate());
      str.append('}');

      return(str.toString());
   }

   public boolean equals( Object pOther )
   {
      if( pOther instanceof FileData )
      {
         FileData lTest = (FileData) pOther;
         boolean lEquals = true;

         if( this.id == null )
         {
            lEquals = lEquals && ( lTest.id == null );
         }
         else
         {
            lEquals = lEquals && this.id.equals( lTest.id );
         }
         lEquals = lEquals && this.content == lTest.content;
         if( this.contentType == null )
         {
            lEquals = lEquals && ( lTest.contentType == null );
         }
         else
         {
            lEquals = lEquals && this.contentType.equals( lTest.contentType );
         }
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

      if (content != null) {
        for (int i=0; i<content.length; i++)
        {
          long l = content[i];
          result = 37*result + (int)(l^(l>>>32));
        }
      }

      result = 37*result + ((this.contentType != null) ? this.contentType.hashCode() : 0);

      result = 37*result + ((this.creationDate != null) ? this.creationDate.hashCode() : 0);

      return result;
   }

}
