package test.bea.cmr;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.RemoveException;

import test.bea.cmr.SubscriberLocal;

/**
 * @ejb.bean display-name="Magazine" name="Magazine" schema="MagazineSchema"
 *   		 view-type="local" type="CMP" cmp-version="2.x" primkey-field="boid"
 *           local-jndi-name="de.razeman.xdoclet.test.weblogic.ejb.relation.local.MagazineLocalHome"
 * @ejb.finder signature="java.util.Collection findAll()" query="SELECT OBJECT(o) FROM MagazineSchema AS o"
 * @ejb.transaction type = "Supports"
 * @ejb.pk class="java.lang.String"
 * 
 * @ejb.persistence table-name="Magazine"
 *
 * @weblogic.table-name Magazine
 * @weblogic.data-source-name OracleDS
 */
public abstract class MagazineBean implements EntityBean
{
    private EntityContext context;
    
    public MagazineBean()
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
     *
     * @ejb.relation name="biOne2One-Magazine-Subscriber" role-name="Magazine"
     */
    public abstract SubscriberLocal getBiOne2OneSubscriber();

    /**
     * @ejb.interface-method
     * 
     * @ejb.transaction type = "Required"
     *
     * @ejb.relation name="biMany2One-Magazine-for-many-Subscribers" role-name="MagazineRole"
     *
     * @weblogic.column-map key-column="boid" foreign-key-column="biOne2ManySubscriberBoid"
     */
    public abstract SubscriberLocal getBiOne2ManySubscriber();

    /**
     * @ejb.interface-method
     *
     * @ejb.transaction type = "Required"
     *
     * @ejb.relation name="biMany2Many-Many-Subscribers-for-many-Magazines" 
     *               role-name="MagazineRole"
     *
     * @weblogic.relation join-table-name="BiMany2ManySubscriberMagazine"
     *
     * @weblogic.column-map key-column="boid" foreign-key-column="MagazineBoid"
     */
    public abstract java.util.Collection getBiMany2ManySubscribers();

    /**
     * @ejb.interface-method
     */
    public abstract void setBiMany2ManySubscribers(java.util.Collection biMany2ManySubArray);

    /**
     * @ejb.transaction type = "Required"
     *
     * @ejb.interface-method
     */
    public abstract void setBiOne2OneSubscriber(SubscriberLocal biOne2OneSub);

    /**
     * @ejb.interface-method 
     * @ejb.persistent-field 
     * 
     * @weblogic.dbms-column title
     */
    public abstract java.lang.String getTitle();

    /**
     * @ejb.transaction type = "Required"
     *
     * @ejb.interface-method
     */
    public abstract void setTitle(java.lang.String title);

    /**
     * @ejb.transaction type = "Required"
     *
     * @ejb.interface-method
     */
    public abstract void setBiOne2ManySubscriber(SubscriberLocal biOne2ManySub);

    /**
     * @ejb.pk-field
     * @ejb.persistent-field
     * @ejb.interface-method
     * @weblogic.dbms-column boid
     */
    public abstract String getBoid();

    /**
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