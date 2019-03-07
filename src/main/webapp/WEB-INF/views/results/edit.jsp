<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../header.jsp" />

<p>Edytuj Wyniki</p>

<form:form method="post" action="/results/edit" modelAttribute="resu">
    Wartość: <form:input path="value"/>
    <form:errors path="value"/>
    Data: <form:input path="date"/>
    <form:errors path="date"/>
    Typ: <form:select path="val.id"
         items="${mvalues}" itemLabel="typ" itemValue="id"/>
    <form:errors path="val"/>
    Jednostka: <form:select path="unt.id"
         items="${uval}" itemLabel="unitName" itemValue="id"/>
    <form:errors path="unt"/>

    <form:hidden path="id"/>
    <input type="submit" value="Edytuj!">
</form:form>

<jsp:include page="../footer.jsp" />