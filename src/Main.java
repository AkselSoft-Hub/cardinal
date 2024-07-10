import checkout.Checkout;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Map<String, Object>[] mockups = new Map[6];
        mockups[0] = Map.of("toolCode", "JAKR", "checkoutDate", "9/3/15", "rentalDays", 5, "discount", 101);
        mockups[1] = Map.of("toolCode", "LADW", "checkoutDate", "7/2/20", "rentalDays", 3, "discount", 10);
        mockups[2] = Map.of("toolCode", "CHNS", "checkoutDate", "7/2/15", "rentalDays", 5, "discount", 25);
        mockups[3] = Map.of("toolCode", "JAKD", "checkoutDate", "9/3/15", "rentalDays", 6, "discount", 0);
        mockups[4] = Map.of("toolCode", "JAKR", "checkoutDate", "7/2/15", "rentalDays", 9, "discount", 0);
        mockups[5] = Map.of("toolCode", "JAKR", "checkoutDate", "7/2/20", "rentalDays", 4, "discount", 50);

        System.out.println("^^^^^^^^^^^^^Welcome Cardinal Rental Tools^^^^^^^^^^^^^");

        for ( int index = 0; index < mockups.length; index++ ) {
            Map<String, Object> mockup      = mockups[index];
            DateTimeFormatter formatter     = DateTimeFormatter.ofPattern( "M/d/yy" );
            String toolCode                 = ( String )mockup.get( "toolCode" );
            String checkoutDateText         = ( String )mockup.get( "checkoutDate" );
            Integer rentalDays              = ( Integer )mockup.get( "rentalDays" );
            Integer discount                = ( Integer )mockup.get( "discount" );
            LocalDate checkoutDate          = LocalDate.parse( checkoutDateText, formatter );

            try {
                Checkout checkout = new Checkout(
                        toolCode,
                        checkoutDate,
                        rentalDays,
                        discount
                );
                System.out.println( "-------------------------------------------------------" );
                checkout.makeRentalAgreement();
            } catch ( Exception e ) {
                System.out.println( "-------------------------------------------------------" );
                System.out.println( "Tool code: " + toolCode );
                System.out.println( "Check out date: " + checkoutDateText );
                System.out.println( "Rental days: " + rentalDays );
                System.out.println( "Discount percent: " + discount + "%" );
                System.out.println( "ERROR: " + e.getMessage() );
            }
        }
    }
}