/**
 * 
 */
String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
}

String.prototype.isStrEmpty = function() {
	return this.trim() == "" || this == null;
}