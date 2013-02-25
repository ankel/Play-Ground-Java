/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package playground;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.openmbean.CompositeData;
import javax.management.openmbean.TabularData;

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
        TabularData td = (TabularData) c1.get("memoryUsageAfterGc");
        for (Object so : td.keySet()) {
            List l = (List) so;
            for (Object o : l) {
                System.out.println(o.toString());
                System.out.println(o.getClass().toString());
            }
            System.out.println("----");
        }
        System.out.println(td.get(new Object[] {"PS Eden Space"}).getClass().toString());
        
        CompositeData cd = (CompositeData) td.get(new Object[] {"PS Eden Space"});
        
        for (String s : cd.getCompositeType().keySet()) {
            System.out.println("---");
            System.out.println(s);
            System.out.println(cd.get(s).getClass());            
        }
        
        cd = (CompositeData) cd.get("value");
        for (String s : cd.getCompositeType().keySet()) {
            System.out.println("---");
            System.out.println(s);
            System.out.println(cd.get(s));            
        }
        
//        ObjectName on = new ObjectName("my.playground:name=Ground");
//        mbs.registerMBean(new CarBean(), on);
//        
//        TabularData tb = (TabularData) mbs.getAttribute(on, "Map");
//        for (Object o : tb.keySet()) {
//            List l = (List) o;
//            for (Object obj : l) {
//                System.out.println("--");
//                System.out.println(obj.toString());
//            }
//        }
//        cd = (CompositeData) tb.get(new Object[] {"Hello"});
//        for(String s : cd.getCompositeType().keySet()) {
//            System.out.println("---");
//            System.out.println(s);
//            System.out.println(cd.get(s).getClass());
//            System.out.println(cd.get(s));
//        }
    }
}
