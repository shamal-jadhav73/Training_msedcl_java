alert("js loaded");
function validateForm() {
    const fileName = document.getElementById("file");
    if (!fileName.value) {
        alert("Please select File");
        return false;  //to stop form submit
    }

	return true;
}