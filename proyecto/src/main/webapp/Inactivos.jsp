<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bienes Bajos</title>
<link rel="icon" href="img/restore.png" type="image/png">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body {
    color: #333;
    background: #f0f0f0;
    font-family: 'Arial', sans-serif;
    font-size: 14px;
}

.table-responsive {
    margin: 20px 0;
}

.table-wrapper {
    min-width: 1000px;
    background: #fff;
    padding: 20px 25px;
    border-radius: 5px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, .1);
}

.table-title {
    padding-bottom: 15px;
    background: #4CAF50;
    color: #fff;
    padding: 16px 30px;
    border-radius: 5px 5px 0 0;
}

.table-title h2 {
    margin: 5px 0 0;
    font-size: 24px;
}

.table-title .btn-group {
    float: right;
}

.table-title .btn {
    color: #fff;
    float: right;
    font-size: 13px;
    border: none;
    min-width: 50px;
    border-radius: 3px;
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

table.table tr th, table.table tr td {
    border-color: #ddd;
    padding: 12px 15px;
    vertical-align: middle;
}

table.table tr th:first-child {
    width: 60px;
}

table.table tr th:last-child {
    width: 100px;
}

table.table-striped tbody tr:nth-of-type(odd) {
    background-color: #f9f9f9;
}

table.table-striped.table-hover tbody tr:hover {
    background: #e0f7fa;
}

table.table th i {
    font-size: 14px;
    margin: 0 5px;
    cursor: pointer;
}

table.table td:last-child i {
    opacity: 0.9;
    font-size: 18px;
    margin: 0 5px;
}

table.table td a {
    font-weight: bold;
    color: #3498db;
    display: inline-block;
    text-decoration: none;
    outline: none !important;
}

table.table td a:hover {
    color: #2079b0;
}

table.table td a.edit {
    color: #FFC107;
}

table.table td a.delete {
    color: #F44336;
}

table.table td i {
    font-size: 16px;
}

table.table .avatar {
    border-radius: 50%;
    vertical-align: middle;
    margin-right: 10px;
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
    color: #999;
    margin: 0 2px;
    line-height: 30px;
    border-radius: 3px !important;
    text-align: center;
    padding: 0 8px;
}

.pagination li a:hover {
    color: #666;
}

.pagination li.active a, .pagination li.active a.page-link {
    background: #4CAF50;
    color: #fff;
    border: 1px solid #4CAF50;
}

.pagination li.active a:hover {
    background: #45a049;
    border: 1px solid #45a049;
}

.pagination li.disabled i {
    color: #ccc;
}

.pagination li i {
    font-size: 18px;
    padding-top: 6px;
}

.hint-text {
    float: left;
    margin-top: 10px;
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
    width: 18px;
    height: 18px;
    content: '';
    margin-right: 10px;
    display: inline-block;
    vertical-align: text-top;
    background: #fff;
    border: 1px solid #bbb;
    border-radius: 3px;
    box-sizing: border-box;
    z-index: 2;
}

.custom-checkbox input[type="checkbox"]:checked+label:after {
    content: '';
    position: absolute;
    left: 6px;
    top: 3px;
    width: 6px;
    height: 11px;
    border: solid #000;
    border-width: 0 3px 3px 0;
    transform: inherit;
    z-index: 3;
    transform: rotateZ(45deg);
}

.custom-checkbox input[type="checkbox"]:checked+label:before {
    border-color: #4CAF50;
    background: #4CAF50;
}

.custom-checkbox input[type="checkbox"]:checked+label:after {
    border-color: #fff;
}

.custom-checkbox input[type="checkbox"]:disabled+label:before {
    color: #b8b8b8;
    cursor: auto;
    box-shadow: none;
    background: #ddd;
}
/* Modal styles */
.modal .modal-dialog {
    max-width: 400px;
}

.modal .modal-header, .modal .modal-body, .modal .modal-footer {
    padding: 20px 30px;
}

.modal .modal-content {
    border-radius: 3px;
}

.modal .modal-footer {
    background: #ecf0f1;
    border-radius: 0 0 3px 3px;
}

.modal .modal-title {
    display: inline-block;
}

.modal .form-control {
    border-radius: 3px;
    box-shadow: none;
    border-color: #ddd;
}

.modal textarea.form-control {
    resize: vertical;
}

.modal .btn {
    border-radius: 3px;
    min-width: 100px;
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
    <form action="SearchBienInactive" method="get">
        <div style="display: flex; justify-content: space-between;">
            <input type="text" name="detail" id="form1" class="form-control" placeholder="Buscar por Detalle de Bienes" aria-label="Search" value="${param.detail}"/><br>
            <input type="text" name="code" id="form1" class="form-control" placeholder="Buscar por Código" aria-label="Search" value="${param.code}"/><br>
        </div>
        <input class="btn btn-primary" type="submit" value="Buscar">
    </form>
</div>


		<div class="table-responsive">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<div class="col-xs-6">
							<h2>
								Gestión de <b>Bienes</b>
							</h2>
						</div>
						<div class="col-xs-6">
							<a class="btn btn-warning"
								href="Listar" role="button">Tipo Alta</a>
						<div class="btn-group">
        					<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
            					Descargar <span class="caret"></span>
        					</button>
        						<ul class="dropdown-menu" role="menu">
            					<li><a href="DescargarDatos?exportType=csv">DESCARGA EN CSV</a></li>
            					<li><a href="DescargarDatos?exportType=xls">DESCARGA EN XLS</a></li>
            					<li><a href="DescargarDatos?exportType=pdf">DESCARGA EN PDF</a></li>
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
							<th>Fecha Deprecion</th>
							<th>D.Anual</th>
							<th>D.Semanal</th>
							<th>D.Acumlada.</th>
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
									<td>
										<a href="#deleteEmployeeModal" class="restore"
										data-toggle="modal" data-id="${bien.id_contabilidad}"><i
											class="material-icons" data-toggle="tooltip" title="Cambiar Estado">undo</i></a>
									</td>
								</tr>
						</c:forEach>
					</tbody>
				</table>

			
			</div>
		</div>
	</div>
	<!-- Restaurar Modal HTML -->
	<div id="deleteEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="Restore" method="post">
					<div class="modal-header">
						<h4 class="modal-title">Cambiar Estado de Registro</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<p>¿Está seguro de cambiar el estado de este registro?</p>
						<p class="text-warning">
							<small>Recuerda que el bien será de tipo Alta</small>
						</p>
						<input type="hidden" id="restaurarId" class="form-control"
							name="id" readonly>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancelar"> <input type="submit"
							class="btn btn-success" value="Aceptar">
					</div>
				</form>
			</div>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<!-- OBTIENE EL ID PARA ELIMINAR -->
	<script>
		$(document).on('click', '.restore', function() {
			var id = $(this).data('id');
			$('#restaurarId').val(id);
		});
	</script>

</body>
</html>