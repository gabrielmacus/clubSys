/**
 * 
 */
$(document).ready(function()
		{
	
    $('select').material_select();
	
		});
function toggleElement(toggled_id)
{
	var element=document.getElementById(toggled_id);
var state=	element.getAttribute('hidden');
if(state!=null)
	{
      element.removeAttribute("hidden");
	}
else
	{
element.setAttribute("hidden", "");
	}


	
	}
	
	function hideElement(element_id)
	{
		var element=document.getElementById(element_id);
		element.setAttribute("hidden", "");
		
	}
function postData(url,element_id)
{

	  var xhttp = new XMLHttpRequest();
	  
	xhttp.onreadystatechange = function() {
		    if (xhttp.readyState == 4 && xhttp.status == 200) {
		    	
			    

               
	
   var element = document.getElementById(element_id);

               element.innerHTML=xhttp.responseText;

		   	    }
		   	  };
		   	 
		   	  
	  xhttp.open("POST",url, true);
 xhttp.send();

}