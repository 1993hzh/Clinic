/**
 * 
 */
String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
}

function isEmpty(str) {
	if (str == null || str.trim == "") {
		return true;
	} else {
		return false;
	}
}

function delete_message(id, type, src) {
	$.ajax({
		url : 'clinic/message!delete.action',
		type : 'post',
		data : {
			ids : id,
			lookType : type
		},
		success : function(msg) {
			if (msg == "true") {
				$(src).parent().parent().remove();
			} else {
				alert(msg);
			}
		}
	})
}

function create_message() {
	var theme = $("#theme").val;
	var content = $("#content").val;
	var receiver = $("#accounts").val;
	if (isEmpty(theme) || isEmpty(content) || isEmpty(receiver)) {
		alert("Check receiver, theme, content, make sure that they are not empty!");
		return false;
	}
	$.ajax({
		url : 'clinic/message!create.action',
		type : 'post',
		data : $("#newMessage").serialize(),
		success : function(msg) {
			if (msg == "true") {
				window.location.href = 'clinic/message!listSent.action';
			} else {
				alert(msg);
			}
		}
	})
}