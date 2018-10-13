package test.hibernate;

/**
*
* @hibernate.class table="error"
*
*/
public class Error extends OIDObject
{
protected String message;

protected String description;

protected String errorMode;

protected String type;

/**
* @hibernate.property
* column="error_message"
* not-null="true"
*
*/
public String getMessage()
{
return message;
}

public void setMessage(String m)
{
message = m;
}

/**
* @hibernate.property
* column="description"
*
*/
public String getDescription()
{
return description;
}

public void setDescription(String desc)
{
description = desc;
}

/**
* @hibernate.property
* column="errormode"
* not-null="true"
*
*/
public String getErrorMode()
{
return errorMode;
}

public void setErrorMode(String errorMode)
{
this.errorMode = errorMode;
}

/**
* @hibernate.property
* column="error_type"
* not-null="true"
*
*/

public String getType()
{
return type;
}

public void setType(String newType)
{
type = newType;
}
}

