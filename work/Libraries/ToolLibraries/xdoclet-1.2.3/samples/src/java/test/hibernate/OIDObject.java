package test.hibernate;

/**
* @hibernate.class
*/

public class OIDObject 
{
protected Long OID;

public void setOID(Long oid)
{
OID = oid;
}

/**
* @hibernate.id
* column="oid"
* generator-class="sequence"
*
* @hibernate.generator-param
* name="sequence"
* value="SequenceName"
* @return
*/
public Long getOID()
{
return OID;
}
} 

