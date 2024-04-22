/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;

/**
 *
 * @author dnys
 */
public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date: ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date: ");
        Date checkOut = sdf.parse(sc.next());
        
        if(!checkOut.after(checkIn)) {
            System.out.println("Erro in reservation: Check-out date must de after check-in date.");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation" + reservation);
            
            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date: ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date: ");
            checkOut = sdf.parse(sc.next());
            
            Date now = new Date();
            
            if(checkIn.before(now) || checkOut.before(now)) {
                System.out.println("Erro in reservation: Reservations dates for update must be future dates.");
            } else if (!checkOut.after(checkIn)) {
                System.out.println("Erro in reservation: Check-out date must de after check-in date.");
            } else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
            }
        }
        
        sc.close();
    }
}
