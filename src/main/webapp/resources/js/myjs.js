function setNavActive(action){
	var actionItem = document.getElementById(action);
	actionItem.classList.add('active');
	
	deleteActiveForOthers(action);
}

function deleteActiveForOthers(action){
	if (action == "userInfo"){
		document.getElementById("createTesting").classList.remove('active');
		document.getElementById("testingHistory").classList.remove('active');
	} else if (action == "createTesting"){
		document.getElementById("userInfo").classList.remove('active');
		document.getElementById("testingHistory").classList.remove('active');
	} else if (action == "testingHistory"){
		document.getElementById("userInfo").classList.remove('active');
		document.getElementById("createTesting").classList.remove('active');
	}
}