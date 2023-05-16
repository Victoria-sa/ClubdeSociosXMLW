<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Club de Socios WEB</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>  
 	<link rel="icon" href="img/desarrollador-de-software.png">
</head>
<body>
<div class="container">
<div class="card">
	<div class="card-header">
	<h1>Club de Socios Web</h1>
	</div>
	<div class="card-body">
	<form action="ControllerWeb" method="get" enctype="multipart/form-data" class="row g-3 needs-validation" novalidate>
	<div class="col-md-4">
	<label for="validationCustom01" class="form-label">Nombre del Socio</label>
	<input type="text" class="form-control" id="validationCustom01" required name="nombreSocio">
	<div class="invalid-feedback">
	El nombre Requerido
	</div>
</div>
	<div class="col-md-4">
	<label for="validationCustom02" class="form-label">Dirección</label>
	<input type="text" class="form-control" id="validationCustom02" required name="direccionSocio">
	<div class="invalid-feedback">
	La dirección es requerida
	</div>
</div>
	<div class="col-md-4">
	<label for="validationCustom03" class="form-label">Fecha Alta</label>
	<input type="date" class="form-control" id="validationCustom03" required name="altaSocio">
	<div class="invalid-feedback">
	Indique la fecha de Alta
	</div>
	</div>
	<div class="col-md-4">
	<label for="archivo" class="form-label">Tiene un fichero XML?</label>
	<input type="file" class=".xml" name="archivo" id="archivo" class="form-control">
	</div>
	<div class="col-12">
	<input type="submit" class="btn btn-primary" value="Enviar Formulario">
	</div>		
	</form>	
	</div>
</div>
<!-- 
<c:if test="${not empty misSocios }"></c:if>
 -->
 <c:if test="${not empty socios}"/>
<table class="table table-striped table-hover">
  	 <tr>
		      <th>ID</th>
		      <th>Nombre</th>
		      <th>Direccion</th>
		      <th>Fecha Alta</th>		        
		      <th>Foto</th>  
		      <th>Acciones</th>
		       <td>
           <a href="ControllerWeb?" title="Borrar" class="btn,h6" id="eliminar">&#128465;</a>
           <a href="ControllerWeb?" title="Modificar" class="btn,h6" id="modificar">&#10002;</a>
           </td>
     </tr>	
     	<!-- for each arecorres socios -->
      <c:forEach items="${misSocios}" var="socioN">
       <tr>
       	   <th><c:out value="${socioN.idTemp}"></c:out></th>
           <td><c:out value="${socioN.nombreSocio}"></c:out></td>
           <td><c:out value="${socioN.direccionSocio}"></c:out></td>
           <td><c:out value="${socioN.altaSocio}"></c:out></td>
           
          
           </tr>
            </c:forEach>
	</table>
</div>
<!-- llamamos al script para validar -->
<script >
// Example starter JavaScript for disabling form submissions if there are invalid fields
(() => {
  'use strict'

  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  const forms = document.querySelectorAll('.needs-validation')

  // Loop over them and prevent submission
  Array.from(forms).forEach(form => {
    form.addEventListener('submit', event => {
      if (!form.checkValidity()) {
        event.preventDefault()
        event.stopPropagation()
      }

      form.classList.add('was-validated')
    }, false)
  })
})()
</script>
</body>
</html>