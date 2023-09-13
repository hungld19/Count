/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.CountProgram;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LAPTOP DELL
 */
public abstract class Menu<T> {
  
    static Scanner scanner = new Scanner(System.in);
    protected  String title;
    protected ArrayList<T> options ;

    public Menu() {
         options = new ArrayList<>();
    }
    
    
    public Menu(String td, String[] option) {
        this.title = td;
        options = new ArrayList<>();
        for (String s : option) {
            options.add((T) s);
        }
    }
    
    public void display() {
        System.out.println(title);
        System.out.println("--------------------------------");
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + "." + options.get(i));
        }
        System.out.println("--------------------------------");
    }
     
    public Integer getChoice() {
        display();
        int choice = 0;
        System.out.println("Enter number's option: ");
        while(choice == 0) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e) {
                System.err.println("Your choice must be a number!");
            }
        }
        return choice;
    }
    
    public abstract void execute(int n);
    
    public void run() {
        while(true) {
            int choice = getChoice();
            execute(choice);
            if(choice>options.size()) break;
        }
    }
    
}