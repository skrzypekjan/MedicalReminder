<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../header.jsp"/>
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Wyniki</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>Wartość</th>
                    <th>Data</th>
                    <th>Typ</th>
                    <th>Minimalna wartość</th>
                    <th>Maksymalna wartość</th>
                    <th>Jednostka</th>
                    <th>Edycja</th>
                    <th>Usuwanie</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>Wartość</th>
                    <th>Data</th>
                    <th>Typ</th>
                    <th>Minimalna wartość</th>
                    <th>Maksymalna wartość</th>
                    <th>Jednostka</th>
                    <th>Edycja</th>
                    <th>Usuwanie</th>
                </tr>
                </tfoot>
                <tbody>
                <c:forEach items="${resul}" var="res">
                    <tr>
                        <th>${res.value}</th>
                        <th>${res.date}</th>
                        <th>${res.val.typ}</th>
                        <th>${res.val.min}</th>
                        <th>${res.val.max}</th>
                        <th>${res.unt.unitName}</th>
                        <th>
                            <a href="/results/edit/${res.id}" class="btn btn-warning btn-icon-split">
                                <span class="icon text-white-50">
                                    <i class="fas fa-exclamation-triangle"></i>
                                </span>
                                <span class="text">Edytuj</span>
                            </a>
                        </th>
                        <th>
                            <a href="/results/remove/${res.id}" class="btn btn-danger btn-icon-split">
                                <span class="icon text-white-50">
                                    <i class="fas fa-trash"></i>
                                </span>
                                <span class="text">Usuń</span>
                            </a>
                        </th>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a href="/" class="btn btn-secondary btn-icon-split">
                    <span class="icon text-white-50">
                      <i class="fas fa-arrow-right"></i>
                    </span>
                <span class="text">Strona główna</span>
            </a>
            <div class="my-2"></div>
            <a href="/results/add" class="btn btn-light btn-icon-split">
                    <span class="icon text-gray-600">
                      <i class="fas fa-arrow-right"></i>
                    </span>
                <span class="text">Dodaj wynik</span>
            </a>
<jsp:include page="../footer.jsp"/>