/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import dao.IDao;
import entities.Machine;
import entities.Salle;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.MachineService;
import services.SalleService;

/**
 *
 * @author SIMO LAAOUIBI
 */
public class Server {
    public static void main(String[] args) {
        try {
            IDao<Machine> dao = new MachineService();
            LocateRegistry.createRegistry(1099);
            Naming.bind("rmi://localhost:1099/dao", dao);
            
            IDao<Salle> dao2 = new SalleService();
            Naming.bind("rmi://localhost:1099/dao2", dao2);
            
            System.out.println("en attente des clients");
        } catch (RemoteException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

