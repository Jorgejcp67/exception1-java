package modelentities;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import modelexceptions.domainException;


public class reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

    

    public reservation(Integer roomNumber, Date checkIn, Date checkOut) throws domainException {
        if(! checkOut.after(checkIn)){
            throw new domainException( "Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
    
   
    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckin() {
        return checkIn;
    }

   

    public Date getChecKout() {
        return checkOut;
    }

    public long duration(){
       long diff = checkOut.getTime() - checkIn.getTime(); 
       return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    
    public void updateDates(Date checkIn, Date checkOut)throws domainException{
        Date now =new Date();
        if(checkIn.before(now)|| checkOut.before(now)){
           throw new domainException( "Reservation dates for update must be future dates");
        }
        if(! checkOut.after(checkIn)){
            throw new domainException( "Check-out date must be after check-in date");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
      
       @Override
       public String toString(){
        return"Room "
              +roomNumber
              +", chech-in:"
              +"sdf.format (checkIn)"
              +", chech-out:"
              +"sdf,format (checkOut)"
              +","
              + duration()
              +" nights";
       }
    }
