<%-- 
    Document   : index
    Created on : 01-ene-2021, 20:55:52
    Author     : PCGAMING
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="Model.usuario"%>
<%@page import="Model.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <title>REPORTE</title>
    </head>
    <body>
       <style>
            @media print {
                .btn {
                    display: none !important;  
                }
                .row{
                    display:none;
                }  
            }
    
        </style> 
        <!-- -->
        <%
            Conexion con=new Conexion();
            usuario u=new usuario(con);
            LinkedList<usuario> Lista_usuarios= u.ListarUsuarios();
        %>
        <header id="main-header" class="card text-white bg-primary">
            <div class="container text-center">
                <h1> Reporte Usuarios </h1>
            </div>
        </header><!-- container -->

        <div class="d-flex">    
            <div class="card col-sm-12">    
                <div class="card-body">       

                    <form  name="reporte_aerolinealss" action="Procesa_PDF">               
                        <table class="table table-striped table-hover" >
                            <thead class="bg-warning">
                                <tr>
                                    <th>ID</th>
                                    <th>NOMBRES</th>
                                    <th>APELLIDOS</th>
                                    <th>CORREO</th>
                                </tr>
                            </thead>
                            <tbody>                 
                                <% for (int i = 0; i < Lista_usuarios.size(); i++) {%>
                                <tr>
                                    <td><%=  Lista_usuarios.get(i).getIdusuario()%></td>
                                    <td><%=  Lista_usuarios.get(i).getNombre()%></td>
                                    <td><%=  Lista_usuarios.get(i).getApellido()%></td>
                                    <td><%=  Lista_usuarios.get(i).getCorreo()%></td>
                                       
                                <% };%>
                            </tbody>
                        </table><!--table--> 
                        <div class="row">
                            <div class="col-md-12">
                                <!-- Se genera el pdf usando la libreria itextpdf -->
                                <span class="float-right col-md-2" style="margin-top: 8px;"> --> Opción 1 </span> <button type="submit" formtarget="_blank" class="btn btn-info float-right" style="">Generar PDF</button>             
                            </div>
                        </div>
                        <div class="row">      
                            <div class="col-md-12">
                                <span class="float-right col-md-2" style="margin-top: 15px;"> --> Opción 2 </span> <button type="button" class="mt-2 btn btn-success float-right" onclick="window.print()">Imprimir</button>             
                            </div>
                        </div>
                    </form>    

                </div><!--card body -->
            </div><!--card -->     
        </div>

    </body>
    
</html>
