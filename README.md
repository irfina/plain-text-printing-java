# Printing plain text to default printer in Java
A demo program for printing plain text to a default Windows printer. The source codes given here are from ChatGPT answers and combined with other sources on Internet (especially https://www.rgagnon.com/javadetails/java-print-a-text-file-with-javax.print-api.html).

You must set a default printer first.

Tested on Windows 10, using Epson LX-310 printer.

Notes: Some people on Internet alose recommend to use "\f" (form feed) at the end of printing to make printer eject the paper.

Using Blueprint LITE Series BL-80 printer:
* Control code to cut paper is: Chr(27) & "m"
* In Java: "\u001B" + "m" 
