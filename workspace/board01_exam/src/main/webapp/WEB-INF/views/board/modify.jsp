<%@page language="java" contentType="text/html; charset=utf-8"
pageEncoding="UTF-8" %>
<%@include file="../includes/header.jsp"%>
<div class="row-content">
    <div class="card">
        <div class="card-body">
            <div class="card-title">게시글 수정</div>
            <form method="post" action="/board/modify">
                <input type="hidden" name="bno" value="${board.bno}">
                <div class="mb-3">
                    <label for="title" class="form-label">Title</label>
                    <input type="text" class="form-control" name="title"
                           id="title" value="${board.title}">
                </div>
                <div class="mb-3">
                    <label for="content" class="form-label">Content</label>
                    <textarea class="form-control" name="content"
                              id="content" rows="3">
                        ${board.content}
                    </textarea>
                </div>
                <div class="mb-3">
                    <label for="author" class="form-label">Author</label>
                    <input type="text" class="form-control" name="author"
                           id="author" value="${board.author}">
                </div>
                <button type="submit" class="btn btn-outline-primary">Modify</button>
                <button type="button" class="btn btn-outline-secondary">Read</button>
            </form>
            <script>
                document.querySelector(".btn-outline-secondary")
                    .addEventListener("click",function(e){
                        self.location=`/board/read?bno=${board.bno}`
                    })
            </script>
        </div>
    </div>
</div>
<%@include file="../includes/footer.jsp"%>