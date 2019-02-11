# Exterminatus service deployable module

Configuration of exterminatus-service to be deployed onto application server.

Tested with Glassfish 4.0.

Depends on application server provided resource - JDBC resource with JNDI name `jdbc/exterminate`.

Consists of DAOFactory for creating CDI DAO bean and Root class for JSX-RS resource registration.
