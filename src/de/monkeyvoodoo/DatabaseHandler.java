package de.monkeyvoodoo;
import java.io.File;

import org.tmatesoft.sqljet.core.SqlJetException;
import org.tmatesoft.sqljet.core.SqlJetTransactionMode;
import org.tmatesoft.sqljet.core.table.SqlJetDb;

public class DatabaseHandler
{
    private String DBName = "data.sqlite";
    private File dbFile = new File(this.DBName);
    private SqlJetDb db;

    /**
     * @param args
     */
    public void main(String[] args)
    {
        if (!doesDBExists())
        {
            // no database found
        }
    }

    public boolean doesDBExists()
    {
        return this.dbFile.isFile();
    }

    public boolean openDB()
    {   
        try
        {
            this.db = SqlJetDb.open(this.dbFile, true);
            this.db.getOptions().setAutovacuum(true);
            this.db.beginTransaction(SqlJetTransactionMode.WRITE);

            this.db.getOptions().setUserVersion(1);
        } catch (Exception e)
        {
            closeDB();
            e.printStackTrace();
            System.exit(1000);
        }
        return false;
    }

    public void closeDB()
    {
        try
        {
            this.db.close();
        } catch (SqlJetException e)
        {
            e.printStackTrace();
            System.exit(1001);
        }
    }
}
