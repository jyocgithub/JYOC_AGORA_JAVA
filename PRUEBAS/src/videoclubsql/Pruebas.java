package videoclubsql;

//import org.joda.time.DateTime;
//import org.joda.time.DateTimeZone;
//import org.joda.time.Interval;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Pruebas {


//    public static void main(String[] args) {
//        LocalDate l1 = LocalDate.parse("01/01/2002", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//        LocalDate l2 = LocalDate.parse("01/02/2007", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//        LocalDate l3 = LocalDate.parse("01/01/2001", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//        LocalDate l4 = LocalDate.parse("01/01/2002", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//
//        if (seSolapan(l1,l2,l3,l4)) System.out.println("Se solapan");
//        else System.out.println("No se solapan");
//
//
//
//        // Converting DateTime object into JDK's Date.
//        DateTime dateTime = DateTime.now();
//        Date date = dateTime.toDate();
//        System.out.println("dateTime = " + dateTime);
//        System.out.println("date     = " + date);
//
//        // Converting DateTime object into JDK's Calendar.
//        Calendar calendar = dateTime.toCalendar(Locale.getDefault());
//        System.out.println("calendar = " + calendar);
//
////       DateTime dd =  new DateTime(calendar.getYear(), calendar.getMonthValue(), calendar.getDayOfMonth(), 0, 0, 0, 0);
//
//
//
//
//    }
//
//    public static boolean seSolapan(LocalDate unoInicio, LocalDate unoFinal, LocalDate dosInicio, LocalDate dosFinal) {
//        unoFinal = unoFinal.plusDays(1);
//        dosFinal = dosFinal.plusDays(1);
//        DateTime unoIni = new DateTime(unoInicio.getYear(), unoInicio.getMonthValue(), unoInicio.getDayOfMonth(), 0, 0, 0, 0);
//        DateTime unoFin = new DateTime(unoFinal.getYear(), unoFinal.getMonthValue(), unoFinal.getDayOfMonth(), 0, 0, 0, 0);
//        DateTime dosIni = new DateTime(dosInicio.getYear(), dosInicio.getMonthValue(), dosInicio.getDayOfMonth(), 0, 0, 0, 0);
//        DateTime dosFin = new DateTime(dosFinal.getYear(), dosFinal.getMonthValue(), dosFinal.getDayOfMonth(), 0, 0, 0, 0);
//        Interval inter1 = new Interval(unoIni, unoFin);
//        Interval inter2 = new Interval(dosIni, dosFin);
//        boolean solucion = inter1.overlaps(inter2);
//        return solucion;
//    }
//
//
//    /**
//     * convierte un java.time.LocalDate en un org.joda.time.DateTime
//     */
//    public static DateTime localDatetoDateTime(LocalDate unLocalDate) {
//        return new DateTime(unLocalDate.getYear(), unLocalDate.getMonthValue(), unLocalDate.getDayOfMonth(), 0, 0, 0, 0);
//    }
//
//    /**
//     * convierte un org.joda.time.DateTime en un java.time.LocalDate
//     */
//    public static LocalDate dateTimetoLocalDate(DateTime unDateTime) {
//        return LocalDate.of(unDateTime.getYear(), unDateTime.getMonthOfYear(), unDateTime.getDayOfMonth());
//    }
}
