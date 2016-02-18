/**
 * 
 */


	
	
	
	
	
	
	
	
	
	function addTelefono()
	{

	var telefonos=	document.getElementById("telefonos-persona");

	telefonos.innerHTML=telefonos.innerHTML+"<option>"+document.getElementById("telefono-persona").value+"</option>";

	$('select').material_select();
	
	}
	function getSelectedOptions(sel) {
	    var opts = [], opt;
	    
	    // loop through options in select list
	    for (var i=0, len=sel.options.length; i<len; i++) {
	        opt = sel.options[i];
	        
	        // check if selected
	        if ( opt.selected ) {
	            opts.push(opt);
	            
	            
	        }
	    }
	    
	    // return array containing references to selected option elements
	    return opts;
	}
	function getOptions(sel)
	{
	    var opts = [], opt;
	    
	    // loop through options in select list
	    for (var i=0, len=sel.options.length; i<len; i++) {
	        opt = sel.options[i];
	        
	        // check if selected
	  
	            opts.push(opt);
	            
	            
	        
	    }
	    
	    // return array containing references to selected option elements
	    return opts;
	}
	function getOptionsSeparated(sel)
	{
	var options=	getOptions(sel);
	var string="";
	for(var i=1;i<options.length;i++)
		{
		  string+=options[i].value+";"
		}
		
	return string;
	}
	function quitTelefono()
	{alert("z");
		var telefonos=	document.getElementById("telefonos-persona");
	telefonos.selected
		var selectedOptions=  getSelectedOptions(telefonos);
		
		for(var i=1;i<selectedOptions.length;i++)
			{
                selectedOptions[i].remove();
			}
		

		$('select').material_select();
		
		
	}

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
	function showModal(text)
	{
		 $('#modal-text').html(text);
		  $('#modal1').openModal();
	}
	function postData(url,element_id)
	{

		  var xhttp = new XMLHttpRequest();
		  
		xhttp.onreadystatechange = function() {
			    if (xhttp.readyState == 4 && xhttp.status == 200) {
			    	
				    

	               if(element!="undefined")
	            	   {
		
	   var element = document.getElementById(element_id);

	 //  alert(xhttp.responseText);
	               element.innerHTML=element.innerHTML+xhttp.responseText;
	            	   }

			   	    }
			   	  };
			   	 
			   	  
		  xhttp.open("POST",url, true);

		  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	 xhttp.send();

	}