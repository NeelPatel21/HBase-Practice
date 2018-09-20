package hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;

public class Conf {

    private Conf(){

    };

    private static Configuration conf;

    public static Configuration getConf(){
        initConf();
        return conf;
    }

    synchronized private static void initConf(){
        if(conf!=null)
            return;
        conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "192.168.138.128");
        conf.set("hbase.zookeeper.property.clientPort", "2181");
        //conf.set("hbase.master.port", "16000");
        conf.set("zookeeper.znode.parent", "/hbase-unsecure");

    }
}
