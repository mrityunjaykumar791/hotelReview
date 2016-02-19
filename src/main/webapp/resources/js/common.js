
function passValidate() { 
    var pass=document.getElementById('password').value;
    var cnfPass=document.getElementById('cnfPassword').value;
    if(pass == cnfPass)
     {
		document.getElementById('password').style.color="green";
		document.getElementById('cnfPassword').style.color="green";	
	}
	else
	{
		document.getElementById('password').value='';
		document.getElementById('cnfPassword').value='';
        document.getElementById('password').style.color="black";
		document.getElementById('cnfPassword').style.color="black";
	}
} 