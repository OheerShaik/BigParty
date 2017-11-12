function navRegPage() {
      var path = window.location.pathname.match("resources");
      if(path == null){
            window.location="resources/html/regpage.html";
      }
      else {
        var doc = document.createElement('script')
    var stIndx = window.location.pathname.match("resources").index-1;
    var endIndx = window.location.pathname.match("html").index + "html".length;
    window.location=window.location.pathname.substring(0,endIndx)+"/regpage.html";
      }
}