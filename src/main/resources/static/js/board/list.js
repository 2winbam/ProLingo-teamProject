function pagingFormSubmit(currentPage) {
	let form = document.getElementById('pagingForm');
	let page = document.getElementById('page');
	page.value = currentPage;
	form.submit();
}