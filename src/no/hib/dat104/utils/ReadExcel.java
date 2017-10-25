package no.hib.dat104.utils;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import no.hib.dat104.model.DBKom;
import no.hib.dat104.model.Forelesning;


public class ReadExcel {
	@EJB
	DBKom dbk = new DBKom();
	
	private String inputFile;
	String[] fl1 = new String[5];
    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public void read() throws IOException  {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet(0);
            // Loop over first 10 column and lines

                for (int i = 0; i < sheet.getRows(); i++) {
                	for (int j = 0; j < sheet.getColumns(); j++) {
                    Cell cell = sheet.getCell(j, i);
                    CellType type = cell.getType();
                    if (cell.getContents()!= "")
                    fl1[j] = cell.getContents();
                }
                Forelesning f1 = new Forelesning();
                f1.setDato(fl1[0]);
                f1.setKlStart(fl1[1]);
                f1.setKlSlutt(fl1[2]);
                f1.setFag((fl1[3]));
                dbk.lastOppForelesning(f1);
                System.out.println("NIIIICE");
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ReadExcel test = new ReadExcel();
        String ekstraNull = "";
        test.setInputFile("TimeEdit.xls");
        test.read();
//        Date date = new Date();
//        if (date.getMinutes() < 10)
//        	ekstraNull = "0";
//        System.out.println((date.getDate()) +"." +(date.getMonth() + 1) + "." +(date.getYear() + 1900));
//        System.out.println(date.getHours() + ":" + ekstraNull + date.getMinutes());
        
    }

}
