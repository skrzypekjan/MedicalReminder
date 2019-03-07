<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../header.jsp" />
<p>Edytuj wartość</p>
<form:form method="post" action="/medicines/edit" modelAttribute="med">
    <div>
        <p>Nazwa leku: </p>
        <form:input path="medName"/>
        <form:errors path="medName"/>
    </div>
    <div>
        <p>Opis: </p>
        <form:input path="medDescription"/>
        <form:errors path="medDescription"/>
    </div>
    <form:hidden path="id"/>
    <input type="submit" value="Edytuj!">
</form:form>
<jsp:include page="../footer.jsp" />
