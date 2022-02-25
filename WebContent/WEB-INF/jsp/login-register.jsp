<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>登录和注册页面切换js特效 www.bootstrapmb.com</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/normalize.min.css">
<link href="${pageContext.request.contextPath}/css/style.css"
	   type=text/css rel=stylesheet>
<script src=
       "${pageContext.request.contextPath}/js/jquery-1.11.3.min.js">
</script>
<script>
// 判断是登录账号和密码是否为空
function check(){
    var usercode = $("#usercode").val();
    var password = $("#password").val();
    if(usercode=="" || password==""){
    	$("#message").text("账号或密码不能为空！");
        return false;
    }  
    return true;
}
</script>
</head>
<body>
<!-- partial:index.partial.html -->
<div class="container right-panel-active">
			<!-- Sign Up -->
			<div class="container__form container--signup">
				<form action="#" class="form" id="form1">
					<h2 class="form__title">注 册</h2>
					<input type="text" placeholder="用户名" class="input" />
					<input type="email" placeholder="Email" class="input" />
                    <input type="password" placeholder="密码" class="input" />
					<button class="btn">注 册</button>
				</form>
			</div>

			<!-- Sign In -->
			<div class="container__form container--signin">
			
				<form action="${pageContext.request.contextPath}/logincheck.action"  class="form" id="form2" 
			                       method="post">
					<h2 class="form__title">登 录</h2>
					<input id="name" name="name" type="text"  placeholder="用户名" class="input" />
					<input id="pass" name="pass" type="password" placeholder="密码" class="input" />
					<a href="#" class="link">忘记密码?</a>
					
					<input class="btn" type="submit" value="登录" />
				
				 
				</form>
				
				
			</div>

			<!-- Overlay -->
			<div class="container__overlay">
				<div class="overlay">
					<div class="overlay__panel overlay--left">
						<button class="btn" id="signIn">登 录</button>
					</div>
					<div class="overlay__panel overlay--right">
						<button class="btn" id="signUp">注 册</button>
					</div>
				</div>
			</div>
		</div>
<!-- partial -->
  <script  src="${pageContext.request.contextPath}/js/script.js"></script>
 
</body>
</html>
