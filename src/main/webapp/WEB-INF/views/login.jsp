<jsp:include page="header.jsp"></jsp:include>
<!--/breadcrumbs -->
<div class="w3l-breadcrumbs">
    <nav id="breadcrumbs" class="breadcrumbs">
        <div class="container page-wrapper">
            <a href="/">Home</a> » <span class="breadcrumb_last" aria-current="page">Login</span>
        </div>
    </nav>
</div>
<!--//breadcrumbs -->
<!-- contact1 -->
<section class="w3l-contact-1">
    <div class="contacts-9 py-5">
        <div class="container py-lg-4">
            <div class="headerhny-title text-center">
                <h4 class="sub-title text-center">Login us</h4>
                <h3 class="hny-title mb-0">Welcome to Book My Show</h3>                
            </div>
            
                           <center>             
  <div class="wrapper" style="">
    <div class="title-text">
      <div class="title login">
        Login Form
      </div>
      <div class="title signup">
        Signup Form
      </div>
    </div>
    <div class="form-container">
      <div class="form-inner">
        <form method="post" class="formhny-sec">
          <div class="field">
            <input type="text" placeholder="Email Address" name="userid" id="w3lName" required>
          </div>
          <div class="field">
            <input type="password" placeholder="Password"  name="pwd" id="w3lName" required>
          </div>
          <div class="field btn">
            <div class="btn-layer"></div>
            <input type="submit" value="Login">
          </div>
          <div class="signup-link">
            Not a member? <a href="/register">Signup now</a>
          </div>
        </form>
        
      </div>
    </div>
  </div>
                    <jsp:include page="msg.jsp"></jsp:include>
                </div>
            </div>
        </div>
    </div>
</section>
</center>
<!-- /contact1 -->
<jsp:include page="footer.jsp"></jsp:include>


<script type="text/javascript">
const loginText = document.querySelector(".title-text .login");
const loginForm = document.querySelector("form.login");
const loginBtn = document.querySelector("label.login");
const signupBtn = document.querySelector("label.signup");
const signupLink = document.querySelector("form .signup-link a");
signupBtn.onclick = (() => {
  loginForm.style.marginLeft = "-50%";
  loginText.style.marginLeft = "-50%";
});
loginBtn.onclick = (() => {
  loginForm.style.marginLeft = "0%";
  loginText.style.marginLeft = "0%";
});
signupLink.onclick = (() => {
  signupBtn.click();
  return false;
});
</script>