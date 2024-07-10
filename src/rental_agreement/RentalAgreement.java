package rental_agreement;

import tool.attributes.brand.BRAND;
import tool.attributes.tool_code.TOOL_CODE;
import tool.attributes.tool_type.TOOL_TYPE;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RentalAgreement {
    private TOOL_CODE       toolCode;
    private TOOL_TYPE       toolType;
    private BRAND           toolBrand;
    private Integer         rentalDays;
    private LocalDate       checkoutDate;
    private LocalDate       dueDate;
    private BigDecimal      dailyRentalCharge;
    private Integer         chargeDays;
    private BigDecimal      preDiscountCharge;
    private Integer         discountPercent;
    private BigDecimal      discountAmount;
    private BigDecimal      finalCharge;

    public RentalAgreement(
            TOOL_CODE toolCode,
            TOOL_TYPE toolType,
            BRAND toolBrand,
            Integer rentalDays,
            LocalDate checkoutDate,
            LocalDate dueDate,
            BigDecimal dailyRentalCharge,
            Integer chargeDays,
            BigDecimal preDiscountCharge,
            Integer discountPercent,
            BigDecimal discountAmount,
            BigDecimal finalCharge
    ) {
        this.toolCode           = toolCode;
        this.toolType           = toolType;
        this.toolBrand          = toolBrand;
        this.rentalDays         = rentalDays;
        this.checkoutDate       = checkoutDate;
        this.dueDate            = dueDate;
        this.dailyRentalCharge  = dailyRentalCharge;
        this.chargeDays         = chargeDays;
        this.preDiscountCharge  = preDiscountCharge;
        this.discountPercent    = discountPercent;
        this.discountAmount     = discountAmount;
        this.finalCharge        = finalCharge;

        this.publish();
    }

    private void publish() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yy");

        System.out.println( "Tool code: " + this.toolCode );
        System.out.println( "Tool type: " + this.toolType.name );
        System.out.println( "Tool brand: " + this.toolBrand.brand );
        System.out.println( "Rental days: " + this.rentalDays );
        System.out.println( "Check out date: " + this.checkoutDate.format( dateFormatter ) );
        System.out.println( "Due date: " + dueDate.format( dateFormatter ) );
        System.out.println( "Daily rental charge: $" + this.dailyRentalCharge );
        System.out.println( "Charge days: " + this.chargeDays );
        System.out.println( "Pre-discount charge: $" + preDiscountCharge );
        System.out.println( "Discount percent: " + discountPercent + "%" );
        System.out.println( "Discount amount: $" + discountAmount );
        System.out.println( "Final charge: $" + finalCharge );
    }
}
