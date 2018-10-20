<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.*" %>


<div class="form-horizontal">
<div class="container">
	<div class="row">
        <div class="col-md-6">
                <div class="input-group col-md-12">
                <form:form method="POST" action="${pageContext.request.contextPath}/search/secureemployeesearch" modelAttribute="esearch">
                    <form:input type="text" class="form-control" placeholder="Search Employees (Name/Employee ID)" path="search"/>
                    <span class="input-group-btn">
                        <input type="submit" value="Search" class="btn btn-default" />
                    </span>
                </form:form>
                </div>
        </div>
	</div>
</div>
<form:form method="POST" action="${pageContext.request.contextPath}/employee/updateemployee" modelAttribute="wrapper">
<table class="table">
		<thead>
			<tr>
				<th>Name</th>
				<th>Phone #</th>
				<th>Email</th>
				<th>Employee ID</th>
				<th>Admin</th>
				<th>Active</th>
				<th>Terminated</th>
				<th>Action</th>
			</tr>
		</thead>


<c:forEach items="${wrapper.employees}" var="employee" varStatus="status">

		<tbody>
		<c:choose>
				<c:when test="${employee.employeeid == id}">
				
				</c:when>
				<c:otherwise>
				<tr>
				<td>${employee.firstName} ${employee.lastName}</td>
				<td>${employee.phone}</td>
				<td>${employee.email}</td>
				<td>${employee.employeeid}</td>
				<td>

					<form:select cssClass="form-control text-body" path="employees[${status.index}].admin" value="employees[${status.index}].admin" id="adminoptions">
						<form:option value="0" label="No" />
						<form:option value="1" label="Yes" />
					</form:select>
					</td>
					<td>

					<form:select cssClass="form-control text-body" path="employees[${status.index}].active" value="employees[${status.index}].active" id="activeoptions">
						<form:option value="0" label="No" />
						<form:option value="1" label="Yes" />
					</form:select>
					</td>
					<td>
					
					<form:select cssClass="form-control text-body" path="employees[${status.index}].terminated" value="employees[${status.index}].terminated" id="terminatedoptions">
						<form:option value="0" label="No" />
						<form:option value="1" label="Yes" />
					</form:select>
					
					</td>
					<td>
					<a href="<c:url value="/employee/remove?id=${employee.employeeid}" />" class="btn btn-default">Delete</a>
					</td>
					<form:hidden path="employees[${status.index}].employeeid" value="${employee.employeeid}" />

				</tr>
				</c:otherwise>
		</c:choose> 
			
		</tbody>
</c:forEach>
</table>
	<div class="form-group">
		<div class="col-md-10">
			<input type="submit" value="Update Employees" class="btn btn-default" />
		</div>
	</div>
</form:form>
</div>



