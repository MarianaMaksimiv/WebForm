if (window.addEventListener)
	window.addEventListener("load", init, false);

function get(id) {
	return document.getElementById(id);
}
var form;
function init() {

	form = document.forms[0];

	for (var j = 0; j < form.elements.length; j++) {
		var e = form.elements[j];

		if (e.type != "text") {
			continue;
		}

		var pattern = e.getAttribute("data-val");

		if (pattern) {
			e.onchange = validateInput;
		}
		if (e.getAttribute("data-data")) {
			e.onblur = blurForData;
		}
		form.onsubmit = validateForm;
	}

}

function blurForData() {
	if (this.length != 0) {
		this.className = "valid";
	} else {
		this.className = "invalid";
	}

}

function validateInput() {

	var pattern = this.dataset.val, msg = this.dataset.valMsg, msgId = this.dataset.valMsgId, value = this.value;
	var ageInput = get("age");
	var adressInput = get("adress");
	var res = value.search(pattern);

	if (this != ageInput && this != adressInput) {

		if (res == -1) {
			get(msgId).innerHTML = msg;
			this.className = "error";
		} else {
			get(msgId).innerHTML = "";
			this.className = "valid";
		}
	} else if (this == ageInput) {

		if (null !== value) {
			if (/^\d{1,3}$/.test(value) && +value >= 0 && +value <= 99) {
				get(msgId).innerHTML = "";
				this.className = "valid";
			} else {
				get(msgId).innerHTML = msg;
				this.className = "error";
			}

		}

	} else {
		if (this.value != " ") {
			this.className = "valid";
		}

	}

}

function validateForm() {

	var invalid = false;

	for (var i = 0; i < this.elements.length; ++i) {
		var e = this.elements[i];
		if (e.type == "text" && e.onchange != null) {
			e.onchange();
			if (e.className == "error")
				invalid = true;
		}
	}

	if (invalid) {
		return false;
	}
}