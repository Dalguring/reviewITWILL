/**
 * 
 */
 function login(id, passwd) {
	var i;
	if(id=="admin" && passwd=="1234") {
		i = true;
	} else {
		i = false;
	}
	//if문은 양자택일이기에 if ~ return x , else ~ return y 의 꼴로 해도 상관없음
	return i;
}
 
 
 