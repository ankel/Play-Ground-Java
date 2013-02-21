/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package playground;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.openmbean.CompositeData;

/**
 *
 * @author Binh Tran <mynameisbinh@gmail.com>
 */
public class PlayGround {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        ArrayList arr = new ArrayList();
        for (int i = 0; i < 10000000; ++i) {
            arr.add(i);
        }
        arr.clear();
        for (int i = 0; i < 10000000; ++i) {
            arr.add(10000000 - i);
        }
        arr.clear();
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
//        for (ObjectInstance bean : mbs.queryMBeans(null, null)) {
//            System.out.println(bean.getObjectName().getCanonicalName());
//        }
        ObjectName mS = new ObjectName("java.lang:name=PS MarkSweep,type=GarbageCollector");
//        for (MBeanAttributeInfo ai : mbs.getMBeanInfo(mS).getAttributes()) {
//            System.out.println(ai.getName());
//        }
        
        CompositeData c1 = (CompositeData) mbs.getAttribute(mS, "LastGcInfo");
//        for (String s : c1.getCompositeType().keySet()) {
//            System.out.println(s);
//        }
        System.out.println(c1.get("memoryUsageAfterGc").getClass());
    }
}
