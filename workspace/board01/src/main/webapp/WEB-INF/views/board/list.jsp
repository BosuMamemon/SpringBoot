<%@page language="java" contentType="text/html; charset=utf-8"
        pageEncoding="utf-8"
%>
<%@include file="../includes/header.jsp"%>
    <div class="card">
        <div class="card-body">
            <div class="card-title"><h3>게시판 목록보기</h3></div>
            <br>
            <table class="table table-light table-striped table-hover">
                <thead>
                    <tr>
                        <th scope="col">Bno</th>
                        <th scope="col">Title</th>
                        <th scope="col">Author</th>
                        <th scope="col">Post Date</th>
                        <th scope="col">Read Count</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${bList}" var="board">
                        <tr>
                            <td>${board.bno}</td>
                            <td><a href="/board/read?bno=${board.bno}">${board.title}</a></td>
                            <td>${board.author}</td>
                            <td><fmt:formatDate value="${board.postdate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                            <td>${board.readcount}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
<%@include file="../includes/footer.jsp"%>