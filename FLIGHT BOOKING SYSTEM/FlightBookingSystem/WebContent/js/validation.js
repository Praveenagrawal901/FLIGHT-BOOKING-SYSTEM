function validate(){

		var email =document.login.login_email.value;
		var pass =document.login.login_password.value;
		if(pass=='' && pass<=6 && email==''){
			alert("Wrong credentials");
			return false;
		}else{
			return true;
		}
	}
	
function validatepass(){
	var pass= document.signup.signup_password.value;
	var pass1=document.signup.signup_password1.value;
	if(pass==pass1){
		return true;
	}else{
		alert("password does not match!");
		return false;
	}
	
}




$(document).ready(function(){
  $("#signup_password1").click(function(){
    alert("ReEnter password same as password");
  });
});