i =1;
var loginValidate = function (){
    username = document.getElementById('username');
    password = document.getElementById('password');
    if ((username.value.trim() == '') || (password.value.trim() == '')) {
        console.log('hello');
        if (username.value.trim() == '') { window.alert('Username Empty'); }
        if (password.value.trim() == '') { window.alert('password Empty'); }
        document.getElementById('alertmessage').innerHTML = 'you cannot login please try again';
    } else {
        window.alert('Login suceessfully');
        window.location='html/dashbord.html';
    }
};

var passswordValidate = function (){
    oldPassword = document.getElementById('oldpassword');
    newPassword = document.getElementById('newpassword');
    confirmPassword = document.getElementById('confirmpassword');
    if ((oldPassword.value.trim() == '') || (newPassword.value.trim() == '') || (confirmPassword.value.trim() == '')) {
        window.alert('password fields should not be empty');
        document.getElementById('alertmessage').innerHTML = 'cannot reset please try again';
    } else if (newPassword.value == confirmpassword.value) {
        window.alert('reset sucessfully');
    } else {
        window.alert('sorry cannot reset password mismatch');
        document.getElementById('alertmessage').innerHTML = 'cannot reset please try again';
    }
};

setTimeout(myFunction, 5000);
function myFunction() {
    document.getElementById('count').innerHTML = i;
    i= i+1;
    setTimeout(myFunction, 5000);
}
