function sendRequest(){

var reqe;
  console.log("Inside sendRequest");
  var params = "lorem=ipsum&name=binny";
  try {
    reqe = new XMLHttpRequest();
    //reqe= createCORSRequest("POST", "http://localhost:9090/EduWorld/HISServices/hmCntrl/getHomePAGE")
    reqe.open("POST", "http://localhost:9090/EduWorld/HISServices/hmCntrl/getHomePAGE",true);


    reqe.setRequestHeader('Access-Control-Allow-Origin', '*');
    reqe.setRequestHeader('Access-Control-Allow-Methods', 'GET, PUT, POST, DELETE, OPTIONS');
    reqe.setRequestHeader('Access-Control-Allow-Headers', 'Content-Type, Content-Range, Content-Disposition, Content-Description');
    //reqe.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    //reqe.setRequestHeader("Access-Control-Allow-Origin","*");
    reqe.setRequestHeader("X-Auth-Token","AEBEkC2ieuGe/YoXOI+8m5SNmpkj2uFeltUD32Rf1EZiJmxFcl8j0IP0AP3RiaxuZh4EK3UH4wI=");
    //reqe.setRequestHeader('myname','myname')

    reqe.onreadystatechange = function(){
 if(reqe.readyState == 4 && reqe.status==200){
   var respo = reqe.responseText;
 document.getElementById('my_text').innerHTML=respo;
// ajaxDisplay.innerHTML = ajaxRequest.responseText;
console.log("Sucess");
 }
}
reqe.send(params);

  } catch (e) {
      try {
        req = new ActiveXObject("Msxml2.XMLHTTP");

      } catch (e) {
        try {
          req = new ActiveXObject("Microsoft.XMLHTTP");
        } catch (e) {
          alert("Your browser broke!");
          return false;
        } finally {

        }

      } finally {

      }
  } finally {

  }



}
