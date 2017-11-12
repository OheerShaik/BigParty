function validName() {
    
    var regx = /^[a-zA-Z\s]+$/;
    var uname = document.getElementById('uname').value;
    
    if(regx.test(uname)){
        document.getElementById('unamevalid').innerHTML = '';
        var ctxpath = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
        return true;
    }else {
        document.getElementById('unamevalid').innerHTML = 'Please Enter the valid Name';
    }
    
    console.log("Inside ValidName");
    
    
    
    
}