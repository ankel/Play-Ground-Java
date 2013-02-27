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
        int i = 0;
        System.out.println(++i);
        i = 0;
        System.out.println(i++);
    }
}
