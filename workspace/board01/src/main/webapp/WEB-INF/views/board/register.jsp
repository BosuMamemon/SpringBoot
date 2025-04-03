<%@page language="java" contentType="text/html; charset=utf-8"
        pageEncoding="utf-8"
%>
<%@include file="../includes/header.jsp"%>
    <div class="card">
        <div class="card-body">
            <div class="card-title"><h3>게시글 등록</h3></div>
            <br>
            <form action="/board/register" method="post">
                <div class="mb-3">
                    <label for="title" class="form-label">Title</label>
                    <input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하세요.">
                </div>
                <div class="mb-3">
                    <label for="content" class="form-label">Content</label>
                    <textarea class="form-control" id="content" name="content" rows="3" placeholder="내용을 입력하세요."></textarea>
                </div>
                <div class="mb-3">
                    <label for="author" class="form-label">Author</label>
                    <input type="text" class="form-control" id="author" name="author" placeholder="작성자를 입력하세요.">
                </div>
                <button type="submit" class="btn btn-primary">작성</button>
                <button type="reset" class="btn btn-secondary">취소</button>
            </form>
        </div>
    </div>
<%@include file="../includes/footer.jsp"%>
