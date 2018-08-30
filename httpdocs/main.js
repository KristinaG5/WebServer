function openNav() {
	if (document.getElementById("mySidenav").style.width == "250px"){
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
	document.getElementById("mainBox").style.width= "75%";
	document.getElementById("mainBox").style.marginLeft= "auto";
	document.getElementById("mySidenav").style.display = "none";
   	} else {
	document.getElementById("mySidenav").style.width = "250px";
	document.getElementById("mySidenav").style.display = "block";
    document.getElementById("main").style.marginLeft = "250px";
	document.getElementById("mainBox").style.width= "68%";
	document.getElementById("mainBox").style.marginLeft= "24%";
	}
}


window.onscroll = function() {scrollFunction()};

function scrollFunction() {
    if (document.body.scrollTop > 280 || document.documentElement.scrollTop > 280) {
        document.getElementById("myBtn").style.display = "block";
    } else {
        document.getElementById("myBtn").style.display = "none";
    }
}
function topFunction() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
}

function search() {
 
   var name = document.getElementById("searchForm").elements["searchItem"].value;
   var pattern = name.toLowerCase();
   var targetId = "";
 
   var divs = document.getElementsByClassName("col-md-2");
   for (var i = 0; i < divs.length; i++) {
      var para = divs[i].getElementsByTagName("p");
      var index = para[0].innerText.toLowerCase().indexOf(pattern);
      if (index != -1) {
         targetId = divs[i].parentNode.id;
         document.getElementById(targetId).scrollIntoView();
         break;
      }
   }  
}


