package test.bea.cmr;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.RemoveException;

import test.bea.cmr.MagazineLocal;

/**
 * @ejb.bean display-name="Subscriber" name="Subscriber" schema="SubscriberSchema"
 *   		 view-type="local" type="CMP" cmp-version="2.x" primkey-field="boid"
 *           local-jndi-name="de.razeman.xdoclet.test.weblogic.ejb.relation.local.SubscriberLocalHome"
 * @ejb.finder signature="java.util.Collection findAll()" query="SELECT OBJECT(o) FROM SubscriberSchema AS o"
 * @ejb.transaction type = "Supports"
 * @ejb.pk class="java.lang.String"
 * 
 * @ejb.persistence table-name="Subscriber"
 *
 * @weblogic.table-name Subscriber
 * @weblogic.data-source-name OracleDS
 */
public abstract class SubscriberBean implements EntityBean
{
    private EntityContext context;
    
    public SubscriberBean()
    {
    }
	
    /**
     * @ejb.create-method
     * 
     * Creates a new Entity Bean.
     * @param boid The unique identifier.
     * @throws CreateException If <code>id</code> is <code>null</code>.
     */
    public String ejbCreate(String boid) throws CreateException
    {
        if (boid == null) { 
            throw (new CreateException("ID must not be null!"));
        }

        setBoid(boid);

        return null;
    }

    /**
     * Called immediately after creation.
     * @param boid The unique identifier.
     */
    public void ejbPostCreate(String boid) {
    }

    /**
     * @ejb.interface-method 
     * @ejb.relation name="uniOne2One-Subscriber-has-a-Magazine" role-name="SubscriberRole"
     *               target-ejb="Magazine" target-role-name="MagazineRole"
     * @weblogic.target-column-map key-column="boid" foreign-key-column="uniOne2OneSubscriberBoid"
     */
    public abstract MagazineLocal getUniOne2OneMagazine();

    /**
     * @ejb.interface-method 
     * @ejb.relation name="biOne2One-Magazine-Subscriber" role-name="Subscriber"
     * 
     * @weblogic.column-map key-column="boid" foreign-key-column="biOne2OneMagazineBoid"
     */
    public abstract MagazineLocal getBiOne2OneMagazine();

    /**
     * @ejb.interface-method
     *
     * @ejb.transaction type = "Required"
     *
     * @ejb.relation name="uniOne2Many-Subscriber-has-many-Magazines" role-name="SubscriberRole"
     * 				 target-ejb="Magazine" target-role-name="MagazineRole"
     *
     * @weblogic.target-column-map key-column="boid" foreign-key-column="uniOne2ManySubscriberBoid"
     */
    public abstract java.util.Collection getUniOne2ManyMagazines();

    /**
     * @ejb.interface-method
     *
     * @ejb.transaction type = "Required"
     *
     * @ejb.relation name="biMany2One-Magazine-for-many-Subscribers" 
     * 				 role-name="SubscriberRole"
     */
    public abstract java.util.Collection getBiOne2ManyMagazines();

    /**
     * @ejb.interface-method
     *
     * @ejb.relation name="uniMany2One-Magazine-for-many-Subscribers" 
     * 				 role-name="SubscriberRole" target-multiple = "yes"
     * 				 target-ejb="Magazine" target-role-name="MagazineRole"
     *
     * @weblogic.column-map key-column="boid" foreign-key-column="uniMany2OneMagazineBoid"
     */
    public abstract MagazineLocal getUniMany2OneMagazine();

    /**
     * @ejb.interface-method
     *
     * @ejb.transaction type = "Required"
     *
     * @ejb.relation name="biMany2Many-Many-Subscribers-for-many-Magazines" 
     *               role-name="SubscriberRole"
     *
     * @weblogic.relation join-table-name="BiMany2ManySubscriberMagazine"
     *
     * @weblogic.column-map key-column="boid" foreign-key-column="SubscriberBoid"
     */
    public abstract java.util.Collection getBiMany2ManyMagazines();

    /**
     * @ejb.interface-method
     */
    public abstract void setBiMany2ManyMagazines(java.util.Collection biMany2ManyMagArray);

    /**
     * @ejb.interface-method
     */
    public abstract void setUniOne2OneMagazine(MagazineLocal uniOne2OneMag);
	
    /**
     * @ejb.interface-method
     */
    public abstract void setBiOne2OneMagazine(MagazineLocal biOne2OneMag);

    /**
     * @ejb.interface-method
     */
    public abstract void setUniOne2ManyMagazines(java.util.Collection uniOne2ManyMagArray);

    /**
     * @ejb.interface-method
     */
    public abstract void setBiOne2ManyMagazines(java.util.Collection biOne2ManyMagArray);
    
    /**
     * @ejb.interface-method
     */
    public abstract void setUniMany2OneMagazine(MagazineLocal uniMany2OneMag);

    /**
     * @ejb.pk-field
     * @ejb.persistent-field
     * @ejb.interface-method
     * @weblogic.dbms-column boid
     */
    public abstract String getBoid();

    /**
     * 
     * @param boid
     */
    public abstract void setBoid(String boid);

    /**
     * @return
     */
    public EntityContext getEntityContext() {
        return context;
    }

    /**
     * @see javax.ejb.EntityBean#setEntityContext(javax.ejb.EntityContext)
     */
    public void setEntityContext(EntityContext context) throws EJBException, RemoteException
    {
        this.context = context;
    }
	
    /**
     * @see javax.ejb.EntityBean#unsetEntityContext()
     */
    public void unsetEntityContext() throws EJBException, RemoteException
    {
    }
	
    /**
     * @see javax.ejb.EntityBean#ejbActivate()
     */
    public void ejbActivate() throws EJBException, RemoteException
    {
    }
	
    /**
     * @see javax.ejb.EntityBean#ejbPassivate()
     */
    public void ejbPassivate() throws EJBException, RemoteException
    {
    }
	
    /**
     * @see javax.ejb.EntityBean#ejbRemove()
     */
    public void ejbRemove() throws RemoveException, EJBException, RemoteException
    {
    }

    /**
     * @see javax.ejb.EntityBean#ejbLoad()
     */
    public void ejbLoad() throws EJBException, RemoteException
    {
    }

    /**
     * @see javax.ejb.EntityBean#ejbStore()
     */
    public void ejbStore() throws EJBException, RemoteException
    {
    }
	
    public String toString() {
        return getClass().getName() + " [boid=" + getBoid() + "]";
    }

}