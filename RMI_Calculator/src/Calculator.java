/*
 * Created By Gullian Van Der Walt - 21-09-2020
 * ITJA321 - Take Home Test 3 2020
 * Server object interface
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
    // Calculator arithmetic calculations methods
    int add(int num1,int num2) throws RemoteException;
    int subtract(int num1,int num2) throws RemoteException;
    int multiply(int num1,int num2) throws RemoteException;
    int divide(int num1,int num2) throws RemoteException;

  }


