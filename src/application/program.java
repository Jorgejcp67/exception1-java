package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelentities.reservation;
import modelexceptions.domainException;

public class program {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        try{
            System.out.print("Room number:");
            int number = sc.nextInt();
            System.out.println("check-in date (dd/mm/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.println("check-out date (dd/mm/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            
        
            reservation reservation = new reservation(number, checkIn, checkOut);
            System.out.println("Reservation:"+reservation);

            System.out.println();
            System.out.println("Enter date to reserve the reservation:");
            System.out.println("check-in date (dd/mm/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.println("check-out date (dd/mm/yyyy): ");
            checkOut = sdf.parse(sc.next());
            
            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: "+ reservation);      
            
        }
        catch(ParseException e) {
           System.out.println("Invalid date format");
        }
        catch(domainException e){
            System.out.println("Error in reservation:"+e.getMessage());
        }
        catch(RuntimeException e){
            System.out.println("Unexpected error");
        }

        sc.close();
    }
}
