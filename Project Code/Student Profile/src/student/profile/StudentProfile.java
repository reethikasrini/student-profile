/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.profile;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class StudentProfile {

    /**
     * @param args the command line arguments
     */
    
    private int id;
    private String name;
    private String domain;
    private String address;
    
    public StudentProfile(){
        
    }
    public StudentProfile(int id, String name, String domain, String address){
        this.id = id;
        this.name = name;
        this.domain = domain;
        this.address = address;
    }
    public StudentProfile(String name, String domain, String address){
        this.name = name;
        this.domain = domain;
        this.address = address;
    }
    public int getid(){
        return id;
    }
    public void setid(int id){
        this.id=id;
    }
    public String getname(){
        return name;
    }
    public void setname(String name){
        this.name=name;
    }
    public String getdomain(){
        return domain;
    }
    public void setdomain(String domain){
        this.domain=domain;
    }
    public String getaddress(){
        return address;
    }
    public void address (String address){
        this.address=address;
    }
    
    @Override
    public String toString(){
        return  "Student ID ->      "+ id+ "\n"+ 
                "Student Name ->    "+ name+ "\n"+
                "Student Domain ->  "+ domain+ "\n"+
                "Student Address -> "+ address+ "\n";
    }
    
    public static void main(String[] args) throws SQLException {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("***** The Student Profile Portal *****");
        Addaction aa = new Addaction();
        while(true){
            
            System.out.println(
            "\n Press 1 for Adding Profile \n"+ 
            "\n Press 2 for Displaying Profiles \n"+
            "\n Press 3 for Displaying Profile with ID \n"+
            "\n Press 4 for Deleting Profile \n"+
            "\n Press 5 for Updating Profile \n"+
            "\n Press 6 for Exiting the portal \n"
            );
            
            System.out.println("Please Provide Input - ");
            int i = sc.nextInt();
            
            switch(i){
                case 1:
                    System.out.println("Add Profile");
                    System.out.println("Enter Name");
                    String name = sc.next();
                    System.out.println("Enter Domain");
                    String domain = sc.next();
                    System.out.println("Enter Address");
                    String address = sc.next();
                    
                    StudentProfile sp = new StudentProfile(name, domain, address);
                    
                    boolean valid = aa.add(sp);
                    
                    if(valid==true)
                        System.out.println("** Profile Added **");
                    else
                        System.out.println("** Problem Occured **");
                    break;
                case 2:
                    System.out.println("Display");
                    aa.display();
                    break;
                case 3:
                    System.out.println("Display by ID");
                    
                    System.out.println("Enter ID ->");
                    int in = sc.nextInt();
                    boolean validID = aa.displaybyID(in);
                    if(validID==false)
                        System.out.println("****Profile with this ID not avaiable");
                    break;
                case 4:
                    System.out.println("Delete");
                    System.out.println("Enter ID to delete ->");
                    int de = sc.nextInt();
                    
                    boolean validDID = aa.delete(de);
                    if(validDID==true)
                        System.out.println("****Deleted Successfully ****");
                    else
                        System.out.println("****Problem occured****");
                    break;
                case 5:
                    System.out.println("Update");
                    System.out.println(
                    "Press 1 to update Domain \n"+
                    "Press 2 to update Address"
                    );
                    int se = sc.nextInt();
                    
                    if(se==1){
                        System.out.println("Enter ID ");
                        int idd = sc.nextInt();
                        System.out.println("Enter new Domain");
                        String ddomain = sc.next();
                        StudentProfile spp = new StudentProfile();
                        spp.setdomain(ddomain);
                        boolean up = aa.update(idd,ddomain,se,spp);
                        if(up==true){
                            System.out.println("Domain updated successfully");
                        }
                        else
                            System.out.println("Error Occured");
                    }
                    else if(se==2){
                        System.out.println("Enter ID ");
                        int idd = sc.nextInt();
                        System.out.println("Enter new Address");
                        String addr = sc.next();
                        StudentProfile spp = new StudentProfile();
                        spp.setdomain(addr);
                        boolean up = aa.update(idd,addr,se,spp);
                        if(up==true){
                            System.out.println("Address updated successfully");
                        }
                        else
                            System.out.println("Error Occured");
                    }
                    else
                        System.out.println("Invalid Choice *****");
                    break;
                case 6:
                    System.out.println("Exit");
                    System.exit(0);
                    break;   
                default:
                    System.out.println("Invalid");
            }
        }
    }
    
}
