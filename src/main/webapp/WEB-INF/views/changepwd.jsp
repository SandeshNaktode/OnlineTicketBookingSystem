<jsp:include page="dheader.jsp"></jsp:include>
<div class="container">
    <h2 class="text-center p-2">Change Password</h2>
    <div class="row">
        <div class="col-sm-5 mx-auto">
            <jsp:include page="msg.jsp"/>
            <form method="post" >
                <div class="form-group">
                    <label>Enter UserID</label>
                    <input type="text" required class="form-control" name="userId" placeholder="Enter UserId">
                </div>                
                <div class="form-group">
                    <label>Current Password</label>
                    <input type="password" required class="form-control" name="oldPassword" placeholder="Current Password">
                </div>
                <div class="form-group">
                    <label>New Password</label>
                    <input type="password" required class="form-control" name="newPassword" placeholder="New Password">
                </div>
                <div class="form-group">
                    <label>Confirm Password</label>
                    <input type="password" required class="form-control" name="cPassword" placeholder="Confirm Password">
                </div>
                <input type="submit" class="btn btn-success btn-block" value="Change Password">
            </form>
        </div>
    </div>
</div>
<jsp:include page="dfooter.jsp"></jsp:include>