package dbGarmentHibernate;

import dbGarmentHibernate.exception.GenericBusinessException;

/**
 * The <code>DatabaseSessionService </code> service interface allows closing of a database session by the client.
 * This way it is possible too keep database sessions open for lazy loading support.
 *
 * @author  DB team  Finalist IT Group
 * @version $Revision: 1.1 $, $Date: 2005/10/13 21:17:51 $
 *
 *
 */
public interface DatabaseSessionService  {
   /**
    * Close a database session if it is still open.
    *
    */
   void close() throws GenericBusinessException;
}
