<html>
<head>
<title>get </title>
</head>
<body>

<p id="name"> </p>
<p id="brand"></p>
<p id="perhour"></p>
<img id="image" src="" width="250" height="250" />
<script>
fetch("/senddata")
.then((response)=>{response.json().then(
               (res) =>
                     {

                     document.getElementById("name").innerHTML="name:"+res["name"];
                     console.log(name)
                     console.log(res["name"])
                     document.getElementById("brand").innerHTML="brand:"+res["brand"];
                     document.getElementById("perhour").innerHTML="perhour:"+res["perhour"];
                     document.getElementById("image").src="image/"+res.file.filename;

                     }
                     )
                });
</script>
</body>
</html>