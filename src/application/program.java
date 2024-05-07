package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelentities.reservation;

public class program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        
        System.out.print("Room number:");
        int number = sc.nextInt();
        System.out.println("check-in date (dd/mm/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.println("check-out date (dd/mm/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)){
            System.out.println("Error in reservation:Check-out date must be after chech-in date");
        }
        else{
            reservation reservation = new reservation(number, checkIn, checkOut);
            System.out.println("Reservation:"+reservation);

            System.out.println();
            System.out.println("Enter date to reserve the reservation:");
            System.out.println("check-in date (dd/mm/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.println("check-out date (dd/mm/yyyy): ");
            checkOut = sdf.parse(sc.next());
            

             //somente para estudo faremos de uma forma ruim a validação
            Date now = new Date();
            if(checkIn.before(now) || checkOut.before(now)){
                System.out.println("Error in reservation: Reservation dates for update must be future dates");
            }
            else if (!checkOut.after(checkIn)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            }
            else {
            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation:"+ reservation);
            }
            
        }

        sc.close();
    }
}
