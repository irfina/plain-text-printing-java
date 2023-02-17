import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

public class ReceiptPrintable implements Printable 
{
    private final String text;

    public ReceiptPrintable(String receipt) 
    {
        this.text = receipt;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException
    {
        if (pageIndex > 0) {
            System.out.println("NO_SUCH_PAGE");
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        // Split the text into lines
        String[] lines = text.split("\n");

        // Calculate the line height based on the font size
        int lineHeight = graphics.getFontMetrics().getHeight();

        // Print each line, starting at the top of the page
        int y = lineHeight;
        for (String line : lines) {
            graphics.drawString(line, 0, y);
            y += lineHeight;
        }

        //g2d.drawString(receipt, 0, 0);

        System.out.println("PAGE_EXISTS");
        return PAGE_EXISTS;
    }
}
