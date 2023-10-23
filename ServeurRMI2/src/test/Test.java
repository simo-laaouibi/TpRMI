/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.IDao;
import entities.Machine;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Hibernate;
import services.MachineService;
import util.HibernateUtil;

/**
 *
 * @author SIMO LAAOUIBI
 */
public class Test {

    public static void main(String[] args) {
       try {
        HibernateUtil.getSessionFactory();
          IDao<Machine> dao = new MachineService();
        dao.create(new Machine("TuF", "asus", 3000));
        dao.create(new Machine("mac", "apple", 2000));
        dao.create(new Machine("Pavilion", "HP", 4000));
        
        for(Machine m: dao.findAll()){
           System.out.println(m);
        }
           } catch (RemoteException ex) {
               Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
