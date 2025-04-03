<%@page language="java" contentType="text/html; charset=utf-8"
        pageEncoding="utf-8"
%>
<%@include file="../includes/header.jsp"%>
    <div class="card">
        <div class="card-body">
            <div class="card-title"><h3>게시글 확인</h3></div>
            <br>
            <input type="hidden" name="bno" value="${board.bno}">
            <div class="mb-3">
                <label for="title" class="form-label">Title</label>
                <input type="text" class="form-control" id="title" name="title" value="${board.title}" readonly>
            </div>
            <div class="mb-3">
                <label for="author" class="form-label">Author</label>
                <input type="text" class="form-control" id="author" name="author" value="${board.author}" readonly>
            </div>
            <div class="mb-3">
                <label for="postdate" class="form-label">Post Date</label>
                <input type="text" class="form-control" id="postdate" name="postdate" value="${board.postdate}" readonly>
            </div>
            <div class="mb-3">
                <label for="readcount" class="form-label">Read Count</label>
                <input type="text" class="form-control" id="readcount" name="readcount" value="${board.readcount}" readonly>
            </div>
            <div class="mb-3">
                <label for="content" class="form-label">Content</label>
                <textarea class="form-control" id="content" name="content" rows="3" readonly>${board.content}</textarea>
            </div>
            <button type="button" class="btn btn-primary">수정</button>
            <button type="button" class="btn btn-secondary">뒤로</button>
        </div>
    </div>
<%@include file="../includes/footer.jsp"%>
