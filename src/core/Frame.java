/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author kayde
 */
public class Frame extends JFrame{
        private ShowRoom garage = new ShowRoom();
        private JTextField VINText, manufactuerText, modelText, manuDateText, costText, taxBandText, co2Text, soldText, soldDateText, customerText;
        
        public Frame(String title){
            super(title);
            //set up the showroom to display
            ShowRoomDriver.Test(garage);
            garage.showInterest("1");
            
            
            this.add(infoPanel(), BorderLayout.NORTH);
            this.add(buttonPanel(), BorderLayout.CENTER);

            //Boring stuff
            pack(); //makes sure panels get their prefered size
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setSize(300, 290);
            this.setVisible(true);
        }
        
        public JPanel buttonPanel(){
            JPanel buttonPanel = new JPanel();
            
            JButton nextCar = new JButton("Next");
            JButton previousCar = new JButton("Previous");
            JButton sell = new JButton("Sell");
            
            
            nextCar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(garage.nextInterest()){
                        updateInformation();
                    }else{
                        JOptionPane.showMessageDialog(Frame.this, "No more cars to display", "Error", JOptionPane.ERROR_MESSAGE);  
                    }
                }
            }); 
            
            previousCar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(garage.previousInterest()){
                        updateInformation();  
                    }else{
                        JOptionPane.showMessageDialog(Frame.this, "No more cars to display", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }); 
            
            sell.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(garage.getInterest().isSold() == true){
                        JOptionPane.showMessageDialog(Frame.this, "Vehicle is already sold", "Error", JOptionPane.ERROR_MESSAGE);
                    }else{
                        String customerName = JOptionPane.showInputDialog(Frame.this, "Input Customer Name:");
                        garage.purchaseCar(garage.getInterest().getVIN(), new Customer(customerName));
                        updateInformation();  
                    }
                }
            }); 
            buttonPanel.add(previousCar);
            buttonPanel.add(nextCar);
            buttonPanel.add(sell);
            
            
            return buttonPanel;
        }
        
        private JPanel infoPanel(){
            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new GridLayout(0, 2));
            
            JLabel VIN = new JLabel("VIN: ");
            VINText = new JTextField(garage.getInterest().getVIN());
            VINText.setEditable(false); //these can be changed and then worked into a set method in the future
            infoPanel.add(VIN);
            infoPanel.add(VINText);
            
            JLabel manufacturer = new JLabel("Manufacturer: ");
            manufactuerText = new JTextField(garage.getInterest().getManu());
            manufactuerText.setEditable(false);
            infoPanel.add(manufacturer);
            infoPanel.add(manufactuerText);
            
            JLabel model = new JLabel("Model: ");
            modelText = new JTextField(garage.getInterest().getModel());
            modelText.setEditable(false);
            infoPanel.add(model);
            infoPanel.add(modelText);
            
            JLabel manuDate = new JLabel("Manufactuer Date: ");
            manuDateText = new JTextField(garage.getInterest().getManuDateAsString());
            manuDateText.setEditable(false);
            infoPanel.add(manuDate);
            infoPanel.add(manuDateText);
            
            JLabel taxBand = new JLabel("Tax Band: ");
            taxBandText = new JTextField(Character.toString(garage.getInterest().getTaxBand()));
            taxBandText.setEditable(false);
            infoPanel.add(taxBand);
            infoPanel.add(taxBandText);
            
            JLabel co2 = new JLabel("CO2: ");
            co2Text = new JTextField(garage.getInterest().getCO2());
            co2Text.setEditable(false);
            infoPanel.add(co2);
            infoPanel.add(co2Text);
            
            JLabel cost = new JLabel("Cost: ");
            costText = new JTextField("£" + Double.toString(garage.getInterest().getCost()));
            costText.setEditable(false);
            infoPanel.add(cost);
            infoPanel.add(costText);
            
            
            JLabel sold = new JLabel("Is Sold: ");
            JLabel soldDate = new JLabel("Date Sold");
            JLabel customer = new JLabel("Customer Name: ");
            if(garage.getInterest().isSold()){
                soldText = new JTextField("Sold");
                soldDateText = new JTextField(garage.getInterest().getSoldDateAsString());
                customerText = new JTextField(garage.getInterest().getCustomer().getName());
            }else{
                soldText = new JTextField("Not Sold");
                soldDateText = new JTextField("N/A");
                customerText = new JTextField("N/A");
            }
            
            soldText.setEditable(false);
            soldDateText.setEditable(false);
            customerText.setEditable(false);
            
            infoPanel.add(sold);
            infoPanel.add(soldText);
            infoPanel.add(soldDate);
            infoPanel.add(soldDateText);
            infoPanel.add(customer);
            infoPanel.add(customerText);
                                               
            return infoPanel;
        }
        
        private void updateInformation(){
            VINText.setText(garage.getInterest().getVIN());
            manufactuerText.setText(garage.getInterest().getManu());
            modelText.setText(garage.getInterest().getModel());
            manuDateText.setText(garage.getInterest().getManuDateAsString());
            taxBandText.setText(Character.toString(garage.getInterest().getTaxBand()));
            co2Text.setText(garage.getInterest().getCO2());
            costText.setText(Double.toString(garage.getInterest().getCost()));
            
            if(garage.getInterest().isSold() == true){
                soldText.setText("Sold");
                soldDateText.setText(garage.getInterest().getSoldDateAsString());
                customerText.setText(garage.getInterest().getCustomer().getName());
            }else{
                soldText.setText("Not Sold");
                soldDateText.setText("N/A");
                customerText.setText("N/A");
            }
        }
                
        
       /*
        
        This is used to convert a string with new line formats into one understood by a lable.
        
        private String stringToLabelFormat(String s){
            return "<html>" + s.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>";
        }
        */
        
        
}
