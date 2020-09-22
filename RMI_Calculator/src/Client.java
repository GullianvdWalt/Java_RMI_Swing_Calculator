/*
 * Created By Gullian Van Der Walt - 21-09-2020
 * ITJA321 - Take Home Test 3 2020
 * Client Class
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client extends JFrame implements ActionListener {

  Server server = new Server();


  // Variables
  int num1 = 0;
  int num2 = 0;
  int result = 0;

  // GUI Components
  JFrame frame;
  JButton button;
  JLabel label1;
  JLabel label2;
  JLabel label3;
  JLabel label4;
  JLabel label5;
  JLabel label6;
  JTextField txtField1;
  JTextField txtField2;
  JComboBox<String> jComboBox;

  String action = "";

  public Client() throws HeadlessException, RemoteException {

    frame = new JFrame();



    // Create GUI Components
    button = new JButton("Calculate");
    label1 = new JLabel("Edureka Calculator App v1.0");
    label2 = new JLabel("Developer: G. Van Der Walt");
    label3 = new JLabel("Input 1st Number: ");
    label4 = new JLabel("Choose Symbol: ");
    label5 = new JLabel("Input 1st Number: ");
    label6 = new JLabel();
    txtField1 = new JTextField();
    txtField2 = new JTextField();
    String[] operations = {"+","-","*","/"};
    jComboBox = new JComboBox<>(operations);

    button.addActionListener(this);



    // Add components to frame
    add(label1);
    add(label2);
    add(label3);
    add(txtField1);
    add(label4);
    add(jComboBox);
    add(label5);
    add(txtField2);
    add(button);
    add(label6);



    // Gui properties
    GridLayout gridLayout = new GridLayout(0,2);
    this.setLayout(gridLayout);
    this.pack();
    this.setLocationRelativeTo(null);
    this.setVisible(true);
    this.setSize(500,250);
    this.setTitle("Edureka Calculator App");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    action = (String)jComboBox.getSelectedItem();

        if(e.getSource() == button) {
          System.out.println("buttons ready");
          // Get Values
          num1 = Integer.parseInt(txtField1.getText());
          num2 = Integer.parseInt(txtField2.getText());
          try {
              String url = "rmi://localhost/serverCalc";
              Calculator calc = (Calculator) Naming.lookup(url);
//            Registry registry = LocateRegistry.getRegistry("localhost",4444);
//            Calculator calculate = (Calculator) registry.lookup("serverImpl");

            if(txtField1.getText().isEmpty() || txtField2.getText().isEmpty()){

              JOptionPane.showMessageDialog(frame, "Please Enter 1st Number","Inane error",
                JOptionPane.ERROR_MESSAGE);

            }else {
              System.out.println("ready 1");

              System.out.println("ready 2");
              switch (action) {

                case "+":
                  result = server.add(num1, num2);
                  label6.setText(String.valueOf(result));
                  break;

                case "-":
                  result = server.subtract(num1, num2);
                  label6.setText(String.valueOf(result));
                  break;

                case "/":
                  result = server.divide(num1, num2);
                  label6.setText(String.valueOf(result));
                  break;

                case "*":
                  result = server.multiply(num1, num2);
                  label6.setText(String.valueOf(result));
                  break;

                default:

              }
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

  }
  public static void main(String[] args) throws RemoteException {

    Client client = new Client();

  }

}
