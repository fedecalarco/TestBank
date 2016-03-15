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
    </head>
    <body>
        <div class="container">
            <header>
                <%@include file="/resources/maquetacion/header.jsp" %>
            </header>
            <div class="container-fluid">
                <div><%@include file="/resources/maquetacion/barraSuperior.jsp" %></div>
                <div class="row">
                    <div>
                        <%@include file="/resources/maquetacion/menuIzquierdo.jsp" %>
                    </div>
                    <div class="col-md-8" id="tabla">
                        <h1>Resumen de cuenta</h1>
                        <h4>Titular: ${session_user.getCustomer().getFistname()} </h4>
                        <h4>Nº de cuenta: 648418/${session_user.getCustomer().getCustomer_ID()}</h4>
                        <h4>DNI: ${session_user.getCustomer().getDni()}</h4>
                        <br>
                        <h4>Saldo: $ ${session_user.getCustomer().getAccounts().get(0).getBalance()}</h4>
                        <h3>Ultimos movimientos</h3>
                        <table class="table table-hover" border="0">
                            <tr>
                                <th>Fecha</th>
                                <th>Movimiento</th>
                            </tr>
                            <c:forEach items="${session_user.getCustomer().getAccounts().get(0).getMovs()}" var="p">
                                <tr>
                                    <td>${p.date}</td>
                                    <td>${p.action}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                    <div class="col-md-2" id="menuDerecha">
                        <br><br><br><br><br>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
