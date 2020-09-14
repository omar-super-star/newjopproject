<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>hi</title>
	</head>
	<body>
	   <input type="text" name="name" id="name" />
	   <input type="text" name="brand" id="age" />
	   <input type="text" name="perhour" id="ph"/>
	   <input type="file" name="file" id="file" />
	   <input type="submit" id="ok"/>
	<script>
	var sub=document.getElementById("ok");
	sub.onclick=()=>{
	     var name=document.getElementById("name");
         var age=document.getElementById("age");
         var ph=document.getElementById("ph");
         var file=document.getElementById("file");
         console.log(file.files[0])
         var data = new FormData();
	     data.append("name",name.value);
	     data.append("brand",age.value);
	     data.append("perhour",ph.value);
	     data.append("file",file.files[0]);
	     data.append("user",data)
	     console.log(data);
	     fetch("/course",{
                 method:"POST",
                 //headers:{
                      //"Content-Type":"multipart/form-data",
                 //},
                 body:data
                 })
                 .then((response)=>{response.json().then((res) => {
                 console.log(res)
                 window.location.href="http://localhost:8000/data"
                 })
            })
            }
	</script>
	</body>
</html>