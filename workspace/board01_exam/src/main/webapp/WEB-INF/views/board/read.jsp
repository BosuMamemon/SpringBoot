<%@page language="java" contentType="text/html; charset=utf-8"
pageEncoding="UTF-8" %>
<%@include file="../includes/header.jsp"%>
<div class="row-content">
    <div class="card">
        <div class="card-body">
            <div class="card-title">게시글 등록</div>
<%--            <form method="post" action="/board/register">--%>
            <div class="mb-3">
                <label for="bno" class="form-label">Bno</label>
                <input type="text" class="form-control" name="bno" id="bno" value="${board.bno}">
            </div>
                <div class="mb-3">
                    <label for="title" class="form-label">Title</label>
                    <input type="text" class="form-control" name="title" id="title" value="${board.title}">
                </div>
                <div class="mb-3">
                    <label for="content" class="form-label">Content</label>
                    <textarea class="form-control" name="content" id="content" rows="3">${board.content}</textarea>
                </div>
                <div class="mb-3">
                    <label for="author" class="form-label">Author</label>
                    <input type="text" class="form-control" name="author" id="author" value="${board.author}">
                </div>
            <div class="mb-3">
                <label for="postdate" class="form-label">PostDate</label>
                <input type="text" class="form-control" name="postdate" id="postdate" value="${board.postdate}">
            </div>
            <div class="mb-3">
                <label for="readcount" class="form-label">ReadCount</label>
                <input type="text" class="form-control" name="readcount" id="readcount" value="${board.readcount}">
            </div>
                <button type="button" class="btn btn-primary"
                        onclick="location.href='/board/modify?bno=${board.bno}'">Modify</button>
                <button type="button" class="btn btn-danger"
                        onclick="location.href='/board/remove?bnp=${board.bno}'">Remove</button>
                <button type="button" class="btn btn-secondary"
                        onclick="location.href='board/list'">List</button>
        </div>
        <script
                src="https://code.jquery.com/jquery-3.7.1.min.js"
                integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
                crossorigin="anonymous"></script>
        <%--            </form>--%>
<%--        <script>--%>
<%--            document.querySelector(".btn-primary").addEventListener("click",function (e){--%>
<%--                self.location=`/board/modify?bno=${board.bno}`--%>
<%--            })--%>
<%--            document.querySelector(".btn-danger").addEventListener("click",function (e){--%>
<%--                self.location=`/board/remove?bno=${board.bno}`--%>
<%--            })--%>
<%--            document.querySelector(".btn-secondary").addEventListener("click",function (e){--%>
<%--                self.location="/board/list"--%>
<%--            })--%>
<%--        </script>--%>

    </div>
</div>
<%@include file="../includes/footer.jsp"%>