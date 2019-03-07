<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../header.jsp" />
<h1>Dodaj poziom cukru</h1>
<form:form method="post" modelAttribute="gluc">
    <div>
        <p>Wartość: </p>
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
    <div>
        <input type="submit" value="Zapisz" class="btn btn-light btn-icon-split">
    </div>
</form:form>
<a href="/" class="btn btn-secondary btn-icon-split">
                    <span class="icon text-white-50">
                      <i class="fas fa-arrow-right"></i>
                    </span>
    <span class="text">Strona główna</span>
</a>
<jsp:include page="../footer.jsp" />