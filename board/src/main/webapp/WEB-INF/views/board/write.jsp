<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp" flush="true" />
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<style>
    .fileDrop {
        width:600px;
        height: 200px;
        border: 1px dotted blue;
    }

    small {
        margin-left: 3px;
        font-weight: bold;
        color: gray;
    }
</style>
<script>
    $(document).ready(function(){
        $(".fileDrop").on("dragenter dragover", function(event){
            event.preventDefault(); // 기본효과를 막음
        });
        // event : jQuery의 이벤트
        // originalEvent : javascript의 이벤트
        $(".fileDrop").on("drop", function(event){
            event.preventDefault(); // 기본효과를 막음
            // 드래그된 파일의 정보
            var files = event.originalEvent.dataTransfer.files;
            // 첫번째 파일
            var file = files[0];
            // 콘솔에서 파일정보 확인
            console.log(file);

            // ajax로 전달할 폼 객체
            var formData = new FormData();
            // 폼 객체에 파일추가, append("변수명", 값)
            formData.append("file", file);


            $.ajax({
                type: "post",
                url: "/upload/uploadAjax.do",
                data: formData,
                // processData: true=> get방식, false => post방식
                dataType: "text",
                // contentType: true => application/x-www-form-urlencoded, 
                //                false => multipart/form-data
                processData: false,
                contentType: false,
                success: function(data){
                    alert(data);
                }
            });
        });
    });
</script>
</head>
<body>

<h2>게시글 작성</h2>
<form id="write" name="write" method="post" enctype="multipart/form-data">
    <div>
        제목
        <input type="text" name="title" id="title" size="80" placeholder="제목을 입력해주세요">
    </div>
    <div>
        내용
        <textarea name="content" id="content" rows="4" cols="80" placeholder="내용을 입력해주세요"></textarea>
    </div>
    <div>
        이름
        <input type="text" name="writer" id="writer" value="${sessionScope.user_id}" readOnly>
    </div>
    
        <!-- 파일을 업로드할 영역 -->
    <div class="fileDrop"></div>
    <!-- 업로드된 파일 목록 -->
    <div class="uploadedList"></div>  
    
    <div style="width:650px; text-align: center;">
        <button type="button" id="btnSave">확인</button>
        <button type="button" onclick="location.href='/board/list.do'">취소</button>
    </div>
</form>
</body>
</html>