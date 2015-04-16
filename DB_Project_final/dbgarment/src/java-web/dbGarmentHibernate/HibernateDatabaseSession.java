package dbGarmentHibernate;

import com.finalist.util.log.*;
import dbGarmentHibernate.exception.GenericBusinessException;
import dbGarmentHibernate.servicelocator.*;

/**
 * The <code>DatabaseSessionImpl </code> is used to allow closing of a database session by the client.
 * This way it is possible too keep database sessions open for lazy loading support.

 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.1 $, $Date: 2005/10/13 21:17:51 $
 *
 *
 */
public class HibernateDatabaseSession implements DatabaseSessionService, LocatableService  {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(HibernateDatabaseSession.class);

   /**
    * Default implementation for the Locatable Service interface.
    */
    public void init() {
    }

   /**
    * Default implementation for the Locatable Service interface.
    */
    public void destroy() {
    }

   /**
    * Close a database session if it is still open.
    *
    */
   public void close() throws GenericBusinessException {
       try {
       dbGarmentHibernate.HibernateSessionHelper.close();
       } catch (Exception e) {
           log.error("Error whil closing the database connection");
           throw new GenericBusinessException(e);
       }
   }
}
