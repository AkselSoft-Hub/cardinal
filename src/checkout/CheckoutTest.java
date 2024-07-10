package checkout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tool.attributes.tool_code.TOOL_CODE;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutTest {

    private Checkout checkout;

    @BeforeEach
    void setUp() {
        String toolCode = "LADW"; // Example TOOL_CODE
        LocalDate checkoutDate = LocalDate.of(2023, 10, 1); // Example checkout date
        Integer rentalDays = 0; // Example rental days
        Integer discountPercent = 101; // Example discount

        checkout = new Checkout(toolCode, checkoutDate, rentalDays, discountPercent);
    }

    @Test
    void testRentalDays() {
        assertFalse(checkout.rentalDays < 1,"Rental days must be 1 or greater");
    }

    @Test
    void testInvalidDiscountPercent() {
        assertFalse( ( checkout.discountPercent > 100 || checkout.discountPercent < 0 ),"Discount percent must be between 0 and 100" );
    }
}