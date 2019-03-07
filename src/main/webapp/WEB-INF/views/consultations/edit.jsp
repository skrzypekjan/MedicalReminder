<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../header.jsp" />
<p>Edytuj Konsultację</p>
<form:form method="post" action="/consultations/edit" modelAttribute="cons">
    Nazwa: <form:input path="name" />
    <form:errors path="name"/>
    Opis: <form:input path="description" />
    <form:errors path="description"/>
    Data: <form:input path="date" />
    <form:errors path="date"/>
    <form:hidden path="id"/>
    <input type="submit" value="Edytuj!">
</form:form>
<jsp:include page="../footer.jsp" />
