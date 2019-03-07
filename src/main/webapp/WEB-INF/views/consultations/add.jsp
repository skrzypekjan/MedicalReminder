<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../header.jsp" />
<h1>Dodaj Konsultację</h1>

<form:form method="post" modelAttribute="cons">
    <div>
        <p>Nazwa: </p>
        <form:input path="name"/>
        <form:errors path="name"/>
    </div>
    <div>
        <p>Opis: </p>
    <form:input path="description"/>
    <form:errors path="description"/>
    </div>
    <div>
        <p>Data: </p>
    <form:input path="date"/>
    <form:errors path="date"/>
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