<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/resources/maquetacion/taglibs.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <style type="text/css"><%@include file="/resources/css/styles.css" %></style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Banking ComunidadIT</title>

        <script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>

<!--        <script>
            $(document).ready(function(){
               $("#bEnviar").click(function(){
                    var username = $("#usernameid").val();

                    alert(username);
               }); 
            });


        </script>-->

    </head>

    <body>

        <div class="container">

            <header>
                <%@include file="/resources/maquetacion/header.jsp" %>
            </header>



            ${estado}
            <div class="container-fluid">



                <div class="row">
                    <div class="col-md-12" id="registro">

                        <f:form action="${pageContext.request.contextPath}/user/registrar" modelAttribute="Usuario">

                            <label for="usernameid">Username: </label><br/>
                            <input type="text" name="username" id="usernameid" value="" class="input" required autofocus/><br/><br/>

                            <label for="passwordid">Password: </label><br/>
                            <input type="password" name="password" id="passwordid" value="" class="input"  required minlength=6/><br/><br/>

                            <label for="emailid">Correo: </label><br/>
                            <input type="email" name="email" id="emailid" value="" class="input"  required/><br/><br/>

                            <label for="nombreid">Nombre: </label><br/>
                            <input type="text" name="Customer.fistname" id="nombreid" value="" class="input"  required/><br/><br/>

                            <label for="apellidoid">Apellido: </label><br/>
                            <input type="text" name="Customer.lastname" id="apellidoid" value="" class="input"  required/><br/><br/>

                            <label for="dniid">DNI:  </label><br/>
                            <input type="text" name="Customer.dni" id="diniid" value="" class="input"  required/><br/><br/>

                            <label for="telefonoid">Telefono: </label><br/>
                            <input type="text" name="Customer.phone" id="telefonoid" value="" class="input"  required/><br/><br/>

                            <br/>
                            <a href="${pageContext.request.contextPath}/" class="btn btn-warning btn-lg" role="button">Cancelar</a> 
                            <input type="submit" id="bEnviar" class="btn btn-success btn-lg" value="Registrar"/>

                        </f:form>

                    </div>
                </div>

            </div>


        </div>

    </body>
</html>
