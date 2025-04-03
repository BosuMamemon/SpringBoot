<%@page language="java" contentType="text/html; charset=utf-8"
pageEncoding="UTF-8" %>
<%@include file="../includes/header.jsp"%>
<div class="row-content">
    <div class="card">
        <div class="card-body">
            <div class="card-title">게시글 등록</div>
            <form method="post" action="/board/register">
                <div class="mb-3">
                    <label for="title" class="form-label">Title</label>
                    <input type="text" class="form-control" name="title" id="title" placeholder="제목을 입력하세요">
                </div>
                <div class="mb-3">
                    <label for="content" class="form-label">Content</label>
                    <textarea class="form-control" name="content" id="content" rows="3"></textarea>
                </div>
                <div class="mb-3">
                    <label for="author" class="form-label">Author</label>
                    <input type="text" class="form-control" name="author" id="author" placeholder="작성자 입력">
                </div>
                <button type="submit" class="btn btn-outline-primary">Register</button>
                <button type="reset" class="btn btn-outline-secondary">Reset</button>
            </form>
        </div>
    </div>
</div>
<%@include file="../includes/footer.jsp"%>