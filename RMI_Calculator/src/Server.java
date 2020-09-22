/*
 * Created By Gullian Van Der Walt - 21-09-2020
 * ITJA321 - Take Home Test 3 2020
 * Server Class
 */

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject
  implements Calculator{

  public static void main(String[] args){
    try{

      // Server Object
      Server obj = new Server();
      // Create Registry Object

      Registry registry = LocateRegistry.getRegistry(4444);
      // Bind Server obj to registry
//      registry.bind("serverImpl", obj);
      Naming.bind("serverCalc",obj);

      System.out.println("Server is ready");

    }catch (Exception ex){
      System.err.println("Server Exception: " + ex.toString());
      ex.printStackTrace();
    }

  }
  // Variables
  int num1;
  int num2;

  // Constructor
  public Server() throws RemoteException {
    add(num1, num2);
    subtract(num1, num2);
    multiply(num1, num2);
    divide(num1, num2);

  }

  // Getter and Setter Methods

  public int getNum1() {
    return num1;
  }

  public void setNum1(int num1) {
    this.num1 = num1;
  }

  public int getNum2() {
    return num2;
  }

  public void setNum2(int num2) {
    this.num2 = num2;
  }

  // Calculator arithmetic calculations methods

  public int add(int num1, int num2)throws RemoteException{
    return num1+num2;
  }
  public int subtract(int num1, int num2)throws RemoteException{
    return num1-num2;
  }
  public int multiply(int num1, int num2)throws RemoteException{
    return num1*num2;
  }
  public int divide(int num1, int num2)throws RemoteException{
    if(num1 > 0 || num2 > 0){
      return num1/num2;

    }
    return 0;
  }
}
