<jsp:include page="header.jsp"></jsp:include>
<!--/breadcrumbs -->
<div class="w3l-breadcrumbs">
	<nav id="breadcrumbs" class="breadcrumbs">
		<div class="container page-wrapper">
			<a href="/">Home</a> » <span class="breadcrumb_last"
				aria-current="page">Register</span>
		</div>
	</nav>
</div>
<!--//breadcrumbs -->
<!-- contact1 -->
<section class="w3l-contact-1">
	<div class="contacts-9 py-5">
		<div class="container py-lg-4">
			<div class="headerhny-title text-center">
				<h4 class="sub-title text-center">Register with us</h4>
				<h3 class="hny-title mb-0">Book My SHow</h3>
			</div>
			
					<center>

						<div class="wrapper" style="">
							<div class="title-text">

								<div class="title signup">Signup Form</div>
							</div>
							<div class="form-container">
								<div class="form-inner">

									<form method="post" action="register" class="signup">
										<div class="field">
											<input type="text" placeholder="Enter Name" name="uname"
												required>
										</div>
										<div class="field">
											<input type="text" placeholder="Enter Email" name="email"
												reguired>
										</div>

										<div class="field">
											<input type="text" list="genders" name="gender"
												placeholder="Gender" required autocomplete="off" />
											<datalist id="genders">
												<option>Male</option>
												<option>Female</option>
												<option>Others</option>
											</datalist>
										</div>
										<div class="field">

											<input type="number" maxlength="10" name="phone"
												id="w3lPhone" placeholder="Enter your Phone Number" required />
										</div>


										<div class="field">

											<input type="password" name="pwd" id="w3lPhone"
												placeholder="Enter your password" autocomplete="off"
												required />
										</div>
										<div class="field">

											<input type="password" name="cpwd" id="w3lPhone"
												placeholder="Confirm your password" required />
										</div>
										<div class="field btn">
											<div class="btn-layer"></div>
											<input type="submit" value="Signup">
										</div>
									</form>
								</div>
							</div>
						</div>

					</center>


					<jsp:include page="msg.jsp"></jsp:include>
				</div>

				<div class="d-grid contact-addres-inf mt-5 pt-lg-4">
					<div class="contact-info-left d-grid">
						<div class="contact-info">
							<div class="icon">
								<span class="fa fa-location-arrow" aria-hidden="true"></span>
							</div>
							<div class="contact-details">
								<h4>Address:</h4>
								<p>Pune</p>
							</div>
						</div>
						<div class="contact-info">
							<div class="icon">
								<span class="fa fa-phone" aria-hidden="true"></span>
							</div>
							<div class="contact-details">
								<h4>Phone:</h4>
								<p>
									<a href="https://www.linkedin.com/in/shubham-chakole-245967157">+91
										8055899488</a>
								</p>

							</div>
						</div>
						<div class="contact-info">
							<div class="icon">
								<span class="fa fa-envelope-open-o" aria-hidden="true"></span>
							</div>
							<div class="contact-details">
								<h4>Mail:</h4>
								<p>
									<a href="https://mail.google.com/mail" class="email">bookmyshow@gmail.com</a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<script type="text/javascript">
	
</script>
<!-- /contact1 -->
<jsp:include page="footer.jsp"></jsp:include>