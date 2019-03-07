<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../header.jsp"/>
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Konsultacje lekarskie</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>Nazwa</th>
                    <th>Opis</th>
                    <th>Data</th>
                    <th>Edycja</th>
                    <th>Usuwanie</th>
                </tr>
                </thead>
                <tfoot>
                    <th>Nazwa</th>
                    <th>Opis</th>
                    <th>Data</th>
                    <th>Edycja</th>
                    <th>Usuwanie</th>
                </tfoot>
                <tbody>
                <c:forEach items="${cons}" var="con">
                    <tr>
                        <th>${con.name}</th>
                        <th>${con.description}</th>
                        <th>${con.date}</th>
                        <th>
                            <a href="/consultations/edit/${con.id}" class="btn btn-warning btn-icon-split">
                                <span class="icon text-white-50">
                                    <i class="fas fa-exclamation-triangle"></i>
                                </span>
                                <span class="text">Edytuj</span>
                            </a>
                        </th>
                        <th>
                            <a href="/consultations/remove/${con.id}" class="btn btn-danger btn-icon-split">
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
            <a href="/consultations/add" class="btn btn-light btn-icon-split">
                    <span class="icon text-gray-600">
                      <i class="fas fa-arrow-right"></i>
                    </span>
                <span class="text">Dodaj Konsultację</span>
            </a>

            <link href='https://fonts.googleapis.com/css?family=Ubuntu:400,500,700' rel='stylesheet' type='text/css'>

            <table>
                <tr>
                    <th class="day-name">Sun</th>
                    <th class="day-name">Mon</th>
                    <th class="day-name">Tue</th>
                    <th class="day-name">Wed</th>
                    <th class="day-name">Thu</th>
                    <th class="day-name">Fri</th>
                    <th class="day-name">Sat</th>
                </tr>
                <tr>
                    <td class="day"><span class="number">31</span></td>
                    <td class="day"><span class="number">1</span><span class="event"></span><span class="event"></span></td>
                    <td class="day"><span class="number">2</span></td>
                    <td class="day"><span class="number">3</span><span class="event event-multiday-start"></span></td>
                    <td class="day"><span class="number">4</span><span class="event event-multiday"></span><span class="event event-multiday-start eventclass" style="background-color:#5a9ab2;"></span><span class="event"></td>
                    <td class="day"><span class="number">5</span><span class="event event-multiday-finish"></span><span class="event event-multiday eventclass" style="background-color:#5a9ab2;"></span></td>
                    <td class="day"><span class="number">6</span><span class="event event-ghost"></span><span class="event event-multiday-finish eventclass" style="background-color:#5a9ab2;"></span></td>
                </tr>
                <tr>
                    <td class="day"><span class="number">7</span></td>
                    <td class="day"><span class="number">8</span><span class="event"></span></td>
                    <td class="day"><span class="number">9</span></td>
                    <td class="day"><span class="number">10</span></td>
                    <td class="day"><span class="number">11</span></td>
                    <td class="day"><span class="number">12</span></td>
                    <td class="day"><span class="number">13</span></td>
                </tr>
                <tr>
                    <td class="day"><span class="number">14</span></td>
                    <td class="day"><span class="number">15</span></td>
                    <td class="day"><span class="number">16</span><span class="event"></span></td>
                    <td class="day"><span class="number">17</span><span class="event"></span></td>
                    <td class="day"><span class="number">18</span></td>
                    <td class="day"><span class="number">19</span></td>
                    <td class="day"><span class="number">20</span></td>
                </tr>
                <tr>
                    <td class="day"><span class="number">21</span></td>
                    <td class="day"><span class="number">22</span></td>
                    <td class="day"><span class="number">23</span></td>
                    <td class="day"><span class="number">24</span></td>
                    <td class="day"><span class="number">25</span></td>
                    <td class="day"><span class="number">26</span></td>
                    <td class="day"><span class="number">27</span><span class="event event-multiday-start" style="background-color:#da5f5f;"></td>
                </tr>
                <tr>
                    <td class="day"><span class="number">28</span><span class="event event-multiday" style="background-color:#da5f5f;"></td>
                    <td class="day today"><span class="number">29</span><span class="event event-multiday-finish" style="background-color:#da5f5f;"></td>
                    <td class="day"><span class="number">30</span></td>
                    <td class="day"><span class="number">1</span></td>
                    <td class="day"><span class="number">2</span></td>
                    <td class="day"><span class="number">3</span></td>
                    <td class="day"><span class="number">4</span></td>
                </tr>
                <tr>
                    <td class="day"><span class="number">5</span></td>
                    <td class="day"><span class="number">6</span><span class="event"></span></td>
                    <td class="day"><span class="number">7</span></td>
                    <td class="day"><span class="number">8</span></td>
                    <td class="day"><span class="number">9</span></td>
                    <td class="day"><span class="number">10</span></td>
                    <td class="day"><span class="number">11</span></td>
                </tr>
            </table>
<jsp:include page="../footer.jsp"/>