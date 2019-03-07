<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../header.jsp" />
<h1>Dodaj Wynik</h1>
<form:form method="post" modelAttribute="resu">
    <div>
        <p>Wartość: </p>
        <form:input path="value"/>
        <form:errors path="value"/>
    </div>
    <div>
        <p>Data: </p>
    <form:input path="date"/>
    <form:errors path="date"/>
    </div>
    <div>
        <p>Typ: </p>
        <form:select path="val.id"
                     items="${mvalues}" itemLabel="typ" itemValue="id"/>
        <form:errors path="val"/>
    </div>
    <div>
        <p>Jednostka: </p>
        <form:select path="unt.id"
                     items="${uval}" itemLabel="unitName" itemValue="id"/>
        <form:errors path="unt"/>
    </div>
    <form:hidden path="id"/>
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