<%@page language="java" contentType="text/html; charset=utf-8"
pageEncoding="UTF-8" %>

<%@include file="../includes/header.jsp"%>
<div class="row-content">
    <div class="card">
        <div class="card-body">
            <div class="card-title">게시판 목록보기</div>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Bno</th>
                    <th scope="col">Title</th>
                    <th scope="col">Author</th>
                    <th scope="col">PostDate</th>
                    <th scope="col">ReadCount</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="board" items="${boardList}">
                <tr>
                    <th scope="row">${board.bno}</th>
                    <td><a href="/board/read?bno=${board.bno}">${board.title}</a></td>
                    <td>${board.author}</td>
                    <td>${board.postdate}</td>
                    <td>${board.readcount}</td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>

<%@include file="../includes/footer.jsp"%>