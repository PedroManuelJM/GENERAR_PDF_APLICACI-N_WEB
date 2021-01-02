/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conexion;
import Model.usuario;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PCGAMING
 */
public class Procesa_PDF extends HttpServlet {

    
       protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           response.setContentType("application/pdf");/*salida en pdf*/

           OutputStream out = response.getOutputStream();

           try {
               try {
                   Conexion con = new Conexion();
                   String query = "select * from usuario";
                   Statement sentencia = con.getConnection().createStatement();
                   ResultSet resultado = sentencia.executeQuery(query);
                   if (con != null) {

                       try {
                           Document documento = new Document();
                           PdfWriter.getInstance(documento, out);
                           /*solo titulo*/
                           documento.open();
                           Paragraph par1 = new Paragraph();
                           Font fontitulo = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.RED);
                           par1.add(new Phrase("Reporte Usuarios ", fontitulo));
                           par1.setAlignment(Element.ALIGN_CENTER);/* centrar titulo*/
                           par1.add(new Phrase(Chunk.NEWLINE));/* salto de linea*/
                           par1.add(new Phrase(Chunk.NEWLINE));
                           documento.add(par1);

                           // DESCRIPCION
                           Paragraph par2 = new Paragraph();
                           Font fondescrip = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
                           par2.add(new Phrase("En este reporte se visualiza  la lista de usuarios traido de la base de datos.", fondescrip));
                           par2.setAlignment(Element.ALIGN_CENTER);/* centrar titulo*/
                           par2.add(new Phrase(Chunk.NEWLINE));/* salto de linea*/
                           par2.add(new Phrase(Chunk.NEWLINE));
                           documento.add(par2);

                           Paragraph par3 = new Paragraph();
                           par3.add(new Phrase(Chunk.NEWLINE));
                           documento.add(par3);
                           PdfPTable tabla = new PdfPTable(4);
                           PdfPCell celda1 = new PdfPCell(new Paragraph("ID", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLUE)));
                           celda1.setHorizontalAlignment(Element.ALIGN_CENTER); 
                           celda1.setVerticalAlignment(Element.ALIGN_MIDDLE); 
                           PdfPCell celda2 = new PdfPCell(new Paragraph("Nombres", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLUE)));
                           celda2.setHorizontalAlignment(Element.ALIGN_CENTER); 
                           celda2.setVerticalAlignment(Element.ALIGN_MIDDLE); 
                           PdfPCell celda3 = new PdfPCell(new Paragraph("Apellidos", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLUE)));
                           celda3.setHorizontalAlignment(Element.ALIGN_CENTER); 
                           celda3.setVerticalAlignment(Element.ALIGN_MIDDLE); 
                           PdfPCell celda4 = new PdfPCell(new Paragraph("Correo", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLUE)));
                           celda4.setHorizontalAlignment(Element.ALIGN_CENTER); 
                           celda4.setVerticalAlignment(Element.ALIGN_MIDDLE); 
                           float[] columna_ancho = new float[]{05f, 20f, 20f,25f}; /*tamaño para las columnas */
                           tabla.setWidths(columna_ancho);
                           /*OJO MI TABLA TIENE 4 ATRIBUTOS ENTONCES CREO 4 CELDAS  , 
                             DEPENDE DE LA CANTIDAD DE ATRIBUTOS QUE TIENES TU TABLA AGREGAS LAS CELDAS.
                           */
                           tabla.addCell(celda1);
                           tabla.addCell(celda2);
                           tabla.addCell(celda3);
                           tabla.addCell(celda4);

                           tabla.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);/*alinea al centro los datos de las celdas */
                           while (resultado.next()) {
                               // Recorre los datos que viene de la base de datos 
                               tabla.addCell(resultado.getString(1));
                               tabla.addCell(resultado.getString(2));
                               tabla.addCell(resultado.getString(3));
                               tabla.addCell(resultado.getString(4));
                           }

                           documento.add(tabla);
                           documento.close();

                       } catch (Exception e) {
                       }

                   }

               } catch (Exception ex) {
                   ex.getMessage();
               }

               /*fin de la consulta*/
           } finally {
               out.close();
           }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
