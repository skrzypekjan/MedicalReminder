<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../header.jsp"/>
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Poziom cukru</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>Nazwa</th>
                    <th>Czas</th>
                    <th>Data</th>
                    <th>Edycja</th>
                    <th>Usuwanie</th>
                </tr>
                </thead>
                <tfoot>
                    <th>Nazwa</th>
                    <th>Czas</th>
                    <th>Data</th>
                    <th>Edycja</th>
                    <th>Usuwanie</th>
                </tfoot>
                <tbody>
                <c:forEach items="${gluc}" var="con">
                    <tr>
                        <th>${con.valSugar}</th>
                        <th>${con.time}</th>
                        <th>${con.dates}</th>
                        <th>
                            <a href="/glucometer/edit/${con.id}" class="btn btn-warning btn-icon-split">
                                <span class="icon text-white-50">
                                    <i class="fas fa-exclamation-triangle"></i>
                                </span>
                                <span class="text">Edytuj</span>
                            </a>
                        </th>
                        <th>
                            <a href="/glucometer/remove/${con.id}" class="btn btn-danger btn-icon-split">
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
            <a href="/glucometer/add" class="btn btn-light btn-icon-split">
                    <span class="icon text-gray-600">
                      <i class="fas fa-arrow-right"></i>
                    </span>
                <span class="text">Dodaj poziom cukru</span>
            </a>
<jsp:include page="../footer.jsp"/>