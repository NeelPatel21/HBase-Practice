package hbase;

import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.ColumnFamilyDescriptor;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

public class CreateTable {
    public static void main(String ... args) throws IOException {
        try(Connection con = ConnectionFactory.createConnection(Conf.getConf())){
            Admin admin = con.getAdmin();
            HTableDescriptor htd = new HTableDescriptor(TableName.valueOf("users"));
            htd.addFamily(new HColumnDescriptor("personal"));
            if(admin.tableExists(TableName.valueOf("users")))
                return;
            admin.createTable(htd);
        }
    }
}
