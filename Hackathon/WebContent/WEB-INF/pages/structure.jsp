<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<select class="form-control">
     <c:forEach items="${strucModel.ColumnList}" var="ColumnItem">
		<option value="${ColumnItem}">${ColumnItem}</option>
	</c:forEach>
</select>