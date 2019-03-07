<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../header.jsp" />
<p>Edytuj wartość</p>
<form:form method="post" action="/glucometer/edit" modelAttribute="gluc">
    <div>
        <p>Nazwa: </p>
        <form:input path="valSugar"/>
        <form:errors path="valSugar"/>
    </div>
    <div>
        <p>Data: </p>
        <form:input path="dates"/>
        <form:errors path="dates"/>
    </div>
    <div>
        <p>Czas: </p>
        <form:input path="time"/>
        <form:errors path="time"/>
    </div>
    <form:hidden path="id"/>
    <input type="submit" value="Edytuj!">
</form:form>
<jsp:include page="../footer.jsp" />
