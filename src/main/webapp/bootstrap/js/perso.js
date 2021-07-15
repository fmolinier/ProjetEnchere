function verifyAnswer() {
	//disable all the radio button 
	document.getElementById("csharp").disabled = true;
	document.getElementById("js").disabled = true;
	document.getElementById("angular").disabled = true;

	//get the value if checkbox is checked
	var achat = document.getElementById("achat").checked;
	var vente = document.getElementById("vente").checked;
	if (achat == true) {
		//enable all the radio button
		document.getElementById("csharp").disabled = false;
		document.getElementById("js").disabled = false;
		document.getElementById("angular").disabled = false;
		document.getElementById("vente").checked = false;
	} else if (vente == true) {
		document.getElementById("csharp").disabled = false;
		document.getElementById("js").disabled = false;
		document.getElementById("angular").disabled = false;
		document.getElementById("achat").checked = false;
	}
}