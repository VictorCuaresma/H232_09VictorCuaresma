<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bienes</title>
<link rel="icon" href="img/product.png" type="image/png">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body {
    color: #333;
    background: #f9f9f9;
    font-family: 'Roboto', sans-serif;
    font-size: 14px;
}

.table-responsive {
    margin: 20px 0;
}

.table-wrapper {
    min-width: 800px;
    background: #fff;
    padding: 15px 20px;
    border-radius: 5px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, .1);
}

.table-title {
    padding-bottom: 10px;
    background: #cc99ff; /* Morado claro */

    color: #fff;
    padding: 10px 20px;
    margin: -15px -20px 10px;
    border-radius: 5px 5px 0 0;
}

.table-title h2 {
    margin: 5px 0 0;
    font-size: 22px;
}

.table-title .btn-group {
    float: right;
}

.table-title .btn {
    color: #fff;
    float: right;
    font-size: 14px;
    border: none;
    min-width: 50px;
    border-radius: 3px;
    outline: none !important;
    margin-left: 10px;
}

.table-title .btn i {
    float: left;
    font-size: 18px;
    margin-right: 5px;
}

.table-title .btn span {
    float: left;
    margin-top: 2px;
}

table.table tr th,
table.table tr td {
    border-color: #ddd;
    padding: 10px 15px;
    vertical-align: middle;
}

table.table tr th:first-child {
    width: 50px;
}

table.table tr th:last-child {
    width: 80px;
}

table.table-striped tbody tr:nth-of-type(odd) {
    background-color: #f8bbd0;
}

table.table-striped.table-hover tbody tr:hover {
   background: #aaffaa; /* Verde claro */

}

table.table th i {
    font-size: 14px;
    margin: 0 5px;
    cursor: pointer;
}

table.table td:last-child i {
    opacity: 0.8;
    font-size: 18px;
    margin: 0 5px;
}

table.table td a {
    font-weight: bold;
    color: #333;
    display: inline-block;
    text-decoration: none;
    outline: none !important;
}

table.table td a:hover {
    color: #007bff;
}

table.table td a.edit {
    color: #28a745;
}

table.table td a.delete {
    color: #dc3545;
}

table.table td i {
    font-size: 16px;
}

table.table .avatar {
    border-radius: 50%;
    vertical-align: middle;
    margin-right: 8px;
}

.pagination {
    float: right;
    margin: 0 0 5px;
}

.pagination li a {
    border: none;
    font-size: 14px;
    min-width: 30px;
    min-height: 30px;
    color: #777;
    margin: 0 2px;
    line-height: 30px;
    border-radius: 3px !important;
    text-align: center;
    padding: 0 8px;
}

.pagination li a:hover {
    color: #555;
}

.pagination li.active a,
.pagination li.active a.page-link {
   background: red; 

}

.pagination li.active a:hover {
    background: red; 
}

.pagination li.disabled i {
    color: #ccc;
}

.pagination li i {
    font-size: 18px;
    padding-top: 5px
}

.hint-text {
    float: left;
    margin-top: 8px;
    font-size: 14px;
}
/* Custom checkbox */
.custom-checkbox {
    position: relative;
}

.custom-checkbox input[type="checkbox"] {
    opacity: 0;
    position: absolute;
    margin: 5px 0 0 3px;
    z-index: 9;
}

.custom-checkbox label:before {
    width: 20px;
    height: 20px;
}

.custom-checkbox label:before {
    content: '';
    margin-right: 8px;
    display: inline-block;
    vertical-align: text-top;
    background: white;
    border: 1px solid #bbb;
    border-radius: 3px;
    box-sizing: border-box;
    z-index: 2;
}

.custom-checkbox input[type="checkbox"]:checked+label:after {
    content: '';
    position: absolute;
    left: 7px;
    top: 4px;
    width: 7px;
    height: 12px;
    border: solid #000;
    border-width: 0 3px 3px 0;
    transform: inherit;
    z-index: 3;
    transform: rotateZ(45deg);
}

.custom-checkbox input[type="checkbox"]:checked+label:before {
    border-color: #007bff;
    background: red;
}

.custom-checkbox input[type="checkbox"]:checked+label:after {
    background: red;
}

.custom-checkbox input[type="checkbox"]:disabled+label:before {
    color: #b8b8b8;
    cursor: auto;
    box-shadow: none;
    background: #ddd;
}
/* Modal styles */
.modal .modal-dialog {
    max-width: 500px;
}

.modal .modal-header,
.modal .modal-body,
.modal .modal-footer {
    padding: 15px 20px;
}

.modal .modal-content {
    border-radius: 5px;
}

.modal .modal-footer {
     background: red;
    border-radius: 0 0 5px 5px;
}

.modal .modal-title {
    display: inline-block;
}

.modal .form-control {
    border-radius: 3px;
    box-shadow: none;
    border-color: #dddddd;
}

.modal textarea.form-control {
    resize: vertical;
}

.modal .btn {
    border-radius: 3px;
    min-width: 120px;
}

.modal form label {
    font-weight: normal;
}

.hidden-cell {
     display: none;
}
</style>

<script>
	$(document).ready(function() {
		// Activate tooltip
		$('[data-toggle="tooltip"]').tooltip();

		// Select/Deselect checkboxes
		var checkbox = $('table tbody input[type="checkbox"]');
		$("#selectAll").click(function() {
			if (this.checked) {
				checkbox.each(function() {
					this.checked = true;
				});
			} else {
				checkbox.each(function() {
					this.checked = false;
				});
			}
		});
		checkbox.click(function() {
			if (!this.checked) {
				$("#selectAll").prop("checked", false);
			}
		});
	});
</script>
</head>
<body>
	<div class="col">
                <jsp:include page="navbar.jsp"></jsp:include>
            </div>
	<br>
	<div class="container">
    <form action="SearchBien" method="get" class="form-inline">
        <input type="text" name="detail" id="form1" class="form-control" placeholder="Buscar por Detalle de Bien" aria-label="Search" value="${param.detail}"/>
        <input type="text" name="code" id="form1" class="form-control" placeholder="Buscar por Código" aria-label="Search" value="${param.code}"/>
        <input class="btn btn-primary" type="submit" value="Buscar" style="color: white; background-color: black;">
    </form>
</div>

		
		<style>
		.form-control {
    width: 400px; /* Adjust the width as needed */
}
		
		</style>
		<div class="table-responsive">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<div class="col-xs-6">
							<h2>
								GESTION DE <b>BIENES</b>
							</h2>
						</div>
						<div class="col-xs-6">
							<a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i
								class="material-icons">&#xE147;</i> <span>AÑADIR</span></a>
								<a class="btn btn-danger" href="Inactivos" role="button">BAJA</a>
    					<div class="btn-group">
        					<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
            					DESCARGAR <span class="caret"></span>
        					</button>
        						<ul class="dropdown-menu" role="menu">
            					<li><a href="ExportarDatos?exportType=csv">DESCARGA EN CSV</a></li>
            					<li><a href="ExportarDatos?exportType=xls">DESCARGA EN XLS</a></li>
            					<li><a href="ExportarDatos?exportType=pdf">DESCARGA EN PDF</a></li>
        						</ul>
    						</div>
						</div>
					</div>
				</div>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th class="hidden-cell">ID</th>
							<th class="hidden-cell">date</th>
							<th class="hidden-cell">depre</th>
							<th>Codigo</th>
							<th>Detalle</th>
							<th>Valor</th>
							<th>#</th>
							<th>%</th>
							<th>FechaIngreso</th>
							<th>FechaDeprecion</th>
							<th>D.Anual</th>
							<th>D.Semanal</th>
							<th>D.Acumulada</th>
							<th>Estado</th>
							<th>Opción</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${bienes}" var="bien">
							<tr>
								<td class="hidden-cell">${bien.id_contabilidad}</td>
								<td class="hidden-cell">${bien.id_date}</td>
								<td class="hidden-cell">${bien.id_depre}</td>
								<td>${bien.code}</td>
								<td>${bien.detail}</td>
								<td>${bien.value_book}</td>
								<td>${bien.amount}</td>
								<td>${bien.porcentaje}</td>
								<td>${bien.date_admi}</td>
								<td>${bien.depre_admi}</td>
								<td>${bien.depreciacion_anual}</td>
								<td>${bien.depreciacion_mensual}</td>
								<td>${bien.depreciacion_acumulada}</td>
								<td>${bien.status}</td>
								<td><a href="#editEmployeeModal" class="edit"
									   data-toggle="modal" 
									   data-bien="${bien.id_contabilidad}"
									   data-admi="${bien.id_date}"
									   data-depre="${bien.id_depre}"
									   data-code="${bien.code}"
									   data-detail="${bien.detail}"
									   data-value="${bien.value_book}"
									   data-porcen="${bien.porcentaje}"
									   data-admi_fecha="${bien.date_admi}"
									   data-depre_fecha="${bien.depre_admi}"><i
										class="material-icons" data-toggle="tooltip" title="Editar">&#xE254;</i></a>
									<a href="#deleteEmployeeModal" class="delete"
									data-toggle="modal" data-id="${bien.id_contabilidad}"><i class="material-icons"
										data-toggle="tooltip" title="Cambiar Estado">toggle_off</i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
			</div>
		</div>
	</div>
	<!-- Insertar Modal HTML -->
	<div id="addEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="InsertBien" method="post">
					<div class="modal-header">						
						<h4 class="modal-title">AÑADIR REGISTROS EN BIEN</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>CODIGO:</label>
							<input type="text" id="codeInput" class="form-control" name="code" required>
							<span id="codeError" class="error-message" style="color: red;"></span>
						</div>					
						<div class="form-group">
							<label>DETALLES:</label>
							<input type="text" class="form-control" id="detailInput" name="detail" required>
							<span id="detailError" class="error-message" style="color: red;"></span>
						</div>
						<div class="form-group">
						<label>VALOR LIBRO:</label>
						  <input type="number" class="form-control" id="valueInput" name="value_book" required>
						  <span id="valueError" class="error-message" style="color: red;"></span>
						</div>
						<div class="form-group">
							<label>TIPO DE BIEN (% PORCENTAJE)</label>
							<select class="form-control" name="porcentaje" required>
							<option value="0.20">Vehiculos(camioneta,moto,auto)</option>
						    <option value="0.25">Equipos(laptop,pc,camara,microfono)</option>
						    <option value="0.10">Otros bienes(sillas,escritorios)</option>
						  </select>
						</div>
						<div class="form-group">
							<label>FECHA DE INGRESO:</label>
							<input type="date" class="form-control" name="date_admi" id="ingresoInput"  required>
							<span id="ingresoError" class="error-message" style="color: red;"></span>
						</div>
						<div class="form-group">
							<label>FECHA DE DEPRECIACION:</label>
							<input type="date" class="form-control" id="depreInput" name="depre_admi" required>
							<span id="depreError" class="error-message" style="color: red;"></span>
						</div>							
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
						<input type="submit" class="btn btn-success" value="Agregar">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Alerta Modal Inserción -->
	<div id="alertEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">
						<h4 class="modal-title">SE CREO CORRECTAMENTE EL REGISTRO!!</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<p>¡Hola! 
Felicidades por registrarte. Sigue adelante con tu camino de mejora.</p>
						<p class="text-warning">
							<small>¡Tú puedes lograrlo! !!</small>
						</p>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-success" data-dismiss="modal"
							value="Cerrar">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Editar Modal HTML -->
	<div id="editEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="UpdateBien" method="post">
					<div class="modal-header">
						<h4 class="modal-title">Editar Bienes</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group hidden-cell">
							<label>ID</label>
							<input type="number" id="bienId"
								class="form-control" name="id_contabilidad" readonly>
						</div>
						<div class="form-group hidden-cell">
							<label>IDAdmi</label>
							<input type="number" id="dateId"
								class="form-control" name="id_date" readonly>
						</div>
						<div class="form-group hidden-cell">
							<label>IDDepre</label>
							<input type="number" id="depreId"
								class="form-control" name="id_depre" readonly>
						</div>
						<div class="form-group">
							<label>Codigo:</label>
							<input type="text" id="codeId" class="form-control" name="code" readonly>
						</div>	
						<div class="form-group">
							<label>Detalle:</label>
							<input type="text" id="detailId"
								class="form-control" name="detail" required>
						</div>
						<div class="form-group">
						<label>Valor Libro:</label>
						  <input type="number" id="valueId" class="form-control" name="value_book" readonly>
						</div>
						<div class="form-group">
							<label>Tipo de Bien(Porcentaje):</label>
							<select class="form-control" id="porId" name="porcentaje" required>
							<option value="0.20">Vehiculos(camioneta,moto,auto)</option>
						    <option value="0.25">Equipos(laptop,pc,camaras)</option>
						    <option value="0.10">Otros bienes(sillas,escritorios)</option>
						  </select>
						</div>
						<div class="form-group">
							<label>Fecha de Ingreso:</label>
							<input type="date" class="form-control" id="fdateId" name="date_admi"  required>
							<span id="Error" class="error-message" style="color: red;"></span>
						</div>
						<div class="form-group">
							<label>Fecha de Depreciación:</label>
							<input type="date" class="form-control" id="ddateId" name="depre_admi" required>
						</div>		
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancelar"> <input type="submit"  class="btn btn-info"
							value="Guardar">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Alerta Modal Editar -->
	<div id="alertEditEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">
						<h4 class="modal-title">SE EDITO CORRECTAMENTE EL REGISTRO!!</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<p>¡Muy bien por actualizar tus datos! Cada paso cuenta en tu viaje de mejora. ¡Sigue así!)</p>
						<p class="text-warning">
							<small>¡Se Modificaron los datos correctamente! !!</small>
						</p>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-success" data-dismiss="modal"
							value="Cerrar">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Eliminar Modal HTML -->
	<div id="deleteEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="Delete" method="post">
					<div class="modal-header">
						<h4 class="modal-title">¿Quieres Darme de Baja Que Feo tu corazon?</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<p>¿Estas seguro de cambiar mi estado de registro?</p>
						<p class="text-warning">
							<small>Recuerda que me daras de Baja y ya no volvere</small>
						</p>
						<input type="hidden" id="eliminar"
								class="form-control" name="id" readonly>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancelar"> <input type="submit"
							class="btn btn-danger" value="Aceptar">
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<!-- JS PARA EL ALERT DE EDICIÓN|MODIFICACIÓN -->
	<script>
    $(document).ready(function () {
        // Verifica si hay un atributo 'registroEditado' en la sesión
        <% Boolean registroEditado = (Boolean) request.getSession().getAttribute("registroEditado"); %>
        <% if (registroEditado != null && registroEditado) { %>
            // Si el registroEditado es true, muestra la alerta modal
            $('#alertEditEmployeeModal').modal('show');
            // Limpia el atributo 'registroEditado' de la sesión para evitar mostrar la alerta nuevamente
            <% request.getSession().removeAttribute("registroEditado"); %>
        <% } %>
    });
	</script>

	<!-- JS PARA EL ALERT DE INSERCCIÓN -->
	<script>
    $(document).ready(function () {
        // Verifica si hay un atributo 'registroCreado' en la sesión
        <% Boolean registroCreado = (Boolean) request.getSession().getAttribute("registroCreado"); %>
        <% if (registroCreado != null && registroCreado) { %>
            // Si el registroCreado es true, muestra la alerta modal
            $('#alertEmployeeModal').modal('show');
            // Limpia el atributo 'registroCreado' de la sesión para evitar mostrar la alerta nuevamente
            <% request.getSession().removeAttribute("registroCreado"); %>
        <% } %>
    });
	</script>
	
	<!-- OBTIENE LOS REGISTROS PARA EDITAR -->
	<script>
	$(document).on('click', '.edit', function() {
	    var id = $(this).data('bien');
	    var id_dat = $(this).data('admi');
	    var id_dep = $(this).data('depre');
	    var id_cod = $(this).data('code');
	    var id_det = $(this).data('detail');
	    var id_val = $(this).data('value');
	    var id_por = $(this).data('porcen');
	    var id_adm = $(this).data('admi_fecha');
	    var id_dpc = $(this).data('depre_fecha');
	   
	    $('#bienId').val(id);
	    $('#dateId').val(id_dat);
	    $('#depreId').val(id_dep);
	    $('#codeId').val(id_cod);
	    $('#detailId').val(id_det);
	    $('#valueId').val(id_val);
	    $('#porId').val(id_por);
	    $('#fdateId').val(id_adm);
	    $('#ddateId').val(id_dpc);
	   

	});
	</script>
	<!-- OBTIENE EL ID PARA ELIMINAR -->
	<script >
	$(document).on('click', '.delete', function() {
		var id_client = $(this).data('id');
		$('#eliminar').val(id_client);
	});
	</script>
	
	<!-- VALIDACIONES FORMULARIO INSERT -->
	
	<script>
    document.addEventListener("DOMContentLoaded", function() {
        const codeInput = document.getElementById("codeInput");
        const codeError = document.getElementById("codeError");

        codeInput.addEventListener("input", function() {
            let codeValue = codeInput.value;
            
            // Convertir el texto a mayúsculas
            codeValue = codeValue.toUpperCase();
			
            codeValue = codeValue.toUpperCase();
            
            const isValidCode = /^EQ-\d{3}$/.test(codeValue);

            if (isValidCode) {
                codeError.textContent = "";
            } else {
                codeError.textContent = "El código debe tener dos letras mayúsculas seguidas por un guión y tres dígitos.";
             // Limpiar el contenido del campo si hay minúsculas
                if (codeValue !== codeInput.value) {
                    codeInput.value = "";
                    return;
                }
                if (codeValue.length > 6) {
                    // Si se ingresan más de 6 caracteres, borra el contenido
                    codeInput.value = codeValue.slice(0, 6);
                }
            }
        });
    });
</script>
<script>
    document.addEventListener("DOMContentLoaded", function() {
        const detailInput = document.getElementById("detailInput");
        const detailError = document.getElementById("detailError");

        detailInput.addEventListener("input", function() {
            const detailValue = detailInput.value;

            // Verificar si el detalle contiene solo 15 caracteres entre espacios, números, letras y símbolos
            const isValidDetail = /^[a-zA-Z0-9\s!@#$%^&*()-_+=<>?]{0,30}$/.test(detailValue);

            if (isValidDetail) {
                detailError.textContent = "";
            } else {
                detailError.textContent = "El detalle debe contener hasta 30 caracteres entre espacios, números, letras y símbolos.";
                
                // Limpiar el contenido del campo
                detailInput.value = detailValue.replace(/[^a-zA-Z0-9\s!@#$%^&*()-_+=<>?]/g, '').substring(0, 30);
            }
        });
    });
</script>

<script>
    document.addEventListener("DOMContentLoaded", function() {
        const valueInput = document.getElementById("valueInput");
        const valueError = document.getElementById("valueError");

        valueInput.addEventListener("input", function() {
            const value = parseFloat(valueInput.value);

            if (isNaN(value) || value <= 0) {
                valueError.textContent = "Ingrese un valor válido mayor que cero.";
                valueInput.setCustomValidity("Ingrese un valor válido mayor que cero.");
            } else {
                valueError.textContent = "";
                valueInput.setCustomValidity("");
            }
        });
    });
</script>
<script>
    document.addEventListener("DOMContentLoaded", function() {
        const ingresoInput = document.getElementById("ingresoInput");
        const ingresoError = document.getElementById("ingresoError");

        ingresoInput.addEventListener("input", function() {
            const selectedDate = new Date(ingresoInput.value);
            const currentYear = new Date().getFullYear();

            // Verificar si la fecha seleccionada es del año en curso
            if (selectedDate.getFullYear() !== currentYear) {
                ingresoError.textContent = "Seleccione una fecha del año en curso.";
                ingresoInput.setCustomValidity("Seleccione una fecha del año en curso.");
                
                // Limpiar el contenido del campo
                ingresoInput.value = "";
            } else {
                ingresoError.textContent = "";
                ingresoInput.setCustomValidity("");
            }
        });
    });
</script>	
<script>
    document.addEventListener("DOMContentLoaded", function() {
        const depreInput = document.getElementById("depreInput");
        const depreError = document.getElementById("depreError");

        // Obtener el año actual
        const currentYear = new Date().getFullYear();

        // Establecer la fecha por defecto al último día del año en curso
        const lastDayOfYear = new Date(currentYear, 11, 31); // Meses van de 0 a 11

        // Formatear la fecha al formato esperado por el input date (YYYY-MM-DD)
        const formattedDate = lastDayOfYear.toISOString().split('T')[0];
        depreInput.value = formattedDate;

        depreInput.addEventListener("input", function() {
            const selectedDate = new Date(depreInput.value);

            // Verificar si la fecha seleccionada es después del último día del año en curso
            if (selectedDate > lastDayOfYear) {
                depreError.textContent = "La fecha de depreciación no puede ser después del último día del año en curso.";
                depreInput.setCustomValidity("La fecha de depreciación no puede ser después del último día del año en curso.");
            } else {
                depreError.textContent = "";
                depreInput.setCustomValidity("");
            }
        });
    });
</script>	
	
    <!-- VALIDACIONES FORMULARIO EDIT -->
 
    
    

</body>
</html>