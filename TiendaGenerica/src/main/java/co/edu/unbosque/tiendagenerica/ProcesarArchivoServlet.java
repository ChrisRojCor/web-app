package co.edu.unbosque.tiendagenerica;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.*;

@WebServlet(name = "ProcesarArchivoServlet", value = "/ProcesarArchivoServlet")
@MultipartConfig
public class ProcesarArchivoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter write = response.getWriter();
        Part filePart = request.getPart("file");
        InputStream fileContent = filePart.getInputStream();
        Reader in = new InputStreamReader(fileContent);
        CSVReader reader;
        Iterator<String[]> iterator;
        ArrayList<Productos> productos = new ArrayList<Productos>();
        List<String[]> leerDatos = new ArrayList<String[]>();
        ArrayList<String> datosProductos = new ArrayList<>();


        try {
            reader = new CSVReader(new InputStreamReader(fileContent));
            String[] nextline;
            while ((nextline = reader.readNext()) != null) {
                if (nextline != null) {
                    write.println(Arrays.toString(nextline));


                }
            }
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
    }
}


        //try {

        //  reader = new CSVReader(new InputStreamReader(fileContent));
        //iterator = reader.iterator();

        // String[] row = iterator.next();

        //  HashMap<String, Integer> map = new HashMap<>();
        // for(int i = 0; i < row.length; i++){
        //   map.put(row[i], i);

        //   Set<String> keySet = map.keySet();


        // }

        // }catch(Exception e) {}

        //in.close();




    // public static List<String[]> readCSVFile(File file, int startRow, String characters) throws IOException{
    //   List<String[]> strArrayList = new ArrayList<String[]>();

    // CSVReader reader = null;
    // if (",".equalsIgnoreCase(characters)){
    //     reader = new CSVReader(new FileReader(file));
    //  } else {
    // Con separador
    //     reader = new CSVReader(new FileReader(file),characters.toCharArray()[0]);
    // }

    // String[] nextLine;
    // int i = 1;
    // while ((nextLine = reader.readNext()) != null) {
//          System.out.println("Name: [" + nextLine[0] + "]\nAddress: [" + nextLine[1] + "]\nEmail: [" + nextLine[2] + "]");

    //    if (i>=startRow)
    //       strArrayList.add(nextLine);

    // i++;
    //}

    // return strArrayList;




