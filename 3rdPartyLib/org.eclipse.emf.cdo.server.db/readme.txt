custom plugin to patch Exception. 

org.eclipse.net4j.db.DBException: org.postgresql.util.PSQLException: ERROR: current transaction is aborted, 
commands ignored until end of transaction block

/org.eclipse.emf.cdo.server.db/src/org/eclipse/emf/cdo/server/internal/db/mapping/horizontal/ObjectTypeTable.java

 public CDOID getMaxID(Connection connection, IIDHandler idHandler)
  {
    Statement stmt = null;
    ResultSet resultSet = null;

    try
    {
      stmt = connection.createStatement();
      connection.setAutoCommit(true);
      resultSet = stmt.executeQuery("SELECT MAX(" + idField + ") FROM " + table);
      connection.setAutoCommit(false);
      if (resultSet.next())
      {
        return idHandler.getCDOID(resultSet, 1);
      }

      return null;
    }
    catch (SQLException ex)
    {
      throw new DBException(ex);
    }
    finally
    {
      DBUtil.close(resultSet);
      DBUtil.close(stmt);
    }
  }