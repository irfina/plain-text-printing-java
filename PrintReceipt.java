import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PrintReceipt 
{

    public static void main(String[] args) 
    {
        String receipt = "========== Receipt ==========\n\n";
        receipt += "Item: Coffee\n";
        receipt += "Price: $3.99\n";
        receipt += "Quantity: 1\n\n";
        receipt += "Total: $3.99\n\n";
        receipt += "Date: " + getCurrentDate() + "\n\n";
        receipt += "Thank you for your purchase!\n";
        receipt += "=============================\n";
        
        printReceipt(receipt);
    }

    private static String getCurrentDate() 
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(new Date());
    }

    private static void printReceipt(String receipt)
    {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new ReceiptPrintable(receipt));
        try {
            job.setPrintService(PrinterJob.lookupPrintServices()[0]);
            job.print();
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }
}