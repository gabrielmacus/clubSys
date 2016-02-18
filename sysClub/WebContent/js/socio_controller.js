/**
 * 
 */
window.onload = function() {
	
	
	$('select').material_select();
	
	loadSocios();
	
	document.getElementById("add-form").onsubmit= function(e)
	{//e.preventDefault();

		submitSocio();e.preventDefault();
	}
	
	};


	function submitSocio()
	{
		  var xhttp = new XMLHttpRequest();
		  
			xhttp.onreadystatechange = function() {
				    if (xhttp.readyState == 4 && xhttp.status == 200) {
				    	
                      if(xhttp.responseText.trim()==="f")
                    	  {

                    showModal("Error al cargar el socio. Revise los datos ingresados");
                    	  }
		          

				   	    }
				   	  };
				   	 
				   	  
			  xhttp.open("POST","addsocio", true);

			  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			  
			  var nombre =document.getElementById("nombre-persona").value;
			  var apellido=document.getElementById("apellido-persona").value;
			  var direccion = document.getElementById("direccion-persona").value;
			  var dni = document.getElementById("dni-persona").value;
			  var telefonos = getOptionsSeparated(	document.getElementById("telefonos-persona"));
			  var nroSocio= 	document.getElementById("numero-socio").value;
		 xhttp.send("nombre-persona="+nombre+"&apellido-persona="+apellido+"&direccion-persona="+direccion+"&dni-persona="+dni+"&telefonos-persona="+telefonos+"&numero-socio="+nroSocio);
	}
	function loadSocios()
	{
	    postData("loadsocios", "lista-socios");
	}
	
	
	
	
	
	
	
	
	